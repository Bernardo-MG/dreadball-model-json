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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.unit;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.AffinityUnitMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.stats.AttributesMixIn;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityUnit;
import com.bernardomg.tabletop.dreadball.model.unit.Role;
import com.bernardomg.tabletop.dreadball.model.unit.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.unit.stats.Attributes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * Unit tests for {@link AffinityUnitMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestAffinityUnitMixIn {

    /**
     * Default constructor.
     */
    public TestAffinityUnitMixIn() {
        super();
    }

    /**
     * Tests that the JSON message is created with the correct abilities.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Abilities() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.abilities[0].name");

        Assert.assertEquals("ability_name", value);
    }

    /**
     * Tests that the JSON message is created with the correct affinity groups.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_AffinityGroups() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.affinityGroups[0].name");

        Assert.assertEquals("affinity_group", value);
    }

    /**
     * Tests that the JSON message is created with the correct ally cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_AllyCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.allyCost");

        Assert.assertEquals(5, value);
    }

    /**
     * Tests that the JSON message is created with the correct attributes.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Attributes() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.armor");

        Assert.assertEquals(1, value);
    }

    /**
     * Tests that the JSON message is created with the correct cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Cost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.cost");

        Assert.assertEquals(10, value);
    }

    /**
     * Tests that the JSON message is created with the correct friend cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_FriendCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.friendCost");

        Assert.assertEquals(6, value);
    }

    /**
     * Tests that the JSON message is created with the correct giant value.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Giant() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.giant");

        Assert.assertTrue((boolean) value);
    }

    /**
     * Tests that the JSON message is created with the correct hated affinity
     * groups.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_HatedAffinityGroups()
            throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.hatedAffinityGroups[0].name");

        Assert.assertEquals("affinity_group_2", value);
    }

    /**
     * Tests that the JSON message is created with the correct mvp value.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Mvp() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.mvp");

        Assert.assertTrue((boolean) value);
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

        Assert.assertEquals("name", value);
    }

    /**
     * Tests that the JSON message is created with the correct role.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Role() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.role");

        Assert.assertEquals("striker", value);
    }

    /**
     * Tests that the JSON message is created with the correct stranger cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_StrangerCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.strangerCost");

        Assert.assertEquals(7, value);
    }

    /**
     * Tests that the JSON message is created with the correct template name.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_TemplateName() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.templateName");

        Assert.assertEquals("unit_template", value);
    }

    /**
     * Returns the generated JSON to be tested.
     * 
     * @return the tested JSON
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    private final String getJson() throws JsonProcessingException {
        final ObjectMapper mapper;                  // Mapper for the JSON
        final Collection<Ability> abilities;        // Unit abilities
        final Collection<AffinityGroup> affinities; // Unit affinities
        final Collection<AffinityGroup> hated;      // Unit hated affinities
        final AffinityUnit unit;                    // Mocked unit
        final Ability ability;                      // Mocked ability
        final AffinityGroup affinity1;              // Mocked affinity
        final AffinityGroup affinity2;              // Mocked affinity
        final Attributes attributes;                // Mocked attributes

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(AffinityUnit.class, AffinityUnitMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(Attributes.class, AttributesMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);

        // Mocks abilities
        abilities = new ArrayList<>();
        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getName()).thenReturn("ability_name");
        abilities.add(ability);

        // Mocks affinities
        affinities = new ArrayList<>();
        affinity1 = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity1.getName()).thenReturn("affinity_group");
        affinities.add(affinity1);

        // Mocks hated affinities
        hated = new ArrayList<>();
        affinity2 = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity2.getName()).thenReturn("affinity_group_2");
        hated.add(affinity2);

        // Mocks attributes
        attributes = Mockito.mock(Attributes.class);
        Mockito.when(attributes.getArmor()).thenReturn(1);
        Mockito.when(attributes.getMovement()).thenReturn(2);
        Mockito.when(attributes.getSkill()).thenReturn(3);
        Mockito.when(attributes.getSpeed()).thenReturn(4);
        Mockito.when(attributes.getStrength()).thenReturn(5);

        // Mocks unit
        unit = Mockito.mock(AffinityUnit.class);
        Mockito.when(unit.getName()).thenReturn("name");
        Mockito.when(unit.getAbilities()).thenReturn(abilities);
        Mockito.when(unit.getAttributes()).thenReturn(attributes);
        Mockito.when(unit.getCost()).thenReturn(10);
        Mockito.when(unit.getRole()).thenReturn(Role.STRIKER);
        Mockito.when(unit.getTemplateName()).thenReturn("unit_template");
        Mockito.when(unit.getMvp()).thenReturn(true);
        Mockito.when(unit.getGiant()).thenReturn(true);
        Mockito.when(unit.getAffinityGroups()).thenReturn(affinities);
        Mockito.when(unit.getHatedAffinityGroups()).thenReturn(hated);
        Mockito.when(unit.getAllyCost()).thenReturn(5);
        Mockito.when(unit.getFriendCost()).thenReturn(6);
        Mockito.when(unit.getStrangerCost()).thenReturn(7);

        return mapper.writer().writeValueAsString(unit);
    }

}
