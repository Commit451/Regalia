package com.commit451.regalia.gson

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Cat : RealmObject() {
    @PrimaryKey
    var name: String? = null
    var friends: RealmList<Cat>? = null
}