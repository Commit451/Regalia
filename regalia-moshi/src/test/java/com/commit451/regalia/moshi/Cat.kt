package com.commit451.regalia.moshi

import io.realm.RealmList
import io.realm.RealmObject

open class Cat : RealmObject() {
    @JvmField
    var name: String? = null
    @JvmField
    var friends: RealmList<Cat>? = null
}