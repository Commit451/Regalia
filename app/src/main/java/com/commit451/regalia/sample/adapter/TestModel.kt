package com.commit451.regalia.sample.adapter


import android.os.Parcelable
import io.realm.RealmObject
import kotlinx.android.parcel.Parcelize

@Parcelize
open class TestModel(
    var body: String = "",
    var id: Int = 0,
    var title: String = "",
    var userId: Int = 0
) : RealmObject(), Parcelable{
    override fun toString(): String {
        return """
            body = $body,
            id = $id,
            title = $title,
            userID = $userId
        """.trimIndent()
    }
}