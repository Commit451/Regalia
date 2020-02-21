package com.commit451.regalia.logansquare

import com.bluelinelabs.logansquare.LoganSquare
import com.commit451.regalia.test.TestUtil.catWithListOfFriendsJson
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class LoganSquareRealmListTest {
    @Test
    @Throws(Exception::class)
    fun parse() {
        val json = catWithListOfFriendsJson
        val cat = LoganSquare.parse(json, Cat::class.java)
        Assert.assertNotNull(cat)
        Assert.assertNotNull(cat.friends)
    }
}