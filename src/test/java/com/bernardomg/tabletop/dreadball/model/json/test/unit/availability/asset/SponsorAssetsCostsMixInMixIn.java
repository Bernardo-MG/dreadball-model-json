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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.availability.asset;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.availability.asset.SponsorAssetsCosts;
import com.bernardomg.tabletop.dreadball.model.json.availability.asset.SponsorAssetsCostsMixIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * Unit tests for {@link SponsorAssetsCostsMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class SponsorAssetsCostsMixInMixIn {

    /**
     * Default constructor.
     */
    public SponsorAssetsCostsMixInMixIn() {
        super();
    }

    /**
     * Tests that the JSON message is created with the correct affinity group
     * cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_AffinityGroupCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.affinityGroupCost");

        Assert.assertEquals(1, value);
    }

    /**
     * Tests that the JSON message is created with the correct cheerleader cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_CheerleaderCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.cheerleaderCost");

        Assert.assertEquals(2, value);
    }

    /**
     * Tests that the JSON message is created with the correct coaching die
     * cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_CoachingDieCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.coachingDieCost");

        Assert.assertEquals(3, value);
    }

    /**
     * Tests that the JSON message is created with the correct medibot cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_MedibotCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.mediBotCost");

        Assert.assertEquals(4, value);
    }

    /**
     * Tests that the JSON message is created with the correct nasty surprise
     * card cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_NastySurpriseCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.nastySurpriseCardCost");

        Assert.assertEquals(5, value);
    }

    /**
     * Tests that the JSON message is created with the correct special movement
     * card cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_SpecialMovementCardCost()
            throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.specialMoveCardCost");

        Assert.assertEquals(6, value);
    }

    /**
     * Tests that the JSON message is created with the correct wager cost.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_WagerCost() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.wagerCost");

        Assert.assertEquals(7, value);
    }

    /**
     * Returns the generated JSON to be tested.
     * 
     * @return the tested JSON
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    private final String getJson() throws JsonProcessingException {
        final ObjectMapper mapper;    // Mapper for the JSON
        final SponsorAssetsCosts ava; // Mocked ava

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(SponsorAssetsCosts.class,
                SponsorAssetsCostsMixIn.class);

        // Mocks availabilities
        ava = Mockito.mock(SponsorAssetsCosts.class);
        Mockito.when(ava.getAffinityGroupCost()).thenReturn(1);
        Mockito.when(ava.getCheerleaderCost()).thenReturn(2);
        Mockito.when(ava.getCoachingDieCost()).thenReturn(3);
        Mockito.when(ava.getMediBotCost()).thenReturn(4);
        Mockito.when(ava.getNastySurpriseCardCost()).thenReturn(5);
        Mockito.when(ava.getSpecialMoveCardCost()).thenReturn(6);
        Mockito.when(ava.getWagerCost()).thenReturn(7);

        return mapper.writer().writeValueAsString(ava);
    }

}
