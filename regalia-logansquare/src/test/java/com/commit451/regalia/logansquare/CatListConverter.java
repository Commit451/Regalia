package com.commit451.regalia.logansquare;

public class CatListConverter extends RealmListLoganSquareConverter<Cat> {

    @Override
    public Class<Cat> getObjectClass() {
        return Cat.class;
    }
}
