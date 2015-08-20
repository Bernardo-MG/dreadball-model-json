package com.wandrell.tabletop.dreadball.model.json.unit.component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface ComponentLocationMixin extends ComponentLocation {

    @Override
    @JsonProperty("component_location_name")
    public String getComponentLocationName();

}
