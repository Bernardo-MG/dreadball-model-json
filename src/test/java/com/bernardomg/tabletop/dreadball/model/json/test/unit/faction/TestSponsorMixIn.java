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

package com.bernardomg.tabletop.dreadball.model.json.test.unit.faction;

import java.util.ArrayList;
import java.util.Collection;

import org.mockito.Mockito;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.bernardomg.tabletop.dreadball.model.faction.Sponsor;
import com.bernardomg.tabletop.dreadball.model.json.faction.SponsorMixIn;
import com.bernardomg.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.bernardomg.tabletop.dreadball.model.unit.AffinityGroup;

/**
 * Unit tests for {@link UnitTemplateMixIn}.
 * <p>
 * Checks the following cases:
 * <ol>
 * <li>The JSON message is created correctly</li>
 * </ol>
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class TestSponsorMixIn {

    /**
     * Default constructor.
     */
    public TestSponsorMixIn() {
        super();
    }

    /**
     * Tests that the JSON message is created with the correct affinity groups.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_AffinityGroups() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.affinityGroups[0].name");

        Assert.assertEquals(value, "affinity_group");
    }

    /**
     * Tests that the JSON message is created with the correct cash.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Cash() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.cash");

        Assert.assertEquals(value, 10);
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

        Assert.assertEquals(value, "sponsor_name");
    }

    /**
     * Tests that the JSON message is created with the correct rank.
     * 
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    @Test
    public final void test_Rank() throws JsonProcessingException {
        final String json;  // Tested JSON
        final Object value; // Read value

        json = getJson();

        value = JsonPath.read(json, "$.rank");

        Assert.assertEquals(value, 20);
    }

    /**
     * Returns the generated JSON to be tested.
     * 
     * @return the tested JSON
     * @throws JsonProcessingException
     *             never, this is a required declaration
     */
    private final String getJson() throws JsonProcessingException {
        final ObjectMapper mapper;      // Mapper for the JSON
        final Collection<AffinityGroup> affinities; // Sponsor affinities
        final Sponsor sponsor;          // Mocked sponsor
        final AffinityGroup affinity;   // Mocked affinity

        // Creates mapper
        mapper = new ObjectMapper();
        mapper.addMixIn(Sponsor.class, SponsorMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);

        // Mocks affinities
        affinities = new ArrayList<>();
        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getName()).thenReturn("affinity_group");
        affinities.add(affinity);

        // Mocks sponsor
        sponsor = Mockito.mock(Sponsor.class);
        Mockito.when(sponsor.getName()).thenReturn("sponsor_name");
        Mockito.when(sponsor.getCash()).thenReturn(10);
        Mockito.when(sponsor.getRank()).thenReturn(20);
        Mockito.when(sponsor.getAffinityGroups()).thenReturn(affinities);

        return mapper.writer().writeValueAsString(sponsor);
    }

}
