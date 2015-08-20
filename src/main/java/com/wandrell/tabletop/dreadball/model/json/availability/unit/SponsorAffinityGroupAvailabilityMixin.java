package com.wandrell.tabletop.dreadball.model.json.availability.unit;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.availability.unit.SponsorAffinityGroupAvailability;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface SponsorAffinityGroupAvailabilityMixin extends SponsorAffinityGroupAvailability {

    @Override
    @JsonProperty("affinity_groups")
    public Collection<AffinityGroup> getAffinityGroups();
    @Override
    @JsonProperty("name")
    public String getName();
    @Override
    @JsonProperty("rank_increase")
    public Boolean isIncludingRankIncrease();
    
}
