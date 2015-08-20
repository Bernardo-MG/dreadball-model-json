package com.wandrell.tabletop.dreadball.model.json.faction;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface TeamTypeMixin extends TeamType {

    @Override
    @JsonProperty("team_rules")
    public Collection<TeamRule> getTeamRules();

    @Override
    @JsonProperty("team_type_name")
    public String getTeamTypeName();

}
