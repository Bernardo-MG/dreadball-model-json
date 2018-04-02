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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.availability.affinity;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dreadball.model.availability.affinity.SponsorAffinityGroupAvailability;
import com.bernardomg.tabletop.dreadball.model.json.availability.affinity.SponsorAffinityGroupAvailabilityMixIn;
import com.bernardomg.tabletop.dreadball.model.json.player.stats.AffinityGroupMixIn;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * Unit tests for {@link SponsorAffinityGroupAvailabilityMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorAffinityGroupAvailabilityMixIn {

    /**
     * Default constructor.
     */
    public TestSponsorAffinityGroupAvailabilityMixIn() {
        super();
    }

    /**
     * Tests that the JSON message is created with the correct affinity group.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_AffinityGroup() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.affinityGroups[0].name");

        Assert.assertEquals("affinity_group", value);
    }

    /**
     * Tests that the JSON message is created with the correct name.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Name() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.name");

        Assert.assertEquals("group_name", value);
    }

    /**
     * Tests that the JSON message is created with the correct rank increase
     * value.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_RankIncrease() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.rankIncrease");

        Assert.assertFalse((boolean) value);
    }

    /**
     * Returns the generated JSON to be tested.
     * 
     * @return the tested JSON
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    private final String getJson() throws JsonProcessingException {
        final ObjectMapper mapper; // Mapper for the JSON
        final Collection<AffinityGroup> affinities; // Ava affinities
        final AffinityGroup affinity;   // Mocked affinity
        final SponsorAffinityGroupAvailability ava; // Mocked ava

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(SponsorAffinityGroupAvailability.class,
                SponsorAffinityGroupAvailabilityMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);

        // Mocks affinities
        affinities = new ArrayList<>();
        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getName()).thenReturn("affinity_group");
        affinities.add(affinity);

        // Mocks availabilities
        ava = Mockito.mock(SponsorAffinityGroupAvailability.class);
        Mockito.when(ava.getName()).thenReturn("group_name");
        Mockito.when(ava.getAffinityGroups()).thenReturn(affinities);

        return mapper.writer().writeValueAsString(ava);
    }

}
