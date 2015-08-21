package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.unit.stats;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.json.unit.stats.AbilityMixIn;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;

public final class TestAbilityMixin {

    public TestAbilityMixin() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final Ability ability;

        mapper = new ObjectMapper();
        mapper.addMixIn(Ability.class, AbilityMixIn.class);

        ability = Mockito.mock(Ability.class);
        Mockito.when(ability.getAbilityName()).thenReturn("ability_name");

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(ability),
                "{\"name\":\"ability_name\"}");
    }

}
