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

import com.bernardomg.tabletop.dreadball.model.faction.Sponsor;
import com.bernardomg.tabletop.dreadball.model.json.faction.SponsorMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.AffinityGroupMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.TeamPlayerMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AbilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AttributesMixIn;
import com.bernardomg.tabletop.dreadball.model.json.team.SponsorTeamMixIn;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * Unit tests for {@link SponsorMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorTeamMixIn {

    /**
     * Default constructor.
     */
    public TestSponsorTeamMixIn() {
        super();
    }

    /**
     * Tests that the JSON message is created with the correct additional
     * affinity groups.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_AdditionalAffinityGroups()
            throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.additionalAffinityGroups[0].name");

        Assert.assertEquals("affinity_group", value);
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
     * Tests that the JSON message is created with the correct number of medi
     * bots.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_MediBots() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.mediBots");

        Assert.assertEquals(3, value);
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
     * Tests that the JSON message is created with the correct rank cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_RankCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.rankCost");

        Assert.assertEquals(8, value);
    }

    /**
     * Tests that the JSON message is created with the correct number of
     * sabotage cards.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_SabotageCards() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.nastySurpriseCards");

        Assert.assertEquals(4, value);
    }

    /**
     * Tests that the JSON message is created with the correct number of special
     * move cards.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_SpecialMoveCards() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.specialMoveCards");

        Assert.assertEquals(5, value);
    }

    /**
     * Tests that the JSON message is created with the correct sponsor.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Sponsor() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.sponsor.name");

        Assert.assertEquals("sponsor_name", value);
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

        Assert.assertEquals(6, value);
    }

    /**
     * Tests that the JSON message is created with the correct number of wagers.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Wagers() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.wagers");

        Assert.assertEquals(7, value);
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
        final Collection<AffinityGroup> addAffs;    // Additional affinities
        final Collection<Ability> abilities;        // Player abilities
        final Map<Integer, TeamPlayer> players;     // Team players
        final Sponsor sponsor;                      // Team sponsor
        final AffinityGroup affinity;               // Mocked affinity group
        final SponsorTeam team;                     // Mocked team
        final TeamPlayer player;                    // Mocked player
        final Ability ability;                      // Mocked ability
        final Attributes attributes;                // Mocked attributes

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(Sponsor.class, SponsorMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);
        mapper.addMixIn(SponsorTeam.class, SponsorTeamMixIn.class);
        mapper.addMixIn(TeamPlayer.class, TeamPlayerMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(Attributes.class, AttributesMixIn.class);

        // Mocks affinities
        affinities = new ArrayList<>();
        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getName()).thenReturn("affinity_group");
        affinities.add(affinity);

        // Mocks additional affinities
        addAffs = new ArrayList<>();
        addAffs.add(affinity);

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);
        Mockito.when(sponsor.getName()).thenReturn("sponsor_name");
        Mockito.when(sponsor.getCash()).thenReturn(10);
        Mockito.when(sponsor.getRank()).thenReturn(20);
        Mockito.when(sponsor.getAffinityGroups()).thenReturn(affinities);

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
        player = Mockito.mock(TeamPlayer.class);
        Mockito.when(player.getName()).thenReturn("name");
        Mockito.when(player.getAbilities()).thenReturn(abilities);
        Mockito.when(player.getAttributes()).thenReturn(attributes);
        Mockito.when(player.getCost()).thenReturn(10);
        Mockito.when(player.getRole()).thenReturn(Role.STRIKER);
        Mockito.when(player.getTemplateName()).thenReturn("player_template");
        Mockito.when(player.getMvp()).thenReturn(true);
        Mockito.when(player.getGiant()).thenReturn(true);
        players.put(1, player);

        // Mocks team
        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getCoachingDice()).thenReturn(2);
        Mockito.when(team.getMediBots()).thenReturn(3);
        Mockito.when(team.getNastySurpriseCards()).thenReturn(4);
        Mockito.when(team.getSpecialMoveCards()).thenReturn(5);
        Mockito.when(team.getTotalCost()).thenReturn(6);
        Mockito.when(team.getWagers()).thenReturn(7);
        Mockito.when(team.getRankCost()).thenReturn(8);

        Mockito.when(team.getSponsor()).thenReturn(sponsor);

        Mockito.when(team.getPlayers()).thenReturn(players);

        Mockito.when(team.getAdditionalAffinityGroups()).thenReturn(addAffs);

        return mapper.writer().writeValueAsString(team);
    }

}
