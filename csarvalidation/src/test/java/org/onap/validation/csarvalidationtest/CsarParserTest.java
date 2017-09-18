/**
 * Copyright 2017 Huawei Technologies Co., Ltd.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onap.validation.csarvalidationtest;

import org.junit.Test;
import org.onap.validation.csar.CsarParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CsarParserTest {
    CsarParser csarParser = new CsarParser();
    String regex = "^\\/[a-zA-Z]\\:\\/";
    ClassLoader classLoader = getClass().getClassLoader();
    Pattern pattern = Pattern.compile(regex);
    private String configFile = classLoader.getResource("enterprise2DC.csar").getFile();
    Matcher matcher = pattern.matcher(configFile);
    String dir2 = "/"+configFile.substring(1);

    @Test
    public void testValidateCsarMeta() {
        boolean result1 = csarParser.csarExtract(dir2);
        // assertEquals(true, result = true);
        boolean result = CsarParser.validateCsarMeta();
        assertEquals(true, result == true);
        System.out.println("inside testValidateCsarMeta : " + result);
    }

    @Test
    public void testValidateCsarIntegrity() {
        boolean result = csarParser.validateCsarIntegrity(dir2);
        assertEquals(true, result == true);
        System.out.println("inside testValidateCsarIntegrity : " + result);
    }

    @Test
    public void testValidateToscaMeta() {
        boolean result1 = csarParser.csarExtract(dir2);
        boolean result = csarParser.validateToscaMeta();
        assertEquals(true, result == true);
        System.out.println("inside testValidateToscaMeta : " + result);
    }

}



