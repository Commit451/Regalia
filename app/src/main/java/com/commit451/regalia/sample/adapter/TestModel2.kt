package com.commit451.regalia.sample.adapter


import io.realm.RealmList
import io.realm.RealmObject


open class TestModel2(
        var status: String= "",
        var data: RealmList<Data> = RealmList()
) : RealmObject()