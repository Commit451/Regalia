# Regalia for Moshi

`RealmListJsonAdapterFactory` allows Moshi to properly convert `RealmList`s to and from JSON.

Simply install it on your Moshi:
```java
Moshi moshi = new Moshi.Builder()
    .add(new RealmListJsonAdapterFactory())
    .build();
```
And that should be all you need.
