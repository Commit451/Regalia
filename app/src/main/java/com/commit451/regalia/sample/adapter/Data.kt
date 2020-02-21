package com.commit451.regalia.sample.adapter

import android.os.Parcelable
import io.realm.RealmObject
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Data(
    var employee_age: String = "",
    var employee_name: String = "",
    var employee_salary: String = "",
    var id: String = "",
    var profile_image: String = ""
): RealmObject(), Parcelable{

    override fun toString(): String {
        return """
            name $employee_name,
            salary $employee_salary
        """.trimIndent()
    }
}