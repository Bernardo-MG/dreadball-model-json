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
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamTypeMixIn;
import com.wandrell.tabletop.dreadball.model.json.team.AdvancementTeamMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.AdvancementUnitMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesHolderMixIn;
import com.wandrell.tabletop.dreadball.model.team.AdvancementTeam;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class TestAdvancementTeamMixIn {

    public TestAdvancementTeamMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final Collection<AffinityGroup> affinities;
        final Collection<Ability> abilities;
        final Collection<TeamRule> rules;
        final Map<Integer, AdvancementUnit> units;
        final Sponsor sponsor;
        final AffinityGroup affinity;
        final AdvancementTeam team;
        final AdvancementUnit unit;
        final Ability ability;
        final AttributesHolder attributes;
        final TeamRule rule;
        final TeamType teamType;

        mapper = new ObjectMapper();
        mapper.addMixIn(AdvancementTeam.class, AdvancementTeamMixIn.class);
        mapper.addMixIn(AdvancementUnit.class, AdvancementUnitMixIn.class);
        mapper.addMixIn(Ability.class, AbilityMixIn.class);
        mapper.addMixIn(AttributesHolder.class, AttributesHolderMixIn.class);
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);
        mapper.addMixIn(TeamType.class, TeamTypeMixIn.class);

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
        units.put(1, unit);

        rules = new LinkedList<>();
        rule = Mockito.mock(TeamRule.class);
        Mockito.when(rule.getTeamRuleName()).thenReturn("team_rule");
        rules.add(rule);

        teamType = Mockito.mock(TeamType.class);
        Mockito.when(teamType.getTeamTypeName()).thenReturn("team_name");
        Mockito.when(teamType.getTeamRules()).thenReturn(rules);

        team = Mockito.mock(AdvancementTeam.class);
        Mockito.when(team.getCheerleaders()).thenReturn(1);
        Mockito.when(team.getDice()).thenReturn(2);
        Mockito.when(team.getCash()).thenReturn(3);
        Mockito.when(team.getDreadballCards()).thenReturn(4);
        Mockito.when(team.getValoration()).thenReturn(5);

        Mockito.when(team.getTeamName()).thenReturn("team_name");
        Mockito.when(team.getTeamType()).thenReturn(teamType);

        Mockito.when(team.getPlayers()).thenReturn(units);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(team),
                "{\"cheerleaders\":1,\"dice\":2,\"players\":{\"1\":{\"abilities\":[{\"name\":\"ability_name\"}],\"attributes\":{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5},\"cost\":10,\"team_position\":\"STRIKER\",\"template_name\":\"unit_template\",\"giant\":true,\"rank\":20,\"unspent_experience\":30,\"valoration\":40}},\"valoration\":5,\"cash\":3,\"cards\":4,\"name\":\"team_name\",\"type\":{\"team_rules\":[{\"name\":\"team_rule\"}],\"name\":\"team_name\"},\"defensive_coach\":false,\"offensive_coach\":false,\"support_coach\":false}");
    }

}
