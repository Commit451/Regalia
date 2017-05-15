# Regalia for LoganSquare

`RealmListLoganSquareConverter` allows LoganSquare to properly convert `RealmList`s to and from JSON.

Simply create a custom class extending `RealmListLoganSquareConverter` :
```java
public class CatRealmListConverter extends RealmListLoganSquareConverter<Cat> {

    @Override
    protected Class<Cat> getObjectClass() {
        return Cat.class;
    }
}
```

And then annotate the usages:
```java
@JsonField(name = "cats", typeConverter = CatRealmListConverter.class)
RealmList<Cat> cats;
```

Then, you can use LoganSquare as normal.
