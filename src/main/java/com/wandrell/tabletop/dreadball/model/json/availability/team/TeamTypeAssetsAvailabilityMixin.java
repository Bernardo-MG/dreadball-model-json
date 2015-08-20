package com.wandrell.tabletop.dreadball.model.json.availability.team;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.availability.team.TeamTypeAssetsAvailability;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface TeamTypeAssetsAvailabilityMixin extends TeamTypeAssetsAvailability {

    @Override
    @JsonProperty("cheerleader_cost")
    public Integer getCheerleadersCost();
    @Override
    @JsonProperty("cheerleader_initial")
    public Integer getCheerleadersInitial();
    @Override
    @JsonProperty("cheerleader_max")
    public Integer getCheerleadersMax();
    @Override
    @JsonProperty("coaching_die_cost")
    public Integer getCoachingDieCost();
    @Override
    @JsonProperty("coaching_die_initial")
    public Integer getCoachingDieInitial();
    @Override
    @JsonProperty("coaching_die_max")
    public Integer getCoachingDieMax();
    @Override
    @JsonProperty("coaching_staff_cost")
    public Integer getCoachingStaffCost();
    @Override
    @JsonProperty("dreadball_card_cost")
    public Integer getDreadballCardCost();
    @Override
    @JsonProperty("dreadball_card_initial")
    public Integer getDreadballCardInitial();
    @Override
    @JsonProperty("dreadball_card_max")
    public Integer getDreadballCardMax();
    @Override
    @JsonProperty("team_type")
    public TeamType getTeamType();
    @Override
    @JsonProperty("initial_defensive_coach")
    public Boolean isStartingWithDefensiveCoachingStaff();
    @Override
    @JsonProperty("initial_offensive_coach")
    public Boolean isStartingWithOffensiveCoachingStaff();
    @Override
    @JsonProperty("initial_support_coach")
    public Boolean isStartingWithSupportCoachingStaff();


}
