/**
 * Copyright 2016 the original author or authors
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

package com.wandrell.tabletop.dreadball.model.json.databind;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.wandrell.tabletop.dreadball.model.unit.Role;

/**
 * Serializer for the {@link Role} enum. It will print the {@code Role} as a
 * lower case string.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class RoleSerializer extends StdSerializer<Role> {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = -8321279976675187109L;

    /**
     * Default constructor.
     */
    public RoleSerializer() {
        this(Role.class);
    }

    /**
     * Creates a serializer for the specified class.
     * 
     * @param cls
     *            the class to serialize
     */
    public RoleSerializer(final Class<Role> cls) {
        super(cls);
    }

    @Override
    public final void serialize(final Role value, final JsonGenerator gen,
            final SerializerProvider provider) throws IOException {
        gen.writeString(String.valueOf(value).toLowerCase());
    }

}
