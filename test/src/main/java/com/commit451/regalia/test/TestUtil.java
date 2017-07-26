package com.commit451.regalia.test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

public class TestUtil {

    public static String getCatWithListOfFriendsJson() throws IOException {
        return getFileText("cat-with-list-of-friends.json");
    }

    public static String getFileText(String filename) throws IOException {
        URL url = Resources.getResource(filename);
        return Resources.toString(url, Charsets.UTF_8);
    }
}
