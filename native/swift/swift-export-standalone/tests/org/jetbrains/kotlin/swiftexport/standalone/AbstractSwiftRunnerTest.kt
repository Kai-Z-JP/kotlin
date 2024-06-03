/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.swiftexport.standalone

import com.intellij.openapi.util.io.FileUtil
import org.jetbrains.kotlin.konan.target.Distribution
import org.jetbrains.kotlin.konan.test.blackbox.AbstractNativeSwiftExportTest
import org.jetbrains.kotlin.konan.test.blackbox.compileToNativeKLib
import org.jetbrains.kotlin.konan.test.blackbox.support.TestCase
import org.jetbrains.kotlin.konan.test.blackbox.support.compilation.TestCompilationArtifact
import org.jetbrains.kotlin.test.KotlinTestUtils
import java.io.File
import java.util.Properties
import kotlin.io.path.*
import kotlin.test.assertSame

abstract class AbstractKlibBasedSwiftRunnerTest : AbstractSwiftRunnerTest(
    renderDocComments = false, // in source mode we were able to render docs from the original kotlin. I believe without sources we have lost this ability?
)

abstract class AbstractSwiftRunnerTest(
    private val renderDocComments: Boolean,
) : AbstractNativeSwiftExportTest() {

    private val tmpdir = FileUtil.createTempDirectory("SwiftExportIntegrationTests", null, false)

    override fun runCompiledTest(
        testPathFull: File,
        testCase: TestCase,
        swiftExportOutput: SwiftExportModule,
        swiftModule: TestCompilationArtifact.Swift.Module,
    ) {
        assertSame(0, swiftExportOutput.dependencies.count(), "should produce module without children")

        val files = swiftExportOutput.files

        val expectedFiles = testPathFull.toPath() / "golden_result/"
        val expectedSwift = if (!renderDocComments && (expectedFiles / "result.no_comments.swift").exists()) {
            expectedFiles / "result.no_comments.swift"
        } else {
            expectedFiles / "result.swift"
        }
        val expectedCHeader = expectedFiles / "result.h"
        val expectedKotlinBridge = expectedFiles / "result.kt"

        KotlinTestUtils.assertEqualsToFile(expectedSwift, files.swiftApi.readText())
        KotlinTestUtils.assertEqualsToFile(expectedCHeader, files.cHeaderBridges.readText())
        KotlinTestUtils.assertEqualsToFile(expectedKotlinBridge, files.kotlinBridges.readText())
    }

    override fun constructSwiftInput(testPathFull: File): InputModule.Binary {
        val moduleRoot = testPathFull.toPath() / "input_root/"
        return InputModule.Binary(
            path = compileToNativeKLib(moduleRoot),
            name = "main"
        )
    }

    override fun constructSwiftExportConfig(testPathFull: File): SwiftExportConfig {
        val unsupportedTypeStrategy = ErrorTypeStrategy.Fail
        val errorTypeStrategy = ErrorTypeStrategy.Fail

        val defaultConfig: Map<String, String> = mapOf(
            SwiftExportConfig.STABLE_DECLARATIONS_ORDER to "true",
            SwiftExportConfig.RENDER_DOC_COMMENTS to (if (renderDocComments) "true" else "false"),
            SwiftExportConfig.BRIDGE_MODULE_NAME to SwiftExportConfig.DEFAULT_BRIDGE_MODULE_NAME,
        )

        var unsupportedDeclarationReporterKind = UnsupportedDeclarationReporterKind.Silent
        val discoveredConfig = (testPathFull.toPath() / "config.properties").takeIf { it.exists() }?.let { configPath ->
            Properties().apply { load(configPath.toFile().inputStream()) }.let { properties ->
                properties.propertyNames().asSequence()
                    .filterIsInstance<String>()
                    .associateWith { properties.getProperty(it) }
                    .filter { (key, value) -> when {
                        key == "unsupportedDeclarationsReporterKind" -> {
                            UnsupportedDeclarationReporterKind.entries
                                .singleOrNull { it.name.lowercase() == value.lowercase() }
                                ?.let { unsupportedDeclarationReporterKind = it }
                            false
                        }
                        else -> true
                    } }
            }
        } ?: emptyMap()

        val config = defaultConfig + discoveredConfig

        return SwiftExportConfig(
            settings = config,
            logger = createDummyLogger(),
            distribution = Distribution(KonanHome.konanHomePath),
            errorTypeStrategy = errorTypeStrategy,
            unsupportedTypeStrategy = unsupportedTypeStrategy,
            outputPath = tmpdir.toPath(),
            unsupportedDeclarationReporterKind = unsupportedDeclarationReporterKind,
        )
    }

    override fun collectKotlinFiles(testPathFull: File): List<File> =
        (testPathFull.toPath() / "input_root").toFile().walk().filter { it.extension == "kt" }.map { testPathFull.resolve(it) }.toList()
}

private object KonanHome {
    private const val KONAN_HOME_PROPERTY_KEY = "kotlin.internal.native.test.nativeHome"

    val konanHomePath: String
        get() = System.getProperty(KONAN_HOME_PROPERTY_KEY)
            ?: error("Missing System property: '$KONAN_HOME_PROPERTY_KEY'")
}
