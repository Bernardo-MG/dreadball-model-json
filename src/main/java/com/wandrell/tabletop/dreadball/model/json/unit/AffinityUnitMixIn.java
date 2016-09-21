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

package com.wandrell.tabletop.dreadball.model.json.unit;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wandrell.tabletop.dreadball.model.unit.AffinityGroup;
import com.wandrell.tabletop.dreadball.model.unit.AffinityUnit;

/**
 * Jackson mix-in interface for {@link AffinityUnit}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({ "name", "abilities", "attributes", "cost", "role",
        "templateName", "mvp", "giant", "affinityGroups", "hatedAffinityGroups",
        "allyCost", "friendCost", "strangerCost" })
public interface AffinityUnitMixIn extends AffinityUnit, UnitMixIn {

    @Override
    @JsonProperty
    public Collection<AffinityGroup> getAffinityGroups();

    @Override
    @JsonProperty
    public Integer getAllyCost();

    @Override
    @JsonProperty
    public Integer getFriendCost();

    @Override
    @JsonProperty
    public Collection<AffinityGroup> getHatedAffinityGroups();

    @Override
    @JsonProperty
    public Integer getStrangerCost();

}
