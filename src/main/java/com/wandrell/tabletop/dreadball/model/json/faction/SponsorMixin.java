package com.wandrell.tabletop.dreadball.model.json.faction;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface SponsorMixin extends Sponsor {

    @Override
    @JsonProperty("affinity_groups")
    public Collection<AffinityGroup> getAffinityGroups();
    @Override
    @JsonProperty("cash")
    public Integer getCash();
    @Override
    @JsonProperty("rank")
    public Integer getRank();
    @Override
    @JsonProperty("sponsor_name")
    public String getSponsorName();

}
