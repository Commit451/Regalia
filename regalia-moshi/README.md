
# Regalia for Moshi

`RealmListJsonAdapterFactory` allows Moshi to properly convert `RealmList`s to and from JSON.

Simply install it on your Moshi:
```kotlin
Moshi moshi = new Moshi.Builder()
    .add(RealmListJsonAdapterFactory())
    .add(KotlinJsonAdapterFactory())
    .build();
```

If you're using Retrofit

```kotlin
retrofit.addConverterFactory(RegaliaMoshi.moshiConverterFactory)
```

And that should be all you need.
