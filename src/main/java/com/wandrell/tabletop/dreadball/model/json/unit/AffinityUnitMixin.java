package com.wandrell.tabletop.dreadball.model.json.unit;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface AffinityUnitMixin extends AffinityUnit, UnitMixin {

    @Override
    @JsonProperty("affinity_groups")
    public Collection<AffinityGroup> getAffinityGroups();

    @Override
    @JsonProperty("ally_cost")
    public Integer getAllyCost();

    @Override
    @JsonProperty("friend_cost")
    public Integer getFriendCost();

    @Override
    @JsonProperty("stranger_cost")
    public Integer getStrangerCost();

}
