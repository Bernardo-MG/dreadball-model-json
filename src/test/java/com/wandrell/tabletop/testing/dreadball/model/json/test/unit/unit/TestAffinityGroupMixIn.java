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
package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.unit;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

public final class TestAffinityGroupMixIn {

    public TestAffinityGroupMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final AffinityGroup affinity;

        mapper = new ObjectMapper();
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);

        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getAffinityGroupName())
                .thenReturn("affinity_group");

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(affinity),
                "{\"name\":\"affinity_group\"}");
    }

}
