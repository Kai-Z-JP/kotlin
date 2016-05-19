/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.codegen;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/java8/box")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class BlackBoxWithJava8CodegenTestGenerated extends AbstractBlackBoxCodegenTest {
    public void testAllFilesPresentInBox() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/java8/box"), Pattern.compile("^(.+)\\.kt$"), true);
    }

    @TestMetadata("async.kt")
    public void testAsync() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/async.kt");
        doTest(fileName);
    }

    @TestMetadata("asyncException.kt")
    public void testAsyncException() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/asyncException.kt");
        doTest(fileName);
    }

    @TestMetadata("defaultMethodCallFromInterface.kt")
    public void testDefaultMethodCallFromInterface() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/defaultMethodCallFromInterface.kt");
        doTest(fileName);
    }

    @TestMetadata("defaultMethodCallViaClass.kt")
    public void testDefaultMethodCallViaClass() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/defaultMethodCallViaClass.kt");
        doTest(fileName);
    }

    @TestMetadata("defaultMethodCallViaInterface.kt")
    public void testDefaultMethodCallViaInterface() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/defaultMethodCallViaInterface.kt");
        doTest(fileName);
    }

    @TestMetadata("defaultMethodOverride.kt")
    public void testDefaultMethodOverride() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/defaultMethodOverride.kt");
        doTest(fileName);
    }

    @TestMetadata("dontDelegateToDefaultMethods.kt")
    public void testDontDelegateToDefaultMethods() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/dontDelegateToDefaultMethods.kt");
        doTest(fileName);
    }

    @TestMetadata("inheritKotlin.kt")
    public void testInheritKotlin() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/inheritKotlin.kt");
        doTest(fileName);
    }

    @TestMetadata("invokeDefaultViaSuper.kt")
    public void testInvokeDefaultViaSuper() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/invokeDefaultViaSuper.kt");
        doTest(fileName);
    }

    @TestMetadata("longChainOfKotlinExtendsFromJavaWithDefault.kt")
    public void testLongChainOfKotlinExtendsFromJavaWithDefault() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/longChainOfKotlinExtendsFromJavaWithDefault.kt");
        doTest(fileName);
    }

    @TestMetadata("removeIf.kt")
    public void testRemoveIf() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/removeIf.kt");
        doTest(fileName);
    }

    @TestMetadata("samOnInterfaceWithDefaultMethod.kt")
    public void testSamOnInterfaceWithDefaultMethod() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/samOnInterfaceWithDefaultMethod.kt");
        doTest(fileName);
    }

    @TestMetadata("stream.kt")
    public void testStream() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/stream.kt");
        doTest(fileName);
    }

    @TestMetadata("useStream.kt")
    public void testUseStream() throws Exception {
        String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/useStream.kt");
        doTest(fileName);
    }

    @TestMetadata("compiler/testData/codegen/java8/box/jvm8")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Jvm8 extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInJvm8() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/java8/box/jvm8"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("bridgeInClass.kt")
        public void testBridgeInClass() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/jvm8/bridgeInClass.kt");
            doTest(fileName);
        }

        @TestMetadata("bridgeInInterface.kt")
        public void testBridgeInInterface() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/jvm8/bridgeInInterface.kt");
            doTest(fileName);
        }

        @TestMetadata("simpleCall.kt")
        public void testSimpleCall() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/jvm8/simpleCall.kt");
            doTest(fileName);
        }

        @TestMetadata("compiler/testData/codegen/java8/box/jvm8/noDelegation")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class NoDelegation extends AbstractBlackBoxCodegenTest {
            public void testAllFilesPresentInNoDelegation() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/java8/box/jvm8/noDelegation"), Pattern.compile("^(.+)\\.kt$"), true);
            }

            @TestMetadata("noDelegationToDefaultMethodInClass.kt")
            public void testNoDelegationToDefaultMethodInClass() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/jvm8/noDelegation/noDelegationToDefaultMethodInClass.kt");
                doTest(fileName);
            }

            @TestMetadata("noDelegationToDefaultMethodInInterface.kt")
            public void testNoDelegationToDefaultMethodInInterface() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/jvm8/noDelegation/noDelegationToDefaultMethodInInterface.kt");
                doTest(fileName);
            }

            @TestMetadata("noDelegationToDefaultMethodInInterface2.kt")
            public void testNoDelegationToDefaultMethodInInterface2() throws Exception {
                String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/jvm8/noDelegation/noDelegationToDefaultMethodInInterface2.kt");
                doTest(fileName);
            }
        }
    }

    @TestMetadata("compiler/testData/codegen/java8/box/mapRemove")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class MapRemove extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInMapRemove() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/java8/box/mapRemove"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("readOnlyMap.kt")
        public void testReadOnlyMap() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/mapRemove/readOnlyMap.kt");
            doTest(fileName);
        }

        @TestMetadata("typeSafeBridge.kt")
        public void testTypeSafeBridge() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/mapRemove/typeSafeBridge.kt");
            doTest(fileName);
        }

        @TestMetadata("typeSafeBridgeNotNullAny.kt")
        public void testTypeSafeBridgeNotNullAny() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/mapRemove/typeSafeBridgeNotNullAny.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("compiler/testData/codegen/java8/box/reflection")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Reflection extends AbstractBlackBoxCodegenTest {
        public void testAllFilesPresentInReflection() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/java8/box/reflection"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("realParameterNames.kt")
        public void testRealParameterNames() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/reflection/realParameterNames.kt");
            doTest(fileName);
        }

        @TestMetadata("synthesizedParameterNames.kt")
        public void testSynthesizedParameterNames() throws Exception {
            String fileName = KotlinTestUtils.navigationMetadata("compiler/testData/codegen/java8/box/reflection/synthesizedParameterNames.kt");
            doTest(fileName);
        }
    }
}
