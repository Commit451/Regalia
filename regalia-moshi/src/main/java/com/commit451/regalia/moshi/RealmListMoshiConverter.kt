package com.commit451.regalia.moshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import io.realm.RealmList
import io.realm.RealmObject
import java.io.IOException

/**
 * Derived from this example:
 * https://github.com/square/moshi/blob/master/moshi/src/main/java/com/squareup/moshi/CollectionJsonAdapter.java
 */
internal class RealmListMoshiConverter<T : RealmObject?>(private val elementAdapter: JsonAdapter<T>) : JsonAdapter<RealmList<T>>() {
    @Throws(IOException::class)
    override fun toJson(writer: JsonWriter, value: RealmList<T>?) {
        writer.beginArray()
        value?.forEach {
            elementAdapter.toJson(writer, it)
        }
        writer.endArray()
    }

    @Throws(IOException::class)
    override fun fromJson(reader: JsonReader): RealmList<T>? {
        val result = RealmList<T>()
        reader.beginArray()
        while (reader.hasNext()) {
            result.add(elementAdapter.fromJson(reader))
        }
        reader.endArray()
        return result
    }

}