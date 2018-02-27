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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.faction.TeamRule;
import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.bernardomg.tabletop.dreadball.model.json.faction.TeamTypeMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.AdvancementTeamPlayerMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AbilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AttributesMixIn;
import com.bernardomg.tabletop.dreadball.model.json.team.AdvancementTeamMixIn;
import com.bernardomg.tabletop.dreadball.model.player.AdvancementTeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.bernardomg.tabletop.dreadball.model.team.AdvancementTeam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * Unit tests for {@link AdvancementTeamMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestAdvancementTeamMixIn {

    /**
     * Default constructor.
     */
    public TestAdvancementTeamMixIn() {
        super();
    }

    /**
     * Tests that the JSON message is created with the correct cash.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Cash() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.cash");

        Assert.assertEquals(3, value);
    }

    /**
     * Tests that the JSON message is created with the correct number of
     * cheerleaders.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Cheerleaders() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.cheerleaders");

        Assert.assertEquals(1, value);
    }

    /**
     * Tests that the JSON message is created with the correct number of
     * coaching dice.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_CoachingDice() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.coachingDice");

        Assert.assertEquals(2, value);
    }

    /**
     * Tests that the JSON message is created with the correct defensive
     * coaching staff value.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_DefensiveCoachingStaff()
            throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.defensiveCoachingStaff");

        Assert.assertEquals(false, value);
    }

    /**
     * Tests that the JSON message is created with the correct number of
     * dreadball cards.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_DreadballCards() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.dreadballCards");

        Assert.assertEquals(4, value);
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

        Assert.assertEquals("team_name", value);
    }

    /**
     * Tests that the JSON message is created with the correct offensive
     * coaching staff value.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_OffensiveCoachingStaff()
            throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.offensiveCoachingStaff");

        Assert.assertEquals(false, value);
    }

    /**
     * Tests that the JSON message is created with the players.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Players() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.players.1.name");

        Assert.assertEquals("name", value);
    }

    /**
     * Tests that the JSON message is created with the correct support coaching
     * staff value.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_SupportCoachingStaff()
            throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.supportCoachingStaff");

        Assert.assertEquals(false, value);
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
     * Tests that the JSON message is created with the correct total cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_TotalCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.totalCost");

        Assert.assertEquals(5, value);
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
        final Collection<AffinityGroup> affinities; // Sponsor affinities
        final Collection<Ability> abilities;        // Player abilities
        final Collection<TeamRule> rules;           // Team rules
        final Map<Integer, AdvancementTeamPlayer> players;  // Team player
        final AffinityGroup affinity;               // Mocked affinity
        final AdvancementTeam team;                 // Mocked team
        final AdvancementTeamPlayer player;         // Mocked player
        final Ability ability;                      // Mocked ability
        final Attributes attributes;                // Mocked attributes
        final TeamRule rule;                        // Mocked rule
        final TeamType teamType;                    // Mocked team type

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(AdvancementTeam.class, AdvancementTeamMixIn.class);
        mapper.addMixIn(AdvancementTeamPlayer.class,
                AdvancementTeamPlayerMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(Attributes.class, AttributesMixIn.class);
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);
        mapper.addMixIn(TeamType.class, TeamTypeMixIn.class);

        // Mocks affinities
        affinities = new ArrayList<>();
        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getName()).thenReturn("affinity_group");
        affinities.add(affinity);

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

        // Mocks players
        players = new HashMap<>();
        player = Mockito.mock(AdvancementTeamPlayer.class);
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
        players.put(1, player);

        // Mocks rules
        rules = new ArrayList<>();
        rule = Mockito.mock(TeamRule.class);
        Mockito.when(rule.getName()).thenReturn("team_rule");
        rules.add(rule);

        // Mocks team type
        teamType = Mockito.mock(TeamType.class);
        Mockito.when(teamType.getName()).thenReturn("team_name");
        Mockito.when(teamType.getTeamRules()).thenReturn(rules);

        // Mocks team
        team = Mockito.mock(AdvancementTeam.class);
        Mockito.when(player.getName()).thenReturn("name");
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getCoachingDice()).thenReturn(2);
        Mockito.when(team.getCash()).thenReturn(3);
        Mockito.when(team.getDreadballCards()).thenReturn(4);
        Mockito.when(team.getTotalCost()).thenReturn(5);

        Mockito.when(team.getName()).thenReturn("team_name");
        Mockito.when(team.getTeamType()).thenReturn(teamType);

        Mockito.when(team.getPlayers()).thenReturn(players);

        return mapper.writer().writeValueAsString(team);
    }

}
