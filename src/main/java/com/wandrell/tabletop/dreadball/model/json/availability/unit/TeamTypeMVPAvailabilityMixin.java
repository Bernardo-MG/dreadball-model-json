package com.wandrell.tabletop.dreadball.model.json.availability.unit;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.availability.unit.TeamTypeMVPAvailability;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface TeamTypeMVPAvailabilityMixin extends TeamTypeMVPAvailability {

    @Override
    @JsonProperty("team_type")
    public TeamType getTeamType();
    @Override
    @JsonProperty("unit")
    public Unit getUnit();

}
