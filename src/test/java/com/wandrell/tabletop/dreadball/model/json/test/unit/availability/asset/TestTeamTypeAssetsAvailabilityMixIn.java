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

package com.wandrell.tabletop.dreadball.model.json.test.unit.availability.asset;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.availability.asset.TeamTypeAssetsAvailability;
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.json.availability.asset.TeamTypeAssetsAvailabilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamTypeMixIn;

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
     * Tests that the JSON message is created correctly.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper; // Mapper for the JSON
        final ObjectWriter writer; // Writer for the JSON
        final Collection<TeamRule> rules; // Team rules
        final TeamRule rule;       // Mocked rule
        final TeamType team;       // Mocked team type
        final TeamTypeAssetsAvailability ava; // Mocked ava

        mapper = new ObjectMapper();
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);
        mapper.addMixIn(TeamType.class, TeamTypeMixIn.class);
        mapper.addMixIn(TeamTypeAssetsAvailability.class,
                TeamTypeAssetsAvailabilityMixIn.class);

        rules = new LinkedList<>();
        rule = Mockito.mock(TeamRule.class);
        Mockito.when(rule.getName()).thenReturn("team_rule");
        rules.add(rule);

        team = Mockito.mock(TeamType.class);
        Mockito.when(team.getName()).thenReturn("team_name");
        Mockito.when(team.getTeamRules()).thenReturn(rules);

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
        Mockito.when(ava.getTeamType()).thenReturn(team);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(ava),
                "{\"cheerleader_cost\":1,\"cheerleader_initial\":2,\"cheerleader_max\":3,\"coaching_die_cost\":4,\"coaching_die_initial\":5,\"coaching_die_max\":6,\"coaching_staff_cost\":7,\"dreadball_card_cost\":8,\"dreadball_card_initial\":9,\"dreadball_card_max\":10,\"team\":{\"team_rules\":[{\"name\":\"team_rule\"}],\"name\":\"team_name\"},\"initial_defensive_coach\":false,\"initial_offensive_coach\":false,\"initial_support_coach\":false}");
    }

}
