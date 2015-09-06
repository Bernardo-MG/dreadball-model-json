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
package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.team;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.json.faction.SponsorMixIn;
import com.wandrell.tabletop.dreadball.model.json.team.SponsorTeamMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.UnitMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesHolderMixIn;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class TestSponsorTeamMixIn {

    public TestSponsorTeamMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final Collection<AffinityGroup> affinities;
        final Collection<Ability> abilities;
        final Map<Integer, Unit> units;
        final Sponsor sponsor;
        final AffinityGroup affinity;
        final SponsorTeam team;
        final Unit unit;
        final Ability ability;
        final AttributesHolder attributes;

        mapper = new ObjectMapper();
        mapper.addMixIn(Sponsor.class, SponsorMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);
        mapper.addMixIn(SponsorTeam.class, SponsorTeamMixIn.class);
        mapper.addMixIn(Unit.class, UnitMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(AttributesHolder.class, AttributesHolderMixIn.class);

        affinities = new LinkedList<>();
        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getAffinityGroupName())
                .thenReturn("affinity_group");
        affinities.add(affinity);

        sponsor = Mockito.mock(Sponsor.class);
        Mockito.when(sponsor.getSponsorName()).thenReturn("sponsor_name");
        Mockito.when(sponsor.getCash()).thenReturn(10);
        Mockito.when(sponsor.getRank()).thenReturn(20);
        Mockito.when(sponsor.getAffinityGroups()).thenReturn(affinities);

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

        units = new LinkedHashMap<>();
        unit = Mockito.mock(Unit.class);
        Mockito.when(unit.getAbilities()).thenReturn(abilities);
        Mockito.when(unit.getAttributes()).thenReturn(attributes);
        Mockito.when(unit.getCost()).thenReturn(10);
        Mockito.when(unit.getPosition()).thenReturn(TeamPosition.STRIKER);
        Mockito.when(unit.getTemplateName()).thenReturn("unit_template");
        Mockito.when(unit.isGiant()).thenReturn(true);
        units.put(1, unit);

        team = Mockito.mock(SponsorTeam.class);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getDice()).thenReturn(2);
        Mockito.when(team.getMediBots()).thenReturn(3);
        Mockito.when(team.getSabotageCards()).thenReturn(4);
        Mockito.when(team.getSpecialMoveCards()).thenReturn(5);
        Mockito.when(team.getValoration()).thenReturn(6);
        Mockito.when(team.getWagers()).thenReturn(7);

        Mockito.when(team.getSponsor()).thenReturn(sponsor);

        Mockito.when(team.getPlayers()).thenReturn(units);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(team),
                "{\"cheerleaders\":1,\"dice\":2,\"players\":{\"1\":{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"cost\":10,\"team_position\":\"STRIKER\",\"template_name\":\"unit_template\",\"giant\":true}},\"valoration\":6,\"medibots\":3,\"sabotage_cards\":4,\"special_move_cards\":5,\"sponsor\":{\"affinity_groups\":[{\"name\":\"affinity_group\"}],\"cash\":10,\"rank\":20,\"name\":\"sponsor_name\"},\"wagers\":7}");
    }

}
