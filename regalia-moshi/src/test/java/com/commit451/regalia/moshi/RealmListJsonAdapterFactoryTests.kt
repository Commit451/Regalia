package com.commit451.regalia.moshi

import com.commit451.regalia.test.TestUtil.getFileText
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.Assert
import org.junit.Test

class RealmListJsonAdapterFactoryTests {
    @Test
    @Throws(Exception::class)
    fun parseList() {
        val json = getFileText("cat_and_friends.json")
        val jsonAdapter = moshi.adapter(Cat::class.java)
        val cat = jsonAdapter.fromJson(json)
        cat?.apply {
            Assert.assertNotNull(this)
            Assert.assertNotNull(name)
            Assert.assertNotNull(friends)
        }

    }

    companion object {
        private val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(RealmListJsonAdapterFactory())
                .build()
    }
}