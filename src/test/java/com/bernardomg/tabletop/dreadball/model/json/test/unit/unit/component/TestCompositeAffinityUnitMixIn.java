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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.unit.component;

import java.util.ArrayList;
import java.util.Collection;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.bernardomg.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.component.ComponentLocationMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.component.ComponentMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.component.CompositeAffinityUnitMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.stats.AttributesMixIn;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.unit.Role;
import com.bernardomg.tabletop.dreadball.model.unit.component.Component;
import com.bernardomg.tabletop.dreadball.model.unit.component.ComponentLocation;
import com.bernardomg.tabletop.dreadball.model.unit.component.CompositeAffinityUnit;
import com.bernardomg.tabletop.dreadball.model.unit.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.unit.stats.Attributes;

/**
 * Unit tests for {@link CompositeAffinityUnitMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestCompositeAffinityUnitMixIn {

    /**
     * Default constructor.
     */
    public TestCompositeAffinityUnitMixIn() {
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

        Assert.assertEquals(value, "ability_name");
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

        Assert.assertEquals(value, "affinity_group");
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

        Assert.assertEquals(value, 5);
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

        Assert.assertEquals(value, 1);
    }

    /**
     * Tests that the JSON message is created with the correct components.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Components() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.components[0].name");

        Assert.assertEquals(value, "component_name");
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

        Assert.assertEquals(value, 10);
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

        Assert.assertEquals(value, 6);
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

        Assert.assertEquals(value, "affinity_group_2");
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

        Assert.assertEquals(value, "name");
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

        Assert.assertEquals(value, "striker");
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

        Assert.assertEquals(value, 7);
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

        Assert.assertEquals(value, "unit_template");
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
        final Collection<Component> components;     // Unit components
        final Collection<Role> roles;               // Unit roles
        final CompositeAffinityUnit unit;           // Mocked unit
        final Ability ability;                      // Mocked ability
        final AffinityGroup affinity1;              // Mocked affinity
        final AffinityGroup affinity2;              // Mocked affinity
        final Attributes attributes;                // Mocked attributes
        final Component component;                  // Mocked component
        final ComponentLocation location;           // Mocked location

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(CompositeAffinityUnit.class,
                CompositeAffinityUnitMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(Attributes.class, AttributesMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);
        mapper.addMixIn(Component.class, ComponentMixIn.class);
        mapper.addMixIn(ComponentLocation.class, ComponentLocationMixIn.class);

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

        // Mocks location
        location = Mockito.mock(ComponentLocation.class);
        Mockito.when(location.getName()).thenReturn("component_location");

        // Sets roles
        roles = new ArrayList<>();
        roles.add(Role.STRIKER);
        roles.add(Role.JACK);

        // Mocks components
        components = new ArrayList<>();
        component = Mockito.mock(Component.class);
        Mockito.when(component.getAbilities()).thenReturn(abilities);
        Mockito.when(component.getAttributes()).thenReturn(attributes);
        Mockito.when(component.getName()).thenReturn("component_name");
        Mockito.when(component.getCost()).thenReturn(11);
        Mockito.when(component.getLocation()).thenReturn(location);
        Mockito.when(component.getRoles()).thenReturn(roles);
        components.add(component);

        // Mocks unit
        unit = Mockito.mock(CompositeAffinityUnit.class);
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
        Mockito.when(unit.getComponents()).thenReturn(components);

        return mapper.writer().writeValueAsString(unit);
    }

}
