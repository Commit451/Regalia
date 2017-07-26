package com.commit451.regalia.gson;

import com.commit451.regalia.test.TestUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;

import io.realm.RealmList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GsonRealmListTest {
    @Test
    public void parse() throws Exception {
        String json = TestUtil.getCatWithListOfFriendsJson();
        Type catRealmListType = new TypeToken<RealmList<Cat>>(){}.getType();
        CatListConverter catRealmListConverter = new CatListConverter();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(catRealmListType, catRealmListConverter)
                .create();
        Cat cat = gson.fromJson(json, Cat.class);
        Assert.assertNotNull(cat);
        Assert.assertNotNull(cat.friends);
    }
}