package com.wandrell.tabletop.dreadball.model.json.unit.component;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.json.unit.AffinityUnitMixin;
import com.wandrell.tabletop.dreadball.model.unit.component.CompositeAffinityUnit;
import com.wandrell.tabletop.dreadball.model.unit.component.UnitComponent;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface CompositeAffinityUnitMixin
        extends CompositeAffinityUnit, AffinityUnitMixin {

    @Override
    @JsonProperty("components")
    public Collection<UnitComponent> getComponents();

}
