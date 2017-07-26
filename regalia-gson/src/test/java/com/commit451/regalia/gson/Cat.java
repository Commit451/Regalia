package com.commit451.regalia.gson;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Cat extends RealmObject {

    @PrimaryKey
    String name;
    RealmList<Cat> friends;
}
