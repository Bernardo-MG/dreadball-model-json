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
import com.wandrell.tabletop.dreadball.model.availability.asset.TeamTypeAssetsAvailability;
import com.wandrell.tabletop.dreadball.model.faction.TeamType;

/**
 * Jackson mix-in interface for {@link TeamTypeAssetsAvailability}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({ "cheerleaderCost", "cheerleaderInitial", "cheerleaderMax",
        "coachingDieCost", "coachingDieInitial", "coachingDieMax",
        "coachingStaffCost", "dreadballCardCost", "dreadballCardInitial",
        "dreadballCardMax", "teamType", "startingWithDefensiveCoachingStaff",
        "startingWithOffensiveCoachingStaff",
        "startingWithSupportCoachingStaff" })
public interface TeamTypeAssetsAvailabilityMixIn
        extends TeamTypeAssetsAvailability {

    @Override
    @JsonProperty
    public Integer getCheerleaderCost();

    @Override
    @JsonProperty
    public Integer getCheerleaderInitial();

    @Override
    @JsonProperty
    public Integer getCheerleaderMax();

    @Override
    @JsonProperty
    public Integer getCoachingDieCost();

    @Override
    @JsonProperty
    public Integer getCoachingDieInitial();

    @Override
    @JsonProperty
    public Integer getCoachingDieMax();

    @Override
    @JsonProperty
    public Integer getCoachingStaffCost();

    @Override
    @JsonProperty
    public Integer getDreadballCardCost();

    @Override
    @JsonProperty
    public Integer getDreadballCardInitial();

    @Override
    @JsonProperty
    public Integer getDreadballCardMax();

    @Override
    @JsonProperty
    public Boolean getStartingWithDefensiveCoachingStaff();

    @Override
    @JsonProperty
    public Boolean getStartingWithOffensiveCoachingStaff();

    @Override
    @JsonProperty
    public Boolean getStartingWithSupportCoachingStaff();

    @Override
    @JsonProperty
    public TeamType getTeamType();

}
