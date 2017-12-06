/**
 * Copyright 2015 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.bernardomg.tabletop.dreadball.model.json.test.unit.unit.stats;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.bernardomg.tabletop.dreadball.model.unit.stats.Ability;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * Unit tests for {@link AbilityMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestAbilityMixin {

    /**
     * Default constructor.
     */
    public TestAbilityMixin() {
        super();
    }

    /**
     * Tests that the JSON message is created with the correct name.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Name() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.name");

        Assert.assertEquals(value, "ability_name");
    }

    /**
     * Returns the generated JSON to be tested.
     * 
     * @return the tested JSON
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    private final String getJson() throws JsonProcessingException {
        final ObjectMapper mapper; // Mapper for the JSON
        final Ability ability;     // Mocked ability

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(Ability.class, AbilityMixIn.class);

        // Mocks ability
        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getName()).thenReturn("ability_name");

        return mapper.writer().writeValueAsString(ability);
    }

}
