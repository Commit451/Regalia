package com.commit451.regalia.gson;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Cat extends RealmObject {

    @PrimaryKey
    String name;
}
