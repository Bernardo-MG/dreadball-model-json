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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.availability.player;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.availability.player.TeamPlayerRangedAvailability;
import com.bernardomg.tabletop.dreadball.model.faction.TeamRule;
import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.json.availability.player.TeamPlayerRangedAvailabilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.bernardomg.tabletop.dreadball.model.json.faction.TeamTypeMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.TeamPlayerMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AbilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AttributesMixIn;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * Unit tests for {@link TeamPlayerRangedAvailability}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestTeamPlayerRangedAvailabilityMixIn {

    /**
     * Default constructor.
     */
    public TestTeamPlayerRangedAvailabilityMixIn() {
        super();
    }

    /**
     * Tests that the JSON message is created with the correct initial number.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_InitialNumber() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.initialNumber");

        Assert.assertEquals(1, value);
    }

    /**
     * Tests that the JSON message is created with the correct maximum number.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_MaxNumber() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.maxNumber");

        Assert.assertEquals(2, value);
    }

    /**
     * Tests that the JSON message is created with the correct team type.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_TeamType() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.teamType.name");

        Assert.assertEquals("team_name", value);
    }

    /**
     * Tests that the JSON message is created with the correct team type.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_TemplateName() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.teamPlayer.templateName");

        Assert.assertEquals("player_template", value);
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
        final Collection<TeamRule> rules;    // Team rules
        final Collection<Ability> abilities; // Player abilities
        final TeamRule rule;                 // Mocked rule
        final TeamType team;                 // Mocked team
        final TeamPlayerRangedAvailability ava; // Mocked ava
        final TeamPlayer player;             // Mocked player
        final Ability ability;               // Mocked ability
        final Attributes attributes;         // Mocked attributes

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);
        mapper.addMixIn(TeamType.class, TeamTypeMixIn.class);
        mapper.addMixIn(TeamPlayerRangedAvailability.class,
                TeamPlayerRangedAvailabilityMixIn.class);
        mapper.addMixIn(TeamPlayer.class, TeamPlayerMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(Attributes.class, AttributesMixIn.class);

        // Mocks rules
        rules = new ArrayList<>();
        rule = Mockito.mock(TeamRule.class);
        Mockito.when(rule.getName()).thenReturn("team_rule");
        rules.add(rule);

        // Mocks team
        team = Mockito.mock(TeamType.class);
        Mockito.when(team.getName()).thenReturn("team_name");
        Mockito.when(team.getTeamRules()).thenReturn(rules);

        // Mocks attributes
        attributes = Mockito.mock(Attributes.class);
        Mockito.when(attributes.getArmor()).thenReturn(1);
        Mockito.when(attributes.getMovement()).thenReturn(2);
        Mockito.when(attributes.getSkill()).thenReturn(3);
        Mockito.when(attributes.getSpeed()).thenReturn(4);
        Mockito.when(attributes.getStrength()).thenReturn(5);

        // Mocks abilities
        abilities = new ArrayList<>();
        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getName()).thenReturn("ability_name");
        abilities.add(ability);

        // Mocks unit
        player = Mockito.mock(TeamPlayer.class);
        Mockito.when(player.getName()).thenReturn("name");
        Mockito.when(player.getAbilities()).thenReturn(abilities);
        Mockito.when(player.getAttributes()).thenReturn(attributes);
        Mockito.when(player.getCost()).thenReturn(10);
        Mockito.when(player.getRole()).thenReturn(Role.STRIKER);
        Mockito.when(player.getTemplateName()).thenReturn("player_template");
        Mockito.when(player.getMvp()).thenReturn(true);
        Mockito.when(player.getGiant()).thenReturn(true);

        // Mocks availabilities
        ava = Mockito.mock(TeamPlayerRangedAvailability.class);
        Mockito.when(ava.getInitialNumber()).thenReturn(1);
        Mockito.when(ava.getMaxNumber()).thenReturn(2);
        Mockito.when(ava.getTeamType()).thenReturn(team);
        Mockito.when(ava.getTeamPlayer()).thenReturn(player);

        return mapper.writer().writeValueAsString(ava);
    }

}
