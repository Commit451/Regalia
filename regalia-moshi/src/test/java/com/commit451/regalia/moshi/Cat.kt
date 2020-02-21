package com.commit451.regalia.moshi

import io.realm.RealmList
import io.realm.RealmObject

open class Cat : RealmObject() {
    var name: String? = null
    var friends: RealmList<Cat>? = null
}