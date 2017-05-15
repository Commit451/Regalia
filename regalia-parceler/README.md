# Regalia for Parceler

`RealmListParcelConverter` allows Parceler to properly convert `RealmList`s to and from Parcels

Simply annotate classes that contain `RealmList` with the class:
```java
@Parcel
public class Cat extends RealmObject {

    String name;
    int age;
    @ParcelPropertyConverter(RealmListParcelConverter.class)
    RealmList<Owner> owners;
    @ParcelPropertyConverter(RealmListParcelConverter.class)
    RealmList<RealmString> attributes;
}
```

And then use Parceler the normal way.