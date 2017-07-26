package com.commit451.regalia.moshi;

import com.commit451.regalia.test.TestUtil;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.junit.Assert;
import org.junit.Test;

public class RealmListJsonAdapterFactoryTests {

    private static Moshi moshi = new Moshi.Builder()
            .add(new RealmListJsonAdapterFactory())
            .build();

    @Test
    public void parseList() throws Exception {
        String json = TestUtil.getFileText("cat-with-list-of-friends.json");
        JsonAdapter<Cat> jsonAdapter = moshi.adapter(Cat.class);
        Cat cat = jsonAdapter.fromJson(json);
        Assert.assertNotNull(cat);
        Assert.assertNotNull(cat.name);
        Assert.assertNotNull(cat.friends);
    }
}