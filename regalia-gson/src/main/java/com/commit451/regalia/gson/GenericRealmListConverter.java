package com.commit451.regalia.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Allows serialization and deserialization of RealmLists. Adjust to whatever your list data type is.
 * Make sure you add it to your Gson instance.
 *
 * @see <a href="http://stackoverflow.com/a/30014833/895797">http://stackoverflow.com/a/30014833/895797</a>
 */
abstract class GenericRealmListConverter<T extends RealmObject> implements JsonSerializer<RealmList<T>>,
        JsonDeserializer<RealmList<T>> {

    /**
     * Return the type of your object, which can probably just be YourClass.class
     * @return the type
     */
    protected abstract Type getType();

    @Override
    public JsonElement serialize(RealmList<T> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonArray ja = new JsonArray();
        for (T item : src) {
            ja.add(context.serialize(item));
        }
        return ja;
    }

    @Override
    public RealmList<T> deserialize(JsonElement json, Type typeOfT,
                                            JsonDeserializationContext context) throws JsonParseException {
        RealmList<T> items = new RealmList<>();
        JsonArray ja = json.getAsJsonArray();
        for (JsonElement je : ja) {
            items.add((T) context.deserialize(je, getType()));
        }
        return items;
    }
}
