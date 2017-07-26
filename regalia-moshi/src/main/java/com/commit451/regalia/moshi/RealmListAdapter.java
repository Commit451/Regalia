package com.commit451.regalia.moshi;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;

import io.realm.RealmList;
import io.realm.RealmObject;

public class RealmListAdapter<T extends RealmObject> extends JsonAdapter<RealmList<T>> {

    private JsonAdapter<T> elementAdapter;

    public RealmListAdapter(JsonAdapter<T> elementAdapter) {
        this.elementAdapter = elementAdapter;
    }

    @Override
    public void toJson(@NonNull JsonWriter writer, RealmList<T> value) throws IOException {
        writer.beginArray();
        for (T element : value) {
            elementAdapter.toJson(writer, element);
        }
        writer.endArray();
    }

    @Nullable
    @Override
    public RealmList<T> fromJson(@NonNull JsonReader reader) throws IOException {
        RealmList<T> result = new RealmList<>();
        reader.beginArray();
        while(reader.hasNext()) {
            result.add(elementAdapter.fromJson(reader));
        }
        reader.endArray();
        return result;
    }
}
