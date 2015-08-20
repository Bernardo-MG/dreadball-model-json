package com.wandrell.tabletop.dreadball.model.json.unit;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface AffinityGroupMixin extends AffinityGroup {

    @Override
    @JsonProperty("affinity_group_name")
    public String getAffinityGroupName();

}
