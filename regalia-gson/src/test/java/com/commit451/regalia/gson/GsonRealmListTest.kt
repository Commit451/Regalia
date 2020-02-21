package com.commit451.regalia.gson

import com.commit451.regalia.test.TestUtil.catWithListOfFriendsJson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import io.realm.RealmList
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class GsonRealmListTest {
    @Test
    @Throws(Exception::class)
    fun parse() {
        val json = catWithListOfFriendsJson
        val catRealmListType = object : TypeToken<RealmList<Cat?>?>() {}.type
        val catRealmListConverter = CatListConverter()
        val gson = GsonBuilder()
                .registerTypeAdapter(catRealmListType, catRealmListConverter)
                .create()
        val cat = gson.fromJson(json, Cat::class.java)
        Assert.assertNotNull(cat)
        Assert.assertNotNull(cat.friends)
    }
}