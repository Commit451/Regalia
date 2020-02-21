package com.commit451.regalia.gson

import java.lang.reflect.Type

open class CatListConverter : RealmListGsonConverter<Cat?>() {
    override val objectType: Type
        get() = Cat::class.java
}