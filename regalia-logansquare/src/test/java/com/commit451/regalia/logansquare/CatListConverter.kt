package com.commit451.regalia.logansquare

class CatListConverter : RealmListLoganSquareConverter<Cat>() {
    override val objectClass: Class<Cat>?
        get() = Cat::class.java
}