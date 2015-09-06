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
package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.faction;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamTypeMixIn;

public final class TestTeamTypeMixIn {

    public TestTeamTypeMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final Collection<TeamRule> rules;
        final TeamRule rule;
        final TeamType team;

        mapper = new ObjectMapper();
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);
        mapper.addMixIn(TeamType.class, TeamTypeMixIn.class);

        rules = new LinkedList<>();
        rule = Mockito.mock(TeamRule.class);
        Mockito.when(rule.getTeamRuleName()).thenReturn("team_rule");
        rules.add(rule);

        team = Mockito.mock(TeamType.class);
        Mockito.when(team.getTeamTypeName()).thenReturn("team_name");
        Mockito.when(team.getTeamRules()).thenReturn(rules);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(team),
                "{\"team_rules\":[{\"name\":\"team_rule\"}],\"name\":\"team_name\"}");
    }

}
