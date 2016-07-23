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

package com.wandrell.tabletop.dreadball.model.json.team;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

/**
 * Jackson mix-in interface for {@link SponsorTeam}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({ "cheerleaders", "dice", "players", "valoration",
        "rank_cost", "medibots", "sabotage_cards", "special_move_cards",
        "sponsor", "wagers" })
public interface SponsorTeamMixIn extends SponsorTeam, TeamMixIn<Unit> {

    @Override
    @JsonProperty("medibots")
    public Integer getMediBots();

    @Override
    @JsonProperty("rank_cost")
    public Integer getRankCost();

    @Override
    @JsonProperty("sabotage_cards")
    public Integer getSabotageCards();

    @Override
    @JsonProperty("special_move_cards")
    public Integer getSpecialMoveCards();

    @Override
    @JsonProperty
    public Sponsor getSponsor();

    @Override
    @JsonProperty
    public Integer getWagers();

}
