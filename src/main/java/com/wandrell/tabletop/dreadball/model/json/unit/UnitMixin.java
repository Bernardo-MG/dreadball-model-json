package com.wandrell.tabletop.dreadball.model.json.unit;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface UnitMixin extends Unit {

    @Override
    @JsonProperty("abilities")
    public Collection<Ability> getAbilities();

    @Override
    @JsonProperty("attributes")
    public AttributesHolder getAttributes();

    @Override
    @JsonProperty("cost")
    public Integer getCost();

    @Override
    @JsonProperty("team_position")
    public TeamPosition getPosition();

    @Override
    @JsonProperty("template_name")
    public String getTemplateName();

    @Override
    @JsonProperty("giant")
    public Boolean isGiant();

}
