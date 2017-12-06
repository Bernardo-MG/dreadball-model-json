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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.availability.asset;

import java.util.ArrayList;
import java.util.Collection;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.bernardomg.tabletop.dreadball.model.availability.asset.TeamTypeAssetsAvailability;
import com.bernardomg.tabletop.dreadball.model.faction.TeamRule;
import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.json.availability.asset.TeamTypeAssetsAvailabilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.bernardomg.tabletop.dreadball.model.json.faction.TeamTypeMixIn;

/**
 * Unit tests for {@link TeamTypeAssetsAvailabilityMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestTeamTypeAssetsAvailabilityMixIn {

    /**
     * Default constructor.
     */
    public TestTeamTypeAssetsAvailabilityMixIn() {
        super();
    }

    /**
     * Tests that the JSON message is created with the correct cheerleader cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_CheerleaderCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.cheerleaderCost");

        Assert.assertEquals(value, 1);
    }

    /**
     * Tests that the JSON message is created with the correct initial
     * cheerleader count.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_CheerleaderInitial() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.cheerleaderInitial");

        Assert.assertEquals(value, 2);
    }

    /**
     * Tests that the JSON message is created with the correct cheerleader
     * maximum.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_CheerleaderMax() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.cheerleaderMax");

        Assert.assertEquals(value, 3);
    }

    /**
     * Tests that the JSON message is created with the correct coaching die
     * cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_CoachingDieCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.coachingDieCost");

        Assert.assertEquals(value, 4);
    }

    /**
     * Tests that the JSON message is created with the correct initial coaching
     * die count.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_CoachingDieInitial() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.coachingDieInitial");

        Assert.assertEquals(value, 5);
    }

    /**
     * Tests that the JSON message is created with the correct coaching die
     * maximum.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_CoachingDieMax() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.coachingDieMax");

        Assert.assertEquals(value, 6);
    }

    /**
     * Tests that the JSON message is created with the correct coaching staff
     * cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_CoachingStaffCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.coachingStaffCost");

        Assert.assertEquals(value, 7);
    }

    /**
     * Tests that the JSON message is created with the correct Dreadball card
     * cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_DreadballCardCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.dreadballCardCost");

        Assert.assertEquals(value, 8);
    }

    /**
     * Tests that the JSON message is created with the correct initial Dreadball
     * card count.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_DreadballCardInitial()
            throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.dreadballCardInitial");

        Assert.assertEquals(value, 9);
    }

    /**
     * Tests that the JSON message is created with the correct Dreadball card
     * maximum.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_DreadballCardMax() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.dreadballCardMax");

        Assert.assertEquals(value, 10);
    }

    /**
     * Tests that the JSON message is created with the correct initial defensive
     * coach value.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_StartingWithDefensiveCoachingStaff()
            throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.startingWithDefensiveCoachingStaff");

        Assert.assertTrue((boolean) value);
    }

    /**
     * Tests that the JSON message is created with the correct initial offensive
     * coach value.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_StartingWithOffensiveCoachingStaff()
            throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.startingWithOffensiveCoachingStaff");

        Assert.assertFalse((boolean) value);
    }

    /**
     * Tests that the JSON message is created with the correct initial support
     * coach value.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_StartingWithSupportCoachingStaff()
            throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.startingWithSupportCoachingStaff");

        Assert.assertTrue((boolean) value);
    }

    /**
     * Tests that the JSON message is created with the correct team rules.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_TeamRules() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.teamType.teamRules[0].name");

        Assert.assertEquals("team_rule", value);
    }

    /**
     * Tests that the JSON message is created with the correct team type name.
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
     * Returns the generated JSON to be tested.
     * 
     * @return the tested JSON
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    private final String getJson() throws JsonProcessingException {
        final ObjectMapper mapper;        // Mapper for the JSON
        final Collection<TeamRule> rules; // Team rules
        final TeamRule rule;              // Mocked rule
        final TeamType team;              // Mocked team type
        final TeamTypeAssetsAvailability ava; // Mocked ava

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);
        mapper.addMixIn(TeamType.class, TeamTypeMixIn.class);
        mapper.addMixIn(TeamTypeAssetsAvailability.class,
                TeamTypeAssetsAvailabilityMixIn.class);

        // Mocks rules
        rules = new ArrayList<>();
        rule = Mockito.mock(TeamRule.class);
        Mockito.when(rule.getName()).thenReturn("team_rule");
        rules.add(rule);

        // Mocks team
        team = Mockito.mock(TeamType.class);
        Mockito.when(team.getName()).thenReturn("team_name");
        Mockito.when(team.getTeamRules()).thenReturn(rules);

        // Mocks availabilities
        ava = Mockito.mock(TeamTypeAssetsAvailability.class);
        Mockito.when(ava.getCheerleaderCost()).thenReturn(1);
        Mockito.when(ava.getCheerleaderInitial()).thenReturn(2);
        Mockito.when(ava.getCheerleaderMax()).thenReturn(3);
        Mockito.when(ava.getCoachingDieCost()).thenReturn(4);
        Mockito.when(ava.getCoachingDieInitial()).thenReturn(5);
        Mockito.when(ava.getCoachingDieMax()).thenReturn(6);
        Mockito.when(ava.getCoachingStaffCost()).thenReturn(7);
        Mockito.when(ava.getDreadballCardCost()).thenReturn(8);
        Mockito.when(ava.getDreadballCardInitial()).thenReturn(9);
        Mockito.when(ava.getDreadballCardMax()).thenReturn(10);
        Mockito.when(ava.getStartingWithDefensiveCoachingStaff())
                .thenReturn(true);
        Mockito.when(ava.getStartingWithOffensiveCoachingStaff())
                .thenReturn(false);
        Mockito.when(ava.getStartingWithSupportCoachingStaff())
                .thenReturn(true);
        Mockito.when(ava.getTeamType()).thenReturn(team);

        return mapper.writer().writeValueAsString(ava);
    }

}
