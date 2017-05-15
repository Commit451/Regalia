package com.commit451.regalia.logansquare;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.bluelinelabs.logansquare.NoSuchTypeConverterException;
import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * The universal converter for RealmList.
 * You can use this with RealmObjects:
 * 1. Annotated with @JsonObject
 * 2. With custom converters.
 *
 * @author Krzysztof Miemiec
 */
public abstract class RealmListLoganSquareConverter<T extends RealmObject> implements TypeConverter<RealmList<T>> {

    private Class<T> clazz;
    private TypeConverter<T> typeConverter;
    private JsonMapper<T> mapper;

    public RealmListLoganSquareConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    private void init() {
        if (typeConverter == null && mapper == null) {
            try {
                typeConverter = LoganSquare.typeConverterFor(clazz);
            } catch (NoSuchTypeConverterException e) {
                mapper = LoganSquare.mapperFor(clazz);
            }
        }
    }

    @Override
    public RealmList<T> parse(JsonParser jsonParser) throws IOException {
        init();
        RealmList<T> list = new RealmList<>();
        if (jsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                T object = typeConverter != null ? typeConverter.parse(jsonParser) : mapper.parse(jsonParser);
                if (object != null) {
                    list.add(object);
                }
            }
        }
        return list;
    }

    @Override
    public void serialize(RealmList<T> list, String fieldName, boolean writeFieldNameForObject, JsonGenerator jsonGenerator) throws IOException {
        if (writeFieldNameForObject) {
            if (list == null) {
                return;
            }
            jsonGenerator.writeFieldName(fieldName);
        }
        if (list == null) {
            jsonGenerator.writeNull();
            return;
        }
        jsonGenerator.writeStartArray();

        init();
        for (T object : list) {
            if (object != null) {
                if (typeConverter != null) {
                    typeConverter.serialize(object, fieldName, false, jsonGenerator);
                } else {
                    mapper.serialize(object, jsonGenerator, true);
                }
            } else {
                jsonGenerator.writeNull();
            }
        }
        jsonGenerator.writeEndArray();
    }
}