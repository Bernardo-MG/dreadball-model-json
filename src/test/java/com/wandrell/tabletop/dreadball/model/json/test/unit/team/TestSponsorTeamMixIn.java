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

package com.wandrell.tabletop.dreadball.model.json.test.unit.team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.json.faction.SponsorMixIn;
import com.wandrell.tabletop.dreadball.model.json.team.SponsorTeamMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.UnitMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesMixIn;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;

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

        Assert.assertEquals(value, "affinity_group");
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

        Assert.assertEquals(value, 1);
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

        Assert.assertEquals(value, 2);
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

        Assert.assertEquals(value, 3);
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

        Assert.assertEquals(value, "name");
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

        Assert.assertEquals(value, 8);
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

        value = JsonPath.read(json, "$.sabotageCards");

        Assert.assertEquals(value, 4);
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

        Assert.assertEquals(value, 5);
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

        Assert.assertEquals(value, "sponsor_name");
    }

    /**
     * Tests that the JSON message is created with the correct valoration.
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

        Assert.assertEquals(value, 6);
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

        Assert.assertEquals(value, 7);
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
        final Collection<Ability> abilities;        // Unit abilities
        final Map<Integer, Unit> units;             // Team units
        final Sponsor sponsor;                      // Team sponsor
        final AffinityGroup affinity;               // Mocked affinity group
        final SponsorTeam team;                     // Mocked team
        final Unit unit;                            // Mocked unit
        final Ability ability;                      // Mocked ability
        final Attributes attributes;                // Mocked attributes

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(Sponsor.class, SponsorMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);
        mapper.addMixIn(SponsorTeam.class, SponsorTeamMixIn.class);
        mapper.addMixIn(Unit.class, UnitMixIn.class);
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

        // Mocks units
        units = new HashMap<>();
        unit = Mockito.mock(Unit.class);
        Mockito.when(unit.getName()).thenReturn("name");
        Mockito.when(unit.getAbilities()).thenReturn(abilities);
        Mockito.when(unit.getAttributes()).thenReturn(attributes);
        Mockito.when(unit.getCost()).thenReturn(10);
        Mockito.when(unit.getRole()).thenReturn(Role.STRIKER);
        Mockito.when(unit.getTemplateName()).thenReturn("unit_template");
        Mockito.when(unit.getMvp()).thenReturn(true);
        Mockito.when(unit.getGiant()).thenReturn(true);
        units.put(1, unit);

        // Mocks team
        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getCoachingDice()).thenReturn(2);
        Mockito.when(team.getMediBots()).thenReturn(3);
        Mockito.when(team.getSabotageCards()).thenReturn(4);
        Mockito.when(team.getSpecialMoveCards()).thenReturn(5);
        Mockito.when(team.getValoration()).thenReturn(6);
        Mockito.when(team.getWagers()).thenReturn(7);
        Mockito.when(team.getRankCost()).thenReturn(8);

        Mockito.when(team.getSponsor()).thenReturn(sponsor);

        Mockito.when(team.getPlayers()).thenReturn(units);

        Mockito.when(team.getAdditionalAffinityGroups()).thenReturn(addAffs);

        return mapper.writer().writeValueAsString(team);
    }

}
