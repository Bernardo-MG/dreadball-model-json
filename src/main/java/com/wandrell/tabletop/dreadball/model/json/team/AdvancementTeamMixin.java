package com.wandrell.tabletop.dreadball.model.json.team;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;
import com.wandrell.tabletop.dreadball.model.team.AdvancementTeam;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface AdvancementTeamMixin extends AdvancementTeam, TeamMixin<AdvancementUnit> {

    @Override
    @JsonProperty("cash")
    public Integer getCash();
    @Override
    @JsonProperty("dreadball_cards")
    public Integer getDreadballCards();
    @Override
    @JsonProperty("team_name")
    public String getTeamName();
    @Override
    @JsonProperty("team_type")
    public TeamType getTeamType();
    @Override
    @JsonProperty("defensive_coach")
    public Boolean hasDefensiveCoachingStaff();
    @Override
    @JsonProperty("offensive_coach")
    public Boolean hasOffensiveCoachingStaff();
    @Override
    @JsonProperty("support_coach")
    public Boolean hasSupportCoachingStaff();

}
