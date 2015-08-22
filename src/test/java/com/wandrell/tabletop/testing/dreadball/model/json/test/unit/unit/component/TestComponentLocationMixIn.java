package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.unit.component;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.json.unit.component.ComponentLocationMixIn;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;

public final class TestComponentLocationMixIn {

    public TestComponentLocationMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final ComponentLocation location;

        mapper = new ObjectMapper();
        mapper.addMixIn(ComponentLocation.class, ComponentLocationMixIn.class);

        location = Mockito.mock(ComponentLocation.class);
        Mockito.when(location.getComponentLocationName())
                .thenReturn("component_location");

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(location),
                "{\"name\":\"component_location\"}");
    }

}
