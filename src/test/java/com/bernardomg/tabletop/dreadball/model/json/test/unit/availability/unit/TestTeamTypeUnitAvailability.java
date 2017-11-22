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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.availability.unit;

import java.util.ArrayList;
import java.util.Collection;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.bernardomg.tabletop.dreadball.model.availability.unit.TeamTypeUnitAvailability;
import com.bernardomg.tabletop.dreadball.model.faction.TeamRule;
import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.json.availability.unit.TeamTypeUnitAvailabilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.bernardomg.tabletop.dreadball.model.json.faction.TeamTypeMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.UnitMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.stats.AttributesMixIn;
import com.bernardomg.tabletop.dreadball.model.unit.Role;
import com.bernardomg.tabletop.dreadball.model.unit.Unit;
import com.bernardomg.tabletop.dreadball.model.unit.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.unit.stats.Attributes;

/**
 * Unit tests for {@link TeamTypeUnitAvailability}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestTeamTypeUnitAvailability {

    /**
     * Default constructor.
     */
    public TestTeamTypeUnitAvailability() {
        super();
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

        Assert.assertEquals(value, "team_name");
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

        value = JsonPath.read(json, "$.unit.templateName");

        Assert.assertEquals(value, "unit_template");
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
        final Collection<Ability> abilities; // Unit abilities
        final TeamRule rule;                 // Mocked rule
        final TeamType team;                 // Mocked team
        final TeamTypeUnitAvailability ava;  // Mocked ava
        final Unit unit;                     // Mocked unit
        final Ability ability;               // Mocked ability
        final Attributes attributes;         // Mocked attributes

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);
        mapper.addMixIn(TeamType.class, TeamTypeMixIn.class);
        mapper.addMixIn(TeamTypeUnitAvailability.class,
                TeamTypeUnitAvailabilityMixIn.class);
        mapper.addMixIn(Unit.class, UnitMixIn.class);
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
        unit = Mockito.mock(Unit.class);
        Mockito.when(unit.getName()).thenReturn("name");
        Mockito.when(unit.getAbilities()).thenReturn(abilities);
        Mockito.when(unit.getAttributes()).thenReturn(attributes);
        Mockito.when(unit.getCost()).thenReturn(10);
        Mockito.when(unit.getRole()).thenReturn(Role.STRIKER);
        Mockito.when(unit.getTemplateName()).thenReturn("unit_template");
        Mockito.when(unit.getMvp()).thenReturn(true);
        Mockito.when(unit.getGiant()).thenReturn(true);

        // Mocks availabilities
        ava = Mockito.mock(TeamTypeUnitAvailability.class);
        Mockito.when(ava.getTeamType()).thenReturn(team);
        Mockito.when(ava.getUnit()).thenReturn(unit);

        return mapper.writer().writeValueAsString(ava);
    }

}