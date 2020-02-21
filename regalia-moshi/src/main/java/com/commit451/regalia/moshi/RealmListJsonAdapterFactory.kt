package com.commit451.regalia.moshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.realm.RealmList
import io.realm.RealmObject
import java.lang.reflect.Type

/**
 * Enables Moshi to parse and serialize [io.realm.RealmList]s. Install via your [com.squareup.moshi.Moshi.Builder]
 */
class RealmListJsonAdapterFactory : JsonAdapter.Factory {
    override fun create(type: Type, annotations: Set<Annotation?>, moshi: Moshi): JsonAdapter<*>? {
        val rawType = Types.getRawType(type)
        if (annotations.isNotEmpty()) return null
        return if (rawType == RealmList::class.java) {
            newRealmListAdapter<RealmObject>(type, moshi)?.nullSafe()
        } else null
    }

    companion object {
        @JvmStatic
        private fun <T : RealmObject?> newRealmListAdapter(type: Type, moshi: Moshi): JsonAdapter<RealmList<T>>? {
            val elementType = Types.collectionElementType(type, RealmList::class.java)
            val elementAdapter: JsonAdapter<T> = moshi.adapter(elementType)
            return RealmListMoshiConverter(elementAdapter)
        }
    }
}