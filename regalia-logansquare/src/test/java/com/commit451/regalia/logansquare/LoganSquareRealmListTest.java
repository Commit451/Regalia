package com.commit451.regalia.logansquare;

import com.bluelinelabs.logansquare.LoganSquare;
import com.commit451.regalia.test.TestUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoganSquareRealmListTest {
    @Test
    public void parse() throws Exception {
        String json = TestUtil.getCatWithListOfFriendsJson();
        Cat cat = LoganSquare.parse(json, Cat.class);
        Assert.assertNotNull(cat);
        Assert.assertNotNull(cat.friends);
    }
}