/*
 * Copyright 2013-2014 eBay Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kylinolap.common.util;

import java.io.File;

/**
 * @author ysong1
 */
public class HBaseMetadataTestCase extends AbstractKylinTestCase {

    static {
        if (useSandbox()) {
            try {
                ClasspathUtil.addClasspath(new File("../examples/test_case_data/sandbox/").getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createTestMetadata() throws Exception {
        staticCreateTestMetadata();
    }

    @Override
    public void cleanupTestMetadata() {
        HBaseMetadataTestCase.staticCleanupTestMetadata();
    }

    public static void staticCreateTestMetadata() throws Exception {
        if (useSandbox()) {
            staticCreateTestMetadata(AbstractKylinTestCase.SANDBOX_TEST_DATA);
        } else {
            staticCreateTestMetadata(AbstractKylinTestCase.MINICLUSTER_TEST_DATA);
            HBaseMiniclusterMetadataTestCase.startupMinicluster();
        }

    }

    public static boolean useSandbox() {
        String useSandbox = System.getProperty("useSandbox");
        return Boolean.parseBoolean(useSandbox);
    }

}
