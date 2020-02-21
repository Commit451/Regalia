package com.commit451.regalia.logansquare

import com.bluelinelabs.logansquare.annotation.JsonField
import com.bluelinelabs.logansquare.annotation.JsonObject
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * A cat!
 */
@JsonObject
open class Cat : RealmObject() {
    @PrimaryKey
    @JsonField(name = ["name"])
    var name: String? = null
    @JvmField
    @JsonField(name = ["friends"], typeConverter = CatListConverter::class)
    var friends: RealmList<Cat>? = null
}