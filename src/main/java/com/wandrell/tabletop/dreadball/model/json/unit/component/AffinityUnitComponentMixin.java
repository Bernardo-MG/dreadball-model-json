package com.wandrell.tabletop.dreadball.model.json.unit.component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.unit.component.AffinityUnitComponent;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface AffinityUnitComponentMixin
        extends AffinityUnitComponent, UnitComponentMixin {
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
