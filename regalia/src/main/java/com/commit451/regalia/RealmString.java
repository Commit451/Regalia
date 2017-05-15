package com.commit451.regalia;

import io.realm.RealmObject;

/**
 * A wrapper for holding Strings in RealmList.
 */
public class RealmString extends RealmObject {

    private String string;

    public RealmString() {
    }

    public RealmString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
