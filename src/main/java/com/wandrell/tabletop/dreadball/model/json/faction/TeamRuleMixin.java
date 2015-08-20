package com.wandrell.tabletop.dreadball.model.json.faction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.faction.TeamRule;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface TeamRuleMixin extends TeamRule {

    @Override
    @JsonProperty("team_rule_name")
    public String getTeamRuleName();

}
