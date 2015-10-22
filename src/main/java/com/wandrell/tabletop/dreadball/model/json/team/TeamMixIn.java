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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wandrell.tabletop.dreadball.model.team.BaseTeam;
import com.wandrell.tabletop.dreadball.model.unit.UnitTemplate;

/**
 * Jackson mix-in interface for {@link BaseTeam}.
 * 
 * @author Bernardo Martínez Garrido
 * @param <U>
 *            the type of unit the {@code Team} contains
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({ "cheerleaders", "dice", "players", "valoration" })
public interface TeamMixIn<U extends UnitTemplate> extends BaseTeam<U> {

    @Override
    @JsonProperty("cheerleaders")
    public Integer getCheerleaders();

    @Override
    @JsonProperty("dice")
    public Integer getCoachingDice();

    @Override
    @JsonProperty
    public Map<Integer, U> getPlayers();

    @Override
    @JsonProperty("valoration")
    public Integer getValoration();

}
