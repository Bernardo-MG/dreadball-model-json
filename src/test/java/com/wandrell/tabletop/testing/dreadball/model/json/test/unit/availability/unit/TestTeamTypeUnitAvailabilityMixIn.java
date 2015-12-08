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

package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.availability.unit;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.availability.unit.TeamTypeUnitAvailability;
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.json.availability.unit.TeamTypeUnitAvailabilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamTypeMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.UnitTemplateMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesHolderMixIn;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.UnitTemplate;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

/**
 * Unit tests for {@link TeamTypeUnitAvailabilityMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestTeamTypeUnitAvailabilityMixIn {

    /**
     * Default constructor.
     */
    public TestTeamTypeUnitAvailabilityMixIn() {
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
        final Collection<TeamRule> rules;    // Team rules
        final Collection<Ability> abilities; // Unit abilities
        final TeamRule rule;            // Mocked rule
        final TeamType team;            // Mocked team
        final TeamTypeUnitAvailability ava; // Mocked ava
        final UnitTemplate unit;        // Mocked unit
        final Ability ability;          // Mocked ability
        final AttributesHolder attributes;  // Mocked attributes

        mapper = new ObjectMapper();
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);
        mapper.addMixIn(TeamType.class, TeamTypeMixIn.class);
        mapper.addMixIn(TeamTypeUnitAvailability.class,
                TeamTypeUnitAvailabilityMixIn.class);
        mapper.addMixIn(UnitTemplate.class, UnitTemplateMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(AttributesHolder.class, AttributesHolderMixIn.class);

        rules = new LinkedList<>();
        rule = Mockito.mock(TeamRule.class);
        Mockito.when(rule.getName()).thenReturn("team_rule");
        rules.add(rule);

        team = Mockito.mock(TeamType.class);
        Mockito.when(team.getName()).thenReturn("team_name");
        Mockito.when(team.getTeamRules()).thenReturn(rules);

        attributes = Mockito.mock(AttributesHolder.class);
        Mockito.when(attributes.getArmor()).thenReturn(1);
        Mockito.when(attributes.getMovement()).thenReturn(2);
        Mockito.when(attributes.getSkill()).thenReturn(3);
        Mockito.when(attributes.getSpeed()).thenReturn(4);
        Mockito.when(attributes.getStrength()).thenReturn(5);

        abilities = new LinkedList<>();
        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getName()).thenReturn("ability_name");
        abilities.add(ability);

        unit = Mockito.mock(UnitTemplate.class);
        Mockito.when(unit.getAbilities()).thenReturn(abilities);
        Mockito.when(unit.getAttributes()).thenReturn(attributes);
        Mockito.when(unit.getCost()).thenReturn(10);
        Mockito.when(unit.getPosition()).thenReturn(TeamPosition.STRIKER);
        Mockito.when(unit.getTemplateName()).thenReturn("unit_template");
        Mockito.when(unit.isGiant()).thenReturn(true);

        ava = Mockito.mock(TeamTypeUnitAvailability.class);
        Mockito.when(ava.getInitialNumber()).thenReturn(1);
        Mockito.when(ava.getMaxNumber()).thenReturn(2);
        Mockito.when(ava.getTeamType()).thenReturn(team);
        Mockito.when(ava.getUnit()).thenReturn(unit);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(ava),
                "{\"initial_number\":1,\"max_number\":2,\"team\":{\"team_rules\":[{\"name\":\"team_rule\"}],\"name\":\"team_name\"},\"unit\":{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"cost\":10,\"team_position\":\"STRIKER\",\"template_name\":\"unit_template\",\"giant\":true}}");
    }

}
