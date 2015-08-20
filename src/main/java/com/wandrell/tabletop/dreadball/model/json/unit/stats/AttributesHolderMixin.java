package com.wandrell.tabletop.dreadball.model.json.unit.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

public interface AttributesHolderMixin extends AttributesHolder {

    @Override
    @JsonProperty("armor")
    public Integer getArmor();

    @Override
    @JsonProperty("movement")
    public Integer getMovement();

    @Override
    @JsonProperty("skill")
    public Integer getSkill();

    @Override
    @JsonProperty("speed")
    public Integer getSpeed();

    @Override
    @JsonProperty("strength")
    public Integer getStrength();

}
