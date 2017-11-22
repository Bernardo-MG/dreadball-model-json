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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.bernardomg.tabletop.dreadball.model.faction.TeamType;
import com.bernardomg.tabletop.dreadball.model.team.AdvancementTeam;
import com.bernardomg.tabletop.dreadball.model.unit.AdvancementUnit;

/**
 * Jackson mix-in interface for {@link AdvancementTeam}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface AdvancementTeamMixIn
        extends AdvancementTeam, TeamMixIn<AdvancementUnit> {

    @Override
    @JsonProperty
    public Integer getCash();

    @Override
    @JsonProperty
    public Boolean getDefensiveCoachingStaff();

    @Override
    @JsonProperty
    public Integer getDreadballCards();

    @Override
    @JsonProperty
    public String getName();

    @Override
    @JsonProperty
    public Boolean getOffensiveCoachingStaff();

    @Override
    @JsonProperty
    public Boolean getSupportCoachingStaff();

    @Override
    @JsonProperty
    public TeamType getTeamType();

}
