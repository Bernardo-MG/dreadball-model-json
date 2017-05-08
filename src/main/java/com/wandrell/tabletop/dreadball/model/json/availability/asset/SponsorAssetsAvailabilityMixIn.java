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
import com.wandrell.tabletop.dreadball.model.availability.asset.SponsorAssetsAvailability;

/**
 * Jackson mix-in interface for {@link SponsorAssetsAvailability}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface SponsorAssetsAvailabilityMixIn
        extends SponsorAssetsAvailability {

    @Override
    @JsonProperty
    public Integer getAffinityGroupCost();

    @Override
    @JsonProperty
    public Integer getCheerleaderCost();

    @Override
    @JsonProperty
    public Integer getCheerleaderUnlockCost();

    @Override
    @JsonProperty
    public Integer getCoachingDieCost();

    @Override
    @JsonProperty
    public Integer getMediBotCost();

    @Override
    @JsonProperty
    public Integer getSabotageCardCost();

    @Override
    @JsonProperty
    public Integer getSpecialMovementCardCost();

    @Override
    @JsonProperty
    public Integer getTeamCostMin();

    @Override
    @JsonProperty
    public Integer getWagerCost();

    @Override
    @JsonProperty
    public Integer getWagerMaxCount();

}
