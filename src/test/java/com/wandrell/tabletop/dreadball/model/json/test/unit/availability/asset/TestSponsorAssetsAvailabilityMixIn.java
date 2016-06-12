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

package com.wandrell.tabletop.dreadball.model.json.test.unit.availability.asset;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.availability.asset.SponsorAssetsAvailability;
import com.wandrell.tabletop.dreadball.model.json.availability.asset.SponsorAssetsAvailabilityMixIn;

/**
 * Unit tests for {@link SponsorAssetsAvailabilityMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorAssetsAvailabilityMixIn {

    /**
     * Default constructor.
     */
    public TestSponsorAssetsAvailabilityMixIn() {
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
        final ObjectMapper mapper; // Mapper for the JSON
        final ObjectWriter writer; // Writer for the JSON
        final SponsorAssetsAvailability ava; // Mocked ava

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
