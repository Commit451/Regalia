package com.commit451.regalia.gson;

import java.lang.reflect.Type;

public class CatListConverter extends RealmListGsonConverter<Cat> {

    @Override
    protected Type getObjectType() {
        return Cat.class;
    }
}
