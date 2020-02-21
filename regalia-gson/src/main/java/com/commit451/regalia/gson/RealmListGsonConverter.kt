package com.commit451.regalia.gson

import com.google.gson.*
import io.realm.RealmList
import io.realm.RealmObject
import java.lang.reflect.Type

/**
 * Allows serialization and deserialization of RealmLists. Adjust to whatever your list data type is.
 * Make sure you add it to your Gson instance.
 *
 * @see [http://stackoverflow.com/a/30014833/895797](http://stackoverflow.com/a/30014833/895797)
 */
abstract class RealmListGsonConverter<T : RealmObject?> : JsonSerializer<RealmList<T>>, JsonDeserializer<RealmList<T>> {
    /**
     * Return the type of your object, which can probably just be YourClass.class
     * @return the type
     */
    abstract val objectType: Type?

    override fun serialize(src: RealmList<T>, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        val ja = JsonArray()
        for (item in src) {
            ja.add(context.serialize(item))
        }
        return ja
    }

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type,
                             context: JsonDeserializationContext): RealmList<T> {
        val items = RealmList<T>()
        val ja = json.asJsonArray
        for (je in ja) {
            items.add(context.deserialize<Any>(je, objectType) as T)
        }
        return items
    }
}