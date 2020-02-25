package com.commit451.regalia.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import io.realm.RealmList
import io.realm.RealmObject
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type


/**
 * Created by crazy on 2/23/20 to long live and prosper !
 */


inline fun <reified T : RealmObject?> realmGson(): Gson {
    val realmListType = object : TypeToken<RealmList<T>>() {}.type
    val realmListConverter = object : RealmListGsonConverter<T>() {
        override val objectType: Type?
            get() = T::class.java
    }

    return GsonBuilder()
            .registerTypeAdapter(realmListType, realmListConverter)
            .create()
}


inline fun <reified T : RealmObject?> realmGsonTypeAndConverter(): Pair<Type, RealmListGsonConverter<T>> {
    val realmListType = object : TypeToken<RealmList<T>>() {}.type
    val realmListConverter = object : RealmListGsonConverter<T>() {
        override val objectType: Type?
            get() = T::class.java
    }

    return Pair(realmListType, realmListConverter)
}


inline fun <reified T : RealmObject?> realmGson(vararg classes: Class<T>): Gson {

    val gson = GsonBuilder()
    classes.forEach {
        val realmListType = object : TypeToken<RealmList<T>>() {}.type

        val realmListConverter = object : RealmListGsonConverter<T>() {
            override val objectType: Type?
                get() = it
        }

        gson.registerTypeAdapter(realmListType, realmListConverter)
    }
    return gson
            .create()
}



fun <T:RealmObject> realmGsonConverterFactory(vararg classes: Class<T>): GsonConverterFactory {

    val gsonBuilder = GsonBuilder()
    classes.forEach {
        val realmListType = object : TypeToken<RealmList<T>>() {}.type

        val realmListConverter = object : RealmListGsonConverter<T>() {
            override val objectType: Type?
                get() = it
        }

        gsonBuilder.registerTypeAdapter(realmListType, realmListConverter)
    }
    val gson =  gsonBuilder
            .create()

    return GsonConverterFactory.create(gson)
}



