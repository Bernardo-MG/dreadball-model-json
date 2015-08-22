package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.availability.team;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.availability.team.TeamTypeAssetsAvailability;
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.json.availability.team.TeamTypeAssetsAvailabilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamRuleMixIn;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamTypeMixIn;

public final class TestTeamTypeAssetsAvailabilityMixIn {

    public TestTeamTypeAssetsAvailabilityMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final Collection<TeamRule> rules;
        final TeamRule rule;
        final TeamType team;
        final TeamTypeAssetsAvailability ava;

        mapper = new ObjectMapper();
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);
        mapper.addMixIn(TeamType.class, TeamTypeMixIn.class);
        mapper.addMixIn(TeamTypeAssetsAvailability.class,
                TeamTypeAssetsAvailabilityMixIn.class);

        rules = new LinkedList<>();
        rule = Mockito.mock(TeamRule.class);
        Mockito.when(rule.getTeamRuleName()).thenReturn("team_rule");
        rules.add(rule);

        team = Mockito.mock(TeamType.class);
        Mockito.when(team.getTeamTypeName()).thenReturn("team_name");
        Mockito.when(team.getTeamRules()).thenReturn(rules);

        ava = Mockito.mock(TeamTypeAssetsAvailability.class);
        Mockito.when(ava.getCheerleadersCost()).thenReturn(1);
        Mockito.when(ava.getCheerleadersInitial()).thenReturn(2);
        Mockito.when(ava.getCheerleadersMax()).thenReturn(3);
        Mockito.when(ava.getCoachingDieCost()).thenReturn(4);
        Mockito.when(ava.getCoachingDieInitial()).thenReturn(5);
        Mockito.when(ava.getCoachingDieMax()).thenReturn(6);
        Mockito.when(ava.getCoachingStaffCost()).thenReturn(7);
        Mockito.when(ava.getDreadballCardCost()).thenReturn(8);
        Mockito.when(ava.getDreadballCardInitial()).thenReturn(9);
        Mockito.when(ava.getDreadballCardMax()).thenReturn(10);
        Mockito.when(ava.getTeamType()).thenReturn(team);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(ava),
                "{\"cheerleader_cost\":1,\"cheerleader_initial\":2,\"cheerleader_max\":3,\"coaching_die_cost\":4,\"coaching_die_initial\":5,\"coaching_die_max\":6,\"coaching_staff_cost\":7,\"dreadball_card_cost\":8,\"dreadball_card_initial\":9,\"dreadball_card_max\":10,\"team\":{\"team_rules\":[{\"name\":\"team_rule\"}],\"name\":\"team_name\"},\"initial_defensive_coach\":false,\"initial_offensive_coach\":false,\"initial_support_coach\":false}");
    }

}
