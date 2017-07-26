package com.commit451.regalia.moshi;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

class Util {

    public static String getFileText(String filename) throws IOException {
        URL url = Resources.getResource(filename);
        return Resources.toString(url, Charsets.UTF_8);
    }
}
