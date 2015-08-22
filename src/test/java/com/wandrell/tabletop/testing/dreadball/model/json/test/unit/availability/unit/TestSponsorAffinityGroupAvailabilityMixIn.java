package com.wandrell.tabletop.testing.dreadball.model.json.test.unit.availability.unit;

import java.util.Collection;
import java.util.LinkedList;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.json.availability.unit.SponsorAffinityGroupAvailabilityMixIn;
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityGroupMixIn;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

public final class TestSponsorAffinityGroupAvailabilityMixIn {

    public TestSponsorAffinityGroupAvailabilityMixIn() {
        super();
    }

    @Test
    public final void testJSON() throws JsonProcessingException {
        final ObjectMapper mapper;
        final ObjectWriter writer;
        final Collection<AffinityGroup> affinities;
        final AffinityGroup affinity;
        final SponsorAffinityGroupAvailability ava;

        mapper = new ObjectMapper();
        mapper.addMixIn(SponsorAffinityGroupAvailability.class,
                SponsorAffinityGroupAvailabilityMixIn.class);
        mapper.addMixIn(AffinityGroup.class, AffinityGroupMixIn.class);

        affinities = new LinkedList<>();
        affinity = Mockito.mock(AffinityGroup.class);
        Mockito.when(affinity.getAffinityGroupName())
                .thenReturn("affinity_group");
        affinities.add(affinity);

        ava = Mockito.mock(SponsorAffinityGroupAvailability.class);
        Mockito.when(ava.getName()).thenReturn("group_name");
        Mockito.when(ava.getAffinityGroups()).thenReturn(affinities);

        writer = mapper.writer();

        Assert.assertEquals(writer.writeValueAsString(ava),
                "{\"affinity_groups\":[{\"name\":\"affinity_group\"}],\"name\":\"group_name\",\"rank_increase\":false}");
    }

}
