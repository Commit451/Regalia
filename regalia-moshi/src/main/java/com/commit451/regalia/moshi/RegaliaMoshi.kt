package com.commit451.regalia.moshi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by crazy on 2/21/20 to long live and prosper !
 */
object RegaliaMoshi {

    /**
     * You can use it as
     * It depends on 'com.squareup.moshi:moshi-kotlin:1.9.2' and 'com.squareup.retrofit2:converter-moshi:2.7.1'
     * Retrofit.Builder .addConverterFactory(moshiConverterFactory)
     */
    val moshiConverterFactory by lazy {
        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(RealmListJsonAdapterFactory())
                .build()
        MoshiConverterFactory.create(moshi)
    }
}