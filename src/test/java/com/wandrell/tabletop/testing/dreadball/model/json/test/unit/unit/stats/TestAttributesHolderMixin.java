package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.unit.stats;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AttributesHolderMixIn;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public final class TestAttributesHolderMixin {

    public TestAttributesHolderMixin() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final AttributesHolder attributes;

        mapper = new ObjectMapper();
        mapper.addMixIn(AttributesHolder.class, AttributesHolderMixIn.class);

        attributes = Mockito.mock(AttributesHolder.class);
        Mockito.when(attributes.getArmor()).thenReturn(1);
        Mockito.when(attributes.getMovement()).thenReturn(2);
        Mockito.when(attributes.getSkill()).thenReturn(3);
        Mockito.when(attributes.getSpeed()).thenReturn(4);
        Mockito.when(attributes.getStrength()).thenReturn(5);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(attributes),
                "{\"armor\":1,\"movement\":2,\"skill\":3,\"speed\":4,\"strength\":5}");
    }

}
