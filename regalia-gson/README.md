# Regalia for Gson

`RealmListGsonConverter` allows Gson to properly convert `RealmList`s to and from JSON.

Simply create a custom class extending `RealmListGsonConverter`:
```java
public class CatRealmListConverter extends RealmListGsonConverter<Cat> {

    @Override
    protected Type getObjectType() {
        return Cat.class;
    }
}
```

And then properly configure your Gson:
```java
Type catRealmListType = new TypeToken<RealmList<Cat>>(){}.getType();
CatRealmListConverter catRealmListConverter = new CatRealmListConverter();
Gson gson = new GsonBuilder()
        .registerTypeAdapter(catRealmListType, catRealmListConverter)
        .create();
//make sure this is done for all gson access throughout the app
```
Make sure to do this for each of your possible `RealmList` types.


If you're using Retrofit
```
addConverterFactory(realmGsonConverterFactory(My::class.java, You::class.java))
```

You can check out few extensions that are available

- [Extensions](src/main/java/com/commit451/regalia/gson/Extensions.kt)
