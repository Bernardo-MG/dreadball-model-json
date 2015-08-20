package com.wandrell.tabletop.dreadball.model.json.unit.component;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.unit.TeamPosition;
import com.wandrell.tabletop.dreadball.model.unit.component.ComponentLocation;
import com.wandrell.tabletop.dreadball.model.unit.component.UnitComponent;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.AttributesHolder;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface UnitComponentMixin extends UnitComponent {

    @Override
    @JsonProperty("abilities")
    public Collection<Ability> getAbilities();

    @Override
    @JsonProperty("attributes")
    public AttributesHolder getAttributes();

    @Override
    @JsonProperty("component_name")
    public String getComponentName();

    @Override
    @JsonProperty("cost")
    public Integer getCost();

    @Override
    @JsonProperty("location")
    public ComponentLocation getLocation();

    @Override
    @JsonProperty("team_positions")
    public Collection<TeamPosition> getTeamPositions();

}
