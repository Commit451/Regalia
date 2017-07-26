package com.commit451.regalia.moshi;

import android.support.annotation.NonNull;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

public final class RealmListMoshiJsonAdapterFactory implements JsonAdapter.Factory {

    @Override
    public JsonAdapter<?> create(@NonNull Type type, @NonNull Set<? extends Annotation> annotations, @NonNull Moshi moshi) {
        if (annotations.size() > 0) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof RealmListMoshi) {

                    Class<?> rawType = Types.getRawType(type);
                    Type collectionElementType = Types.collectionElementType(type, rawType);
                    Type listMyData = Types.newParameterizedType(List.class, collectionElementType);
                    final JsonAdapter<Object> delegate = moshi.nextAdapter(this, listMyData, Types.nextAnnotations(annotations, RealmListMoshi.class));
                    return new JsonAdapter<Object>() {
                        @Override
                        public Object fromJson(@NonNull JsonReader reader) throws IOException {
                            JsonReader.Token peek = reader.peek();
                            if (peek != JsonReader.Token.BEGIN_ARRAY) {
                                reader.skipValue();
                                return null;
                            }
                            return delegate.fromJson(reader);
                        }

                        @Override
                        public void toJson(@NonNull JsonWriter writer, Object value) throws IOException {
                            delegate.toJson(writer, value);
                        }
                    };
                }
            }
        }
        return null;
    }
}
