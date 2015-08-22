package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.faction;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;
import com.wandrell.tabletop.dreadball.model.json.faction.TeamRuleMixIn;

public final class TestTeamRuleMixIn {

    public TestTeamRuleMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final TeamRule rule;

        mapper = new ObjectMapper();
        mapper.addMixIn(TeamRule.class, TeamRuleMixIn.class);

        rule = Mockito.mock(TeamRule.class);
        Mockito.when(rule.getTeamRuleName()).thenReturn("team_rule");

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(rule),
                "{\"name\":\"team_rule\"}");
    }

}
