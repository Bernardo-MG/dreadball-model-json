package com.wandrell.tabletop.dreadball.model.json.availability.team;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.availability.team.SponsorAssetsAvailability;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface SponsorAssetsAvailabilityMixin extends SponsorAssetsAvailability {

    @Override
    @JsonProperty("affinity_cost")
    public Integer getAffinityGroupCost();
    @Override
    @JsonProperty("cheerleader_cost")
    public Integer getCheerleaderCost();
    @Override
    @JsonProperty("cheerleader_unlock_cost")
    public Integer getCheerleaderUnlockCost();
    @Override
    @JsonProperty("coaching_die_cost")
    public Integer getCoachingDieCost();
    @Override
    @JsonProperty("medibot_cost")
    public Integer getMediBotCost();
    @Override
    @JsonProperty("sabotage_card_cost")
    public Integer getSabotageCardCost();
    @Override
    @JsonProperty("special_movement_card_cost")
    public Integer getSpecialMovementCardCost();
    @Override
    @JsonProperty("team_cost_min")
    public Integer getTeamCostMin();
    @Override
    @JsonProperty("wager_cost")
    public Integer getWagerCost();
    @Override
    @JsonProperty("wager_max_count")
    public Integer getWagerMaxCount();

}
