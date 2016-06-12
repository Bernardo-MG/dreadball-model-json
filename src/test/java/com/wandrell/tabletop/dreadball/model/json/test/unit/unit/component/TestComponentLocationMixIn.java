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

package com.wandrell.tabletop.dreadball.model.json.test.unit.unit.component;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.json.unit.component.ComponentLocationMixIn;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;

/**
 * Unit tests for {@link ComponentLocationMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestComponentLocationMixIn {

    /**
     * Default constructor.
     */
    public TestComponentLocationMixIn() {
        super();
    }

    /**
     * Tests that the JSON message is created correctly.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;        // Mapper for the JSON
        final ObjectWriter writer;        // Writer for the JSON
        final ComponentLocation location; // Mocked location

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(ComponentLocation.class, ComponentLocationMixIn.class);

        // Mocks location
        location = Mockito.mock(ComponentLocation.class);
        Mockito.when(location.getName()).thenReturn("component_location");

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(location),
                "{\"name\":\"component_location\"}");
    }

}
