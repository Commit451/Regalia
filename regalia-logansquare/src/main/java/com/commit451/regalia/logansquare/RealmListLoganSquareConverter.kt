package com.commit451.regalia.logansquare

import com.bluelinelabs.logansquare.JsonMapper
import com.bluelinelabs.logansquare.LoganSquare
import com.bluelinelabs.logansquare.NoSuchTypeConverterException
import com.bluelinelabs.logansquare.typeconverters.TypeConverter
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import io.realm.RealmList
import io.realm.RealmObject
import java.io.IOException

/**
 * The universal converter for RealmList.
 * You can use this with RealmObjects:
 * 1. Annotated with @JsonObject
 * 2. With custom converters.
 */
abstract class RealmListLoganSquareConverter<T : RealmObject?> : TypeConverter<RealmList<T>?> {
    private lateinit var typeConverter: TypeConverter<T>
    private lateinit var mapper: JsonMapper<T>
    abstract val objectClass: Class<T>?
    private fun init() {
        try {
            typeConverter = LoganSquare.typeConverterFor(objectClass)
        } catch (e: NoSuchTypeConverterException) {
            mapper = LoganSquare.mapperFor(objectClass)
        }
    }

    @Throws(IOException::class)
    override fun parse(jsonParser: JsonParser): RealmList<T>? {
        init()
        val list = RealmList<T>()
        if (jsonParser.currentToken == JsonToken.START_ARRAY) {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                val element = typeConverter.parse(jsonParser)
                if (element != null) {
                    list.add(element)
                }
            }
        }
        return list
    }

    @Throws(IOException::class)
    override fun serialize(list: RealmList<T>?, fieldName: String, writeFieldNameForObject: Boolean, jsonGenerator: JsonGenerator) {
        if (writeFieldNameForObject) {
            if (list == null) {
                return
            }
            jsonGenerator.writeFieldName(fieldName)
        }
        if (list == null) {
            jsonGenerator.writeNull()
            return
        }
        jsonGenerator.writeStartArray()
        init()
        for (t in list) {
            if (t != null) {
                typeConverter.serialize(t, fieldName, false, jsonGenerator)
            } else {
                jsonGenerator.writeNull()
            }
        }
        jsonGenerator.writeEndArray()
    }
}