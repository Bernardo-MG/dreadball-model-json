package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.unit;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.json.unit.AdvancementUnitMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesHolderMixIn;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;
import com.wandrell.tabletop.dreadball.model.unit.component.UnitComponent;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class TestAdvancementUnitMixIn {

    public TestAdvancementUnitMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final Collection<Ability> abilities;
        final AdvancementUnit unit;
        final Ability ability;
        final AttributesHolder attributes;
        final UnitComponent implant;
        final ComponentLocation location;
        final Collection<TeamPosition> positions;

        mapper = new ObjectMapper();
        mapper.addMixIn(AdvancementUnit.class, AdvancementUnitMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(AttributesHolder.class, AttributesHolderMixIn.class);

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

        implant = Mockito.mock(UnitComponent.class);
        Mockito.when(implant.getAbilities()).thenReturn(abilities);
        Mockito.when(implant.getAttributes()).thenReturn(attributes);
        Mockito.when(implant.getComponentName()).thenReturn("component_name");
        Mockito.when(implant.getCost()).thenReturn(10);
        Mockito.when(implant.getLocation()).thenReturn(location);
        Mockito.when(implant.getTeamPositions()).thenReturn(positions);

        unit = Mockito.mock(AdvancementUnit.class);
        Mockito.when(unit.getAbilities()).thenReturn(abilities);
        Mockito.when(unit.getAttributes()).thenReturn(attributes);
        Mockito.when(unit.getCost()).thenReturn(10);
        Mockito.when(unit.getPosition()).thenReturn(TeamPosition.STRIKER);
        Mockito.when(unit.getTemplateName()).thenReturn("unit_template");
        Mockito.when(unit.isGiant()).thenReturn(true);
        Mockito.when(unit.getRank()).thenReturn(20);
        Mockito.when(unit.getUnspentExperience()).thenReturn(30);
        Mockito.when(unit.getValoration()).thenReturn(40);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(unit),
                "{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"cost\":10,\"team_position\":\"STRIKER\",\"template_name\":\"unit_template\",\"giant\":true,\"implant\":null,\"rank\":20,\"unspent_experience\":30,\"valoration\":40}");
    }

}
