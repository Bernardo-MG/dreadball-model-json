package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.unit.component;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.json.unit.component.AffinityUnitComponentMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.component.ComponentLocationMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesHolderMixIn;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.component.AffinityUnitComponent;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class TestAffinityUnitComponentMixIn {

    public TestAffinityUnitComponentMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final Collection<Ability> abilities;
        final Collection<TeamPosition> positions;
        final AffinityUnitComponent component;
        final Ability ability;
        final AttributesHolder attributes;
        final ComponentLocation location;

        mapper = new ObjectMapper();
        mapper.addMixIn(AffinityUnitComponent.class,
                AffinityUnitComponentMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(AttributesHolder.class, AttributesHolderMixIn.class);
        mapper.addMixIn(ComponentLocation.class, ComponentLocationMixIn.class);

        abilities = new LinkedList<>();
        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getAbilityName()).thenReturn("ability_name");
        abilities.add(ability);

        attributes = Mockito.mock(AttributesHolder.class);
        Mockito.when(attributes.getArmor()).thenReturn(1);
        Mockito.when(attributes.getMovement()).thenReturn(2);
        Mockito.when(attributes.getSkill()).thenReturn(3);
        Mockito.when(attributes.getSpeed()).thenReturn(4);
        Mockito.when(attributes.getStrength()).thenReturn(5);

        location = Mockito.mock(ComponentLocation.class);
        Mockito.when(location.getComponentLocationName())
                .thenReturn("component_location");

        positions = new LinkedList<>();
        positions.add(TeamPosition.STRIKER);

        component = Mockito.mock(AffinityUnitComponent.class);
        Mockito.when(component.getAbilities()).thenReturn(abilities);
        Mockito.when(component.getAttributes()).thenReturn(attributes);
        Mockito.when(component.getComponentName()).thenReturn("component_name");
        Mockito.when(component.getCost()).thenReturn(11);
        Mockito.when(component.getLocation()).thenReturn(location);
        Mockito.when(component.getTeamPositions()).thenReturn(positions);
        Mockito.when(component.getAllyCost()).thenReturn(5);
        Mockito.when(component.getFriendCost()).thenReturn(6);
        Mockito.when(component.getStrangerCost()).thenReturn(7);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(component),
                "{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"name\":\"component_name\",\"cost\":11,\"location\":{\"name\":\"component_location\"},\"team_positions\":[\"STRIKER\"],\"ally_cost\":5,\"friend_cost\":6,\"stranger_cost\":7}");
    }

}
