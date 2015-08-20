package com.wandrell.tabletop.dreadball.model.json.unit;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface AdvancementUnitMixin extends AdvancementUnit, UnitMixin {

    @Override
    @JsonProperty("rank")
    public Integer getRank();

    @Override
    @JsonProperty("unspent_experience")
    public Integer getUnspentExperience();

    @Override
    @JsonProperty("valoration")
    public Integer getValoration();

}
