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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wandrell.tabletop.dreadball.model.unit.AdvancementUnit;
import com.wandrell.tabletop.dreadball.model.unit.component.UnitComponent;

/**
 * Jackson mix-in interface for {@link AdvancementUnit}.
 * 
 * @author Bernardo Martínez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({ "abilities", "attributes", "cost", "team_position",
        "template_name", "giant", "implant", "rank", "unspent_experience",
        "valoration" })
public interface AdvancementUnitMixIn
        extends AdvancementUnit, UnitTemplateMixIn {

    @Override
    @JsonProperty("implant")
    public UnitComponent getGraftedImplant();

    @Override
    @JsonProperty
    public Integer getRank();

    @Override
    @JsonProperty("unspent_experience")
    public Integer getUnspentExperience();

    @Override
    @JsonProperty
    public Integer getValoration();

}
