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

package com.bernardomg.tabletop.dreadball.model.json.player.component;

import java.util.Collection;

import com.bernardomg.tabletop.dreadball.model.json.databind.RoleCollectionSerializer;
import com.bernardomg.tabletop.dreadball.model.player.Role;
import com.bernardomg.tabletop.dreadball.model.player.component.Component;
import com.bernardomg.tabletop.dreadball.model.player.component.ComponentLocation;
import com.bernardomg.tabletop.dreadball.model.player.stats.Ability;
import com.bernardomg.tabletop.dreadball.model.player.stats.Attributes;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Jackson mix-in interface for {@link Component}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface ComponentMixIn extends Component {

    @Override
    @JsonProperty
    public Collection<Ability> getAbilities();

    @Override
    @JsonProperty
    @JsonUnwrapped
    public Attributes getAttributes();

    @Override
    @JsonProperty
    public Integer getCost();

    @Override
    @JsonProperty
    public ComponentLocation getLocation();

    @Override
    @JsonProperty
    public String getName();

    @Override
    @JsonProperty
    @JsonSerialize(using = RoleCollectionSerializer.class)
    public Collection<Role> getRoles();

}
