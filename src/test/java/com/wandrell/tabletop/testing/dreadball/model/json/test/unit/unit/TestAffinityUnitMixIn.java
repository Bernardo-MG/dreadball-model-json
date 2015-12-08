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

package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.unit;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityUnitMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesHolderMixIn;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

/**
 * Unit tests for {@link AffinityUnitMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestAffinityUnitMixIn {

    /**
     * Default constructor.
     */
    public TestAffinityUnitMixIn() {
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
        final Collection<Ability> abilities; // Unit abilities
        final Collection<AffinityGroup> affinities; // Unit affinities
        final Collection<AffinityGroup> hated;      // Unit hated affinities
        final AffinityUnit unit;   // Mocked unit
        final Ability ability;     // Mocked ability
        final AffinityGroup affinity1;      // Mocked affinity
        final AffinityGroup affinity2;      // Mocked affinity
        final AttributesHolder attributes; // Mocked attributes

        mapper = new ObjectMapper();
        mapper.addMixIn(AffinityUnit.class, AffinityUnitMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(AttributesHolder.class, AttributesHolderMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);

        abilities = new LinkedList<>();
        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getName()).thenReturn("ability_name");
        abilities.add(ability);

        affinities = new LinkedList<>();
        affinity1 = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity1.getName()).thenReturn("affinity_group");
        affinities.add(affinity1);

        hated = new LinkedList<>();
        affinity2 = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity2.getName()).thenReturn("affinity_group_2");
        hated.add(affinity2);

        attributes = Mockito.mock(AttributesHolder.class);
        Mockito.when(attributes.getArmor()).thenReturn(1);
        Mockito.when(attributes.getMovement()).thenReturn(2);
        Mockito.when(attributes.getSkill()).thenReturn(3);
        Mockito.when(attributes.getSpeed()).thenReturn(4);
        Mockito.when(attributes.getStrength()).thenReturn(5);

        unit = Mockito.mock(AffinityUnit.class);
        Mockito.when(unit.getAbilities()).thenReturn(abilities);
        Mockito.when(unit.getAttributes()).thenReturn(attributes);
        Mockito.when(unit.getCost()).thenReturn(10);
        Mockito.when(unit.getPosition()).thenReturn(TeamPosition.STRIKER);
        Mockito.when(unit.getTemplateName()).thenReturn("unit_template");
        Mockito.when(unit.isGiant()).thenReturn(true);
        Mockito.when(unit.getAffinityGroups()).thenReturn(affinities);
        Mockito.when(unit.getHatedAffinityGroups()).thenReturn(hated);
        Mockito.when(unit.getAllyCost()).thenReturn(5);
        Mockito.when(unit.getFriendCost()).thenReturn(6);
        Mockito.when(unit.getStrangerCost()).thenReturn(7);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(unit),
                "{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"cost\":10,\"team_position\":\"STRIKER\",\"template_name\":\"unit_template\",\"giant\":true,\"affinity_groups\":[{\"name\":\"affinity_group\"}],\"hated_affinity_groups\":[{\"name\":\"affinity_group_2\"}],\"ally_cost\":5,\"friend_cost\":6,\"stranger_cost\":7}");
    }

}
