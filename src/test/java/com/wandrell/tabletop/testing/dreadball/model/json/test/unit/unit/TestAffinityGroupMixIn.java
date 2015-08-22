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
