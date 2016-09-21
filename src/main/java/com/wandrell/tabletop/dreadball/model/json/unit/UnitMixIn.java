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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wandrell.tabletop.dreadball.model.json.databind.RoleSerializer;
import com.wandrell.tabletop.dreadball.model.unit.Role;
import com.wandrell.tabletop.dreadball.model.unit.Unit;
import com.wandrell.tabletop.dreadball.model.unit.stats.Ability;
import com.wandrell.tabletop.dreadball.model.unit.stats.Attributes;

/**
 * Jackson mix-in interface for {@link Unit}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonPropertyOrder({ "name", "abilities", "attributes", "cost", "role",
        "templateName", "mvp", "giant" })
public interface UnitMixIn extends Unit {

    @Override
    @JsonProperty
    public Collection<Ability> getAbilities();

    @Override
    @JsonProperty
    public Attributes getAttributes();

    @Override
    @JsonProperty
    public Integer getCost();

    @Override
    @JsonProperty
    public Boolean getGiant();

    @Override
    @JsonProperty
    public Boolean getMvp();

    @Override
    @JsonProperty
    public String getName();

    @Override
    @JsonProperty
    @JsonSerialize(using = RoleSerializer.class)
    public Role getRole();

    @Override
    @JsonProperty
    public String getTemplateName();

}
