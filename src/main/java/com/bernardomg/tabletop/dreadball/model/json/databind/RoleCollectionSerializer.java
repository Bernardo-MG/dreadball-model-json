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

package com.bernardomg.tabletop.dreadball.model.json.databind;

import java.io.IOException;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;
import com.bernardomg.tabletop.dreadball.model.unit.Role;

/**
 * Serializer for the {@link Role} enum. It will print the {@code Role} as a
 * lower case string.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class RoleCollectionSerializer
        extends StaticListSerializerBase<Collection<Role>> {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = -8321279976675187109L;

    /**
     * Default constructor.
     */
    public RoleCollectionSerializer() {
        super(Collection.class);
    }

    /**
     * Protected constructor. Required for the overriden methods.
     * 
     * @param src
     *            source
     * @param ser
     *            serializer
     * @param unwrapSingle
     *            unwrap single flag
     */
    protected RoleCollectionSerializer(final RoleCollectionSerializer src,
            final JsonSerializer<?> ser, final Boolean unwrapSingle) {
        super(src, ser, unwrapSingle);
    }

    @Override
    public final RoleCollectionSerializer _withResolved(final BeanProperty prop,
            final JsonSerializer<?> ser, final Boolean unwrapSingle) {
        return new RoleCollectionSerializer(this, ser, unwrapSingle);
    }

    @Override
    public final void serialize(final Collection<Role> value,
            final JsonGenerator gen, final SerializerProvider provider)
            throws IOException {

        gen.writeStartArray(value.size());

        for (final Object role : value) {
            gen.writeString(String.valueOf(role).toLowerCase());
        }

        gen.writeEndArray();
    }

    @Override
    protected final void acceptContentVisitor(
            final JsonArrayFormatVisitor visitor) throws JsonMappingException {
        visitor.itemsFormat(JsonFormatTypes.STRING);
    }

    @Override
    protected final JsonNode contentSchema() {
        return createSchemaNode("string", true);
    }

}
