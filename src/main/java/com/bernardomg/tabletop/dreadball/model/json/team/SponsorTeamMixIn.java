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

package com.bernardomg.tabletop.dreadball.model.json.team;

import com.bernardomg.tabletop.dreadball.model.faction.Sponsor;
import com.bernardomg.tabletop.dreadball.model.player.TeamPlayer;
import com.bernardomg.tabletop.dreadball.model.player.stats.AffinityGroup;
import com.bernardomg.tabletop.dreadball.model.team.SponsorTeam;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Jackson mix-in interface for {@link SponsorTeam}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface SponsorTeamMixIn extends SponsorTeam, TeamMixIn<TeamPlayer> {

    @Override
    @JsonProperty
    public Iterable<AffinityGroup> getAdditionalAffinityGroups();

    @Override
    @JsonProperty
    public Integer getBaseRank();

    @Override
    @JsonProperty
    public Integer getCurrentRank();

    @Override
    @JsonProperty
    public Integer getMediBots();

    @Override
    @JsonProperty
    public Integer getNastySurpriseCards();

    @Override
    @JsonProperty
    public Integer getRankCost();

    @Override
    @JsonProperty
    public Integer getSpecialMoveCards();

    @Override
    @JsonProperty
    public Sponsor getSponsor();

    @Override
    @JsonProperty
    public Integer getWagers();

}
