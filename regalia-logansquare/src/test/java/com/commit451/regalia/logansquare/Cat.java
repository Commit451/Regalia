package com.commit451.regalia.logansquare;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * A cat!
 */
@JsonObject
public class Cat extends RealmObject {

    @PrimaryKey
    @JsonField(name = "name")
    String name;
    @JsonField(name = "friends", typeConverter = CatListConverter.class)
    RealmList<Cat> friends;
}
