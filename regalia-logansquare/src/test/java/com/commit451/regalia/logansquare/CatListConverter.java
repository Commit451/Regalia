package com.commit451.regalia.logansquare;

public class CatListConverter extends RealmListLoganSquareConverter<Cat> {

    @Override
    protected Class<Cat> getObjectClass() {
        return Cat.class;
    }
}
