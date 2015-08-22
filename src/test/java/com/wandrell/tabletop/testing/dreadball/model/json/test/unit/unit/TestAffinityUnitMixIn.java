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

public final class TestAffinityUnitMixIn {

    public TestAffinityUnitMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final Collection<Ability> abilities;
        final Collection<AffinityGroup> affinities;
        final AffinityUnit unit;
        final Ability ability;
        final AffinityGroup affinity;
        final AttributesHolder attributes;

        mapper = new ObjectMapper();
        mapper.addMixIn(AffinityUnit.class, AffinityUnitMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(AttributesHolder.class, AttributesHolderMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);

        abilities = new LinkedList<>();
        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getAbilityName()).thenReturn("ability_name");
        abilities.add(ability);

        affinities = new LinkedList<>();
        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getAffinityGroupName())
                .thenReturn("affinity_group");
        affinities.add(affinity);

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
        Mockito.when(unit.getAllyCost()).thenReturn(5);
        Mockito.when(unit.getFriendCost()).thenReturn(6);
        Mockito.when(unit.getStrangerCost()).thenReturn(7);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(unit),
                "{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"cost\":10,\"team_position\":\"STRIKER\",\"template_name\":\"unit_template\",\"giant\":true,\"affinity_groups\":[{\"affinity_group_name\":\"affinity_group\"}],\"ally_cost\":5,\"friend_cost\":6,\"stranger_cost\":7}");
    }

}
