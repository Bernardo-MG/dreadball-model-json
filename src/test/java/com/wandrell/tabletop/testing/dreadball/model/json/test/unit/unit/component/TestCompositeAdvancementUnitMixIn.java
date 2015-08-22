package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.unit.component;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.json.unit.component.ComponentLocationMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.component.CompositeAdvancementUnitMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.component.UnitComponentMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesHolderMixIn;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;
import com.wandrell.tabletop.dreadball.model.unit.component.CompositeAdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.component.UnitComponent;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class TestCompositeAdvancementUnitMixIn {

    public TestCompositeAdvancementUnitMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final Collection<Ability> abilities;
        final Collection<UnitComponent> components;
        final Collection<TeamPosition> positions;
        final CompositeAdvancementUnit unit;
        final Ability ability;
        final AttributesHolder attributes;
        final UnitComponent component;
        final ComponentLocation location;

        mapper = new ObjectMapper();
        mapper.addMixIn(CompositeAdvancementUnit.class,
                CompositeAdvancementUnitMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(AttributesHolder.class, AttributesHolderMixIn.class);
        mapper.addMixIn(UnitComponent.class, UnitComponentMixIn.class);
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

        components = new LinkedList<>();
        component = Mockito.mock(UnitComponent.class);
        Mockito.when(component.getAbilities()).thenReturn(abilities);
        Mockito.when(component.getAttributes()).thenReturn(attributes);
        Mockito.when(component.getComponentName()).thenReturn("component_name");
        Mockito.when(component.getCost()).thenReturn(11);
        Mockito.when(component.getLocation()).thenReturn(location);
        Mockito.when(component.getTeamPositions()).thenReturn(positions);
        components.add(component);

        unit = Mockito.mock(CompositeAdvancementUnit.class);
        Mockito.when(unit.getAbilities()).thenReturn(abilities);
        Mockito.when(unit.getAttributes()).thenReturn(attributes);
        Mockito.when(unit.getCost()).thenReturn(10);
        Mockito.when(unit.getPosition()).thenReturn(TeamPosition.STRIKER);
        Mockito.when(unit.getTemplateName()).thenReturn("unit_template");
        Mockito.when(unit.isGiant()).thenReturn(true);
        Mockito.when(unit.getRank()).thenReturn(20);
        Mockito.when(unit.getUnspentExperience()).thenReturn(30);
        Mockito.when(unit.getValoration()).thenReturn(40);
        Mockito.when(unit.getComponents()).thenReturn(components);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(unit),
                "{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"cost\":10,\"team_position\":\"STRIKER\",\"template_name\":\"unit_template\",\"giant\":true,\"rank\":20,\"unspent_experience\":30,\"valoration\":40,\"components\":[{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"name\":\"component_name\",\"cost\":11,\"location\":{\"name\":\"component_location\"},\"team_positions\":[\"STRIKER\"]}]}");
    }

}
