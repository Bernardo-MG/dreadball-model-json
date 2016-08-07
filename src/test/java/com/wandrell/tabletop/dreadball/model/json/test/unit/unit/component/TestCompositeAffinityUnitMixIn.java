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
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.component.ComponentLocationMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.component.ComponentMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.component.CompositeAffinityUnitMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesMixIn;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.component.Component;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;
import com.wandrell.tabletop.dreadball.model.unit.component.CompositeAffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;

/**
 * Unit tests for {@link CompositeAffinityUnitMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestCompositeAffinityUnitMixIn {

    /**
     * Default constructor.
     */
    public TestCompositeAffinityUnitMixIn() {
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
        final ObjectMapper mapper;                  // Mapper for the JSON
        final ObjectWriter writer;                  // Writer for the JSON
        final Collection<Ability> abilities;        // Unit abilities
        final Collection<AffinityGroup> affinities; // Unit affinities
        final Collection<AffinityGroup> hated;      // Unit hated affinities
        final Collection<Component> components;     // Unit components
        final Collection<Role> roles;               // Unit roles
        final CompositeAffinityUnit unit;           // Mocked unit
        final Ability ability;                      // Mocked ability
        final AffinityGroup affinity1;              // Mocked affinity
        final AffinityGroup affinity2;              // Mocked affinity
        final Attributes attributes;                // Mocked attributes
        final Component component;                  // Mocked component
        final ComponentLocation location;           // Mocked location

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(CompositeAffinityUnit.class,
                CompositeAffinityUnitMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(Attributes.class, AttributesMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);
        mapper.addMixIn(Component.class, ComponentMixIn.class);
        mapper.addMixIn(ComponentLocation.class, ComponentLocationMixIn.class);

        // Mocks abilities
        abilities = new LinkedList<>();
        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getName()).thenReturn("ability_name");
        abilities.add(ability);

        // Mocks affinities
        affinities = new LinkedList<>();
        affinity1 = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity1.getName()).thenReturn("affinity_group");
        affinities.add(affinity1);

        // Mocks hated affinities
        hated = new LinkedList<>();
        affinity2 = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity2.getName()).thenReturn("affinity_group_2");
        hated.add(affinity2);

        // Mocks attributes
        attributes = Mockito.mock(Attributes.class);
        Mockito.when(attributes.getArmor()).thenReturn(1);
        Mockito.when(attributes.getMovement()).thenReturn(2);
        Mockito.when(attributes.getSkill()).thenReturn(3);
        Mockito.when(attributes.getSpeed()).thenReturn(4);
        Mockito.when(attributes.getStrength()).thenReturn(5);

        // Mocks location
        location = Mockito.mock(ComponentLocation.class);
        Mockito.when(location.getName()).thenReturn("component_location");

        // Sets roles
        roles = new LinkedList<>();
        roles.add(Role.STRIKER);
        roles.add(Role.JACK);

        // Mocks components
        components = new LinkedList<>();
        component = Mockito.mock(Component.class);
        Mockito.when(component.getAbilities()).thenReturn(abilities);
        Mockito.when(component.getAttributes()).thenReturn(attributes);
        Mockito.when(component.getName()).thenReturn("component_name");
        Mockito.when(component.getCost()).thenReturn(11);
        Mockito.when(component.getLocation()).thenReturn(location);
        Mockito.when(component.getRoles()).thenReturn(roles);
        components.add(component);

        // Mocks unit
        unit = Mockito.mock(CompositeAffinityUnit.class);
        Mockito.when(unit.getAbilities()).thenReturn(abilities);
        Mockito.when(unit.getAttributes()).thenReturn(attributes);
        Mockito.when(unit.getCost()).thenReturn(10);
        Mockito.when(unit.getRole()).thenReturn(Role.STRIKER);
        Mockito.when(unit.getTemplateName()).thenReturn("unit_template");
        Mockito.when(unit.getMvp()).thenReturn(true);
        Mockito.when(unit.getGiant()).thenReturn(true);
        Mockito.when(unit.getAffinityGroups()).thenReturn(affinities);
        Mockito.when(unit.getHatedAffinityGroups()).thenReturn(hated);
        Mockito.when(unit.getAllyCost()).thenReturn(5);
        Mockito.when(unit.getFriendCost()).thenReturn(6);
        Mockito.when(unit.getStrangerCost()).thenReturn(7);
        Mockito.when(unit.getComponents()).thenReturn(components);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(unit),
                "{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"cost\":10,\"role\":\"striker\",\"template_name\":\"unit_template\",\"mvp\":true,\"giant\":true,\"affinity_groups\":[{\"name\":\"affinity_group\"}],\"hated_affinity_groups\":[{\"name\":\"affinity_group_2\"}],\"ally_cost\":5,\"friend_cost\":6,\"stranger_cost\":7,\"components\":[{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"name\":\"component_name\",\"cost\":11,\"location\":{\"name\":\"component_location\"},\"roles\":[\"striker\",\"jack\"]}]}");
    }

}
