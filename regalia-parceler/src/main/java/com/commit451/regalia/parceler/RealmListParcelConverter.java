package com.commit451.regalia.parceler;

import android.os.Parcel;
import android.os.Parcelable;

import org.parceler.Parcels;
import org.parceler.TypeRangeParcelConverter;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Parceler doesn’t know how to handle a  RealmList in the default setup. You have to provide a
 * custom ParcelConverter to make it work. I wrote a RealmListParcelConverter which works with any
 * RealmList, as long as the items are also annotated with @Parcel, i.e. they also use Parceler.
 *
 * @see <a href="https://nullpointer.wtf/android/using-retrofit-realm-parceler/">https://nullpointer.wtf/android/using-retrofit-realm-parceler/</a>
 */
public class RealmListParcelConverter implements TypeRangeParcelConverter<RealmList<? extends RealmObject>,
        RealmList<? extends RealmObject>> {

    private static final int NULL = -1;

    @Override
    public void toParcel(RealmList<? extends RealmObject> input, Parcel parcel) {
        parcel.writeInt(input == null ? NULL : input.size());
        if (input != null) {
            for (RealmObject item : input) {
                parcel.writeParcelable(Parcels.wrap(item), 0);
            }
        }
    }

    @Override
    public RealmList fromParcel(Parcel parcel) {
        int size = parcel.readInt();
        RealmList list = new RealmList();
        for (int i = 0; i < size; i++) {
            Parcelable parcelable = parcel.readParcelable(getClass().getClassLoader());
            list.add((RealmObject) Parcels.unwrap(parcelable));
        }
        return list;
    }
}
