/**
 * Copyright 2015 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.wandrell.tabletop.dreadball.model.json.availability.asset;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wandrell.tabletop.dreadball.model.availability.asset.SponsorAssetsAvailability;

/**
 * Jackson mix-in interface for {@link SponsorAssetsAvailability}.
 * 
 * @author Bernardo Martínez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({ "affinity_cost", "cheerleader_cost",
        "cheerleader_unlock_cost", "coaching_die_cost", "medibot_cost",
        "sabotage_card_cost", "special_movement_card_cost", "team_cost_min",
        "wager_cost", "wager_max_count" })
public interface SponsorAssetsAvailabilityMixIn
        extends SponsorAssetsAvailability {

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
