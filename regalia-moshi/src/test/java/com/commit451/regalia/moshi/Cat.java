package com.commit451.regalia.moshi;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Cat extends RealmObject {

    String name;
    RealmList<Cat> friends;

    public List<Cat> getFriends() {
        return friends;
    }
}
