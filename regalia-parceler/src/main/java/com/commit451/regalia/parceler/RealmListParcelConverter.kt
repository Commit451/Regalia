package com.commit451.regalia.parceler

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmList
import io.realm.RealmObject
import org.parceler.Parcels
import org.parceler.TypeRangeParcelConverter

/**
 * RealmListParcelConverter, works with any RealmList, as long as the items are also annotated with
 * `@Parcel`, i.e. they also use Parceler.
 *
 * @see [https://nullpointer.wtf/android/using-retrofit-realm-parceler/](https://nullpointer.wtf/android/using-retrofit-realm-parceler/)
 */
class RealmListParcelConverter : TypeRangeParcelConverter<RealmList<out RealmObject>?, RealmList<out RealmObject?>?> {
    override fun toParcel(input: RealmList<out RealmObject>?, parcel: Parcel) {
        parcel.writeInt(input?.size ?: NULL)
        input?.forEach {
            parcel.writeParcelable(Parcels.wrap(it), 0)
        }
    }

    override fun fromParcel(parcel: Parcel): RealmList<out RealmObject?>? {
        val size = parcel.readInt()
        if (size != -1) {
            val list = RealmList<RealmObject?>()
            for (i in 0 until size) {
                val parcelable = parcel.readParcelable<Parcelable>(javaClass.classLoader)
                list.add(Parcels.unwrap<Any>(parcelable) as RealmObject)
            }
            return list
        }
        return null
    }

    companion object {
        private const val NULL = -1
    }
}