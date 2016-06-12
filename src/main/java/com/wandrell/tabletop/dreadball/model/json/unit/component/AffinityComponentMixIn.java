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

package com.wandrell.tabletop.dreadball.model.json.unit.component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wandrell.tabletop.dreadball.model.unit.component.AffinityComponent;

/**
 * Jackson mix-in interface for {@link AffinityComponent}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({ "abilities", "attributes", "name", "cost", "location",
        "team_positions", "ally_cost", "friend_cost", "stranger_cost" })
public interface AffinityComponentMixIn
        extends AffinityComponent, ComponentMixIn {

    @Override
    @JsonProperty("ally_cost")
    public Integer getAllyCost();

    @Override
    @JsonProperty("friend_cost")
    public Integer getFriendCost();

    @Override
    @JsonProperty("stranger_cost")
    public Integer getStrangerCost();

}
