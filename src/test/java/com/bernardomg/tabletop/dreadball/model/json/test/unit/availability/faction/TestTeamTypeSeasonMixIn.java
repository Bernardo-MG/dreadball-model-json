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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.availability.faction;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.availability.faction.TeamTypeSeason;
import com.bernardomg.tabletop.dreadball.model.faction.TeamRule;
import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.json.availability.faction.TeamTypeSeasonMixIn;
import com.bernardomg.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.bernardomg.tabletop.dreadball.model.json.faction.TeamTypeMixIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * Unit tests for {@link TeamTypeSeasonMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestTeamTypeSeasonMixIn {

    /**
     * Default constructor.
     */
    public TestTeamTypeSeasonMixIn() {
        super();
    }

    /**
     * Tests that the JSON message is created with the correct season number.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_SeasonNumber() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.seasonNumber");

        Assert.assertEquals(1, value);
    }

    /**
     * Tests that the JSON message is created with the correct team name.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_TeamName() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.team.name");

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
        final TeamTypeSeason ava;         // Mocked ava
        final Collection<TeamRule> rules; // Team rules
        final TeamRule rule;              // Mocked rule
        final TeamType team;              // Mocked team

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(TeamTypeSeason.class, TeamTypeSeasonMixIn.class);
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);
        mapper.addMixIn(TeamType.class, TeamTypeMixIn.class);

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
        ava = Mockito.mock(TeamTypeSeason.class);
        Mockito.when(ava.getSeasonNumber()).thenReturn(1);
        Mockito.when(ava.getTeam()).thenReturn(team);

        return mapper.writer().writeValueAsString(ava);
    }

}
