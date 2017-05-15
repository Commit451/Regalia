package com.commit451.regalia.logansquare;

import com.bluelinelabs.logansquare.typeconverters.StringBasedTypeConverter;
import com.commit451.regalia.RealmString;

/**
 * A simple converter for RealmString wrapper.
 */
public class RealmStringLoganSquareConverter extends StringBasedTypeConverter<RealmString> {

    @Override
    public RealmString getFromString(String string) {
        return new RealmString(string);
    }

    @Override
    public String convertToString(RealmString realmString) {
        return realmString.getString();
    }
}
