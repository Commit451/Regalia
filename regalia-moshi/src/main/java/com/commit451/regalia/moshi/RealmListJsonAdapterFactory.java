package com.commit451.regalia.moshi;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Enables Moshi to parse and serialize {@link io.realm.RealmList}s. Install via your {@link com.squareup.moshi.Moshi.Builder}
 */
public final class RealmListJsonAdapterFactory implements JsonAdapter.Factory {

    @Override
    @Nullable
    public JsonAdapter<?> create(@NonNull Type type, @NonNull Set<? extends Annotation> annotations, @NonNull Moshi moshi) {
        Class<?> rawType = Types.getRawType(type);
        if (!annotations.isEmpty()) return null;
        if (rawType == RealmList.class) {
            return newRealmListAdapter(type, moshi).nullSafe();
        }
        return null;
    }

    private static <T extends RealmObject> JsonAdapter<RealmList<T>> newRealmListAdapter(Type type, Moshi moshi) {
        Type elementType = Types.collectionElementType(type, RealmList.class);
        JsonAdapter<T> elementAdapter = moshi.adapter(elementType);
        return new RealmListAdapter<>(elementAdapter);
    }
}
