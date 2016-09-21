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

package com.wandrell.tabletop.dreadball.model.json.test.unit.availability.faction;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.availability.faction.TeamTypeSeason;
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.json.availability.faction.TeamTypeSeasonMixIn;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamTypeMixIn;

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
     * Tests that the JSON message is created correctly.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;        // Mapper for the JSON
        final ObjectWriter writer;        // Writer for the JSON
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
        rules = new LinkedList<>();
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

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(ava),
                "{\"team\":{\"teamRules\":[{\"name\":\"team_rule\"}],\"name\":\"team_name\"},\"seasonNumber\":1}");
    }

}
