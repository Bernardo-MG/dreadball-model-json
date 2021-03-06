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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.player;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.json.player.AdvancementTeamPlayerMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AbilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AttributesMixIn;
import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.component.Component;
import com.bernardomg.tabletop.dreadball.model.player.component.ComponentLocation;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * Unit tests for {@link AdvancementTeamPlayer}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestAdvancementTeamPlayerMixIn {

    /**
     * Default constructor.
     */
    public TestAdvancementTeamPlayerMixIn() {
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
     * Tests that the JSON message is created with the correct grafted implant.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_GraftedImplant() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.graftedImplant");

        Assert.assertEquals(null, value);
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
     * Tests that the JSON message is created with the correct rank.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Rank() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.rank");

        Assert.assertEquals(20, value);
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

        Assert.assertEquals("player_template", value);
    }

    /**
     * Tests that the JSON message is created with the correct unspent
     * experience.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_UnspentExperience() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.unspentExperience");

        Assert.assertEquals(30, value);
    }

    /**
     * Tests that the JSON message is created with the correct unspent
     * experience.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Valoration() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.valoration");

        Assert.assertEquals(40, value);
    }

    /**
     * Returns the generated JSON to be tested.
     * 
     * @return the tested JSON
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    private final String getJson() throws JsonProcessingException {
        final ObjectMapper mapper;           // Mapper for the JSON
        final Collection<Ability> abilities; // Player abilities
        final AdvancementTeamPlayer player;  // Mocked player
        final Ability ability;               // Mocked ability
        final Attributes attributes;         // Mocked attributes
        final Component implant;             // Mocked component
        final ComponentLocation location;    // Mocked location
        final Collection<Role> roles;        // Player positions

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(AdvancementTeamPlayer.class,
                AdvancementTeamPlayerMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(Attributes.class, AttributesMixIn.class);

        // Mocks abilities
        abilities = new ArrayList<>();
        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getName()).thenReturn("ability_name");
        abilities.add(ability);

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

        // Mocks implant
        implant = Mockito.mock(Component.class);
        Mockito.when(implant.getAbilities()).thenReturn(abilities);
        Mockito.when(implant.getAttributes()).thenReturn(attributes);
        Mockito.when(implant.getName()).thenReturn("component_name");
        Mockito.when(implant.getCost()).thenReturn(10);
        Mockito.when(implant.getLocation()).thenReturn(location);
        Mockito.when(implant.getRoles()).thenReturn(roles);

        // Mocks player
        player = Mockito.mock(AdvancementTeamPlayer.class);
        Mockito.when(player.getName()).thenReturn("name");
        Mockito.when(player.getAbilities()).thenReturn(abilities);
        Mockito.when(player.getAttributes()).thenReturn(attributes);
        Mockito.when(player.getCost()).thenReturn(10);
        Mockito.when(player.getRole()).thenReturn(Role.STRIKER);
        Mockito.when(player.getTemplateName()).thenReturn("player_template");
        Mockito.when(player.getMvp()).thenReturn(true);
        Mockito.when(player.getGiant()).thenReturn(true);
        Mockito.when(player.getRank()).thenReturn(20);
        Mockito.when(player.getUnspentExperience()).thenReturn(30);
        Mockito.when(player.getValoration()).thenReturn(40);

        return mapper.writer().writeValueAsString(player);
    }

}
