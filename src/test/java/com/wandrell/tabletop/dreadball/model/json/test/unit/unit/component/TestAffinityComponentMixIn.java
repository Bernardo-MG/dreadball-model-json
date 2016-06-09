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

package com.wandrell.tabletop.dreadball.model.json.test.unit.unit.component;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.json.unit.component.AffinityComponentMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.component.ComponentLocationMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesMixIn;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.component.AffinityComponent;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;

/**
 * Unit tests for {@link AffinityComponentMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Martínez Garrido
 */
public final class TestAffinityComponentMixIn {

    /**
     * Default constructor.
     */
    public TestAffinityComponentMixIn() {
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
        final Collection<Ability> abilities; // Component abilities
        final Collection<Role> positions; // Component positions
        final AffinityComponent component;    // Mocked component
        final Ability ability;                    // Mocked ability
        final Attributes attributes;        // Mocked attributes
        final ComponentLocation location;         // Mocked location

        mapper = new ObjectMapper();
        mapper.addMixIn(AffinityComponent.class, AffinityComponentMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(Attributes.class, AttributesMixIn.class);
        mapper.addMixIn(ComponentLocation.class, ComponentLocationMixIn.class);

        abilities = new LinkedList<>();
        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getName()).thenReturn("ability_name");
        abilities.add(ability);

        attributes = Mockito.mock(Attributes.class);
        Mockito.when(attributes.getArmor()).thenReturn(1);
        Mockito.when(attributes.getMovement()).thenReturn(2);
        Mockito.when(attributes.getSkill()).thenReturn(3);
        Mockito.when(attributes.getSpeed()).thenReturn(4);
        Mockito.when(attributes.getStrength()).thenReturn(5);

        location = Mockito.mock(ComponentLocation.class);
        Mockito.when(location.getName()).thenReturn("component_location");

        positions = new LinkedList<>();
        positions.add(Role.STRIKER);

        component = Mockito.mock(AffinityComponent.class);
        Mockito.when(component.getAbilities()).thenReturn(abilities);
        Mockito.when(component.getAttributes()).thenReturn(attributes);
        Mockito.when(component.getName()).thenReturn("component_name");
        Mockito.when(component.getCost()).thenReturn(11);
        Mockito.when(component.getLocation()).thenReturn(location);
        Mockito.when(component.getRoles()).thenReturn(positions);
        Mockito.when(component.getAllyCost()).thenReturn(5);
        Mockito.when(component.getFriendCost()).thenReturn(6);
        Mockito.when(component.getStrangerCost()).thenReturn(7);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(component),
                "{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"name\":\"component_name\",\"cost\":11,\"location\":{\"name\":\"component_location\"},\"team_positions\":[\"STRIKER\"],\"ally_cost\":5,\"friend_cost\":6,\"stranger_cost\":7}");
    }

}
