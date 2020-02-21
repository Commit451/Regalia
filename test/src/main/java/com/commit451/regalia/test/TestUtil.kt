package com.commit451.regalia.test

import java.io.IOException

object TestUtil {
    @JvmStatic
    @get:Throws(IOException::class)
    val catWithListOfFriendsJson: String
        get() = getFileText("cat_and_friends.json")

    @JvmStatic
    @Throws(IOException::class)
    fun getFileText(filename: String): String {
        // for some reason can't load from resources, so I had to improvise
        return "{\n" +
                "  \"name\": \"Lovelace\",\n" +
                "  \"friends\": [\n" +
                "    {\n" +
                "      \"name\": \"Sputnik\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"Who are you\"\n" +
                "    }\n" +
                "  ]\n" +
                "}"
    }
}