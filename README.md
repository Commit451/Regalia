# Regalia
[Realm Java](https://realm.io/docs/java/latest/) extensions and helpers for working with Realm using Kotlin.

[![](https://jitpack.io/v/CraZyLegenD/Regalia.svg)](https://jitpack.io/#CraZyLegenD/Regalia)


## Gradle Dependency
Add the jitpack url to the project:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
then, in your app `build.gradle`
```groovy
dependencies {
    implementation 'com.github.CraZyLegenD.Regalia:latest-version'
    //for gson support
    implementation 'com.github.CraZyLegenD.Regalia:regalia-gson:latest-version'
    //for LoganSquare support
    implementation 'com.github.CraZyLegenD.Regalia:regalia-logansquare:latest-version'
    //for Moshi support
    implementation 'com.github.CraZyLegenD.Regalia:regalia-moshi:latest-version'
    //for Parceler support
    implementation 'com.github.CraZyLegenD.Regalia:regalia-parceler:latest-version'
}
```

## Usage
Regalia itself provides usage just with Realm itself, mostly through the `Regalia` class.

Other usage is defined in the individual modules README's

- [regalia-gson](regalia-gson/)
- [regalia-logansquare](regalia-logansquare/)
- [regalia-moshi](regalia-moshi/)
- [regalia-parceler](regalia-parceler/)

## Support
Regalia supports Realm's latest version 7.0.0

Based on [Regalia Java](https://github.com/Commit451/Regalia)

License
--------

    Copyright 2017 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
