package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.availability.team;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.availability.team.SponsorAssetsAvailability;
import com.wandrell.tabletop.dreadball.model.json.availability.team.SponsorAssetsAvailabilityMixIn;

public final class TestSponsorAssetsAvailabilityMixIn {

    public TestSponsorAssetsAvailabilityMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final SponsorAssetsAvailability ava;

        mapper = new ObjectMapper();
        mapper.addMixIn(SponsorAssetsAvailability.class,
                SponsorAssetsAvailabilityMixIn.class);

        ava = Mockito.mock(SponsorAssetsAvailability.class);
        Mockito.when(ava.getAffinityGroupCost()).thenReturn(1);
        Mockito.when(ava.getCheerleaderCost()).thenReturn(2);
        Mockito.when(ava.getCheerleaderUnlockCost()).thenReturn(3);
        Mockito.when(ava.getCoachingDieCost()).thenReturn(4);
        Mockito.when(ava.getMediBotCost()).thenReturn(5);
        Mockito.when(ava.getSabotageCardCost()).thenReturn(6);
        Mockito.when(ava.getSpecialMovementCardCost()).thenReturn(7);
        Mockito.when(ava.getTeamCostMin()).thenReturn(8);
        Mockito.when(ava.getWagerCost()).thenReturn(9);
        Mockito.when(ava.getWagerMaxCount()).thenReturn(10);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(ava),
                "{\"affinity_cost\":1,\"cheerleader_cost\":2,\"cheerleader_unlock_cost\":3,\"coaching_die_cost\":4,\"medibot_cost\":5,\"sabotage_card_cost\":6,\"special_movement_card_cost\":7,\"team_cost_min\":8,\"wager_cost\":9,\"wager_max_count\":10}");
    }

}
