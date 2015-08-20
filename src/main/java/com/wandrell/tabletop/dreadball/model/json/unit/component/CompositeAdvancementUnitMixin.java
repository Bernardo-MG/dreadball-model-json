package com.wandrell.tabletop.dreadball.model.json.unit.component;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.json.unit.AdvancementUnitMixin;
import com.wandrell.tabletop.dreadball.model.unit.component.CompositeAdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.component.UnitComponent;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface CompositeAdvancementUnitMixin
        extends CompositeAdvancementUnit, AdvancementUnitMixin {

    @Override
    @JsonProperty("components")
    public Collection<UnitComponent> getComponents();

}
