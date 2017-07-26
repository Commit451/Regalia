# Regalia
[Realm Java](https://realm.io/docs/java/latest/) extensions and helpers.

[![Build Status](https://travis-ci.org/Commit451/Regalia.svg?branch=master)](https://travis-ci.org/Commit451/Regalia) [![](https://jitpack.io/v/Commit451/Regalia.svg)](https://jitpack.io/#Commit451/Regalia)

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
    compile "com.github.Commit451.Regalia:regalia:latest.version.here"
    //for gson support
    compile "com.github.Commit451.Regalia:regalia-gson:latest.version.here"
    //for LoganSquare support
    compile "com.github.Commit451.Regalia:regalia-logansquare:latest.version.here"
    //for Moshi support
    compile "com.github.Commit451.Regalia:regalia-moshi:latest.version.here"
    //for Parceler support
    compile "com.github.Commit451.Regalia:regalia-parceler:latest.version.here"
}
```

## Usage
Regalia itself provides usage just with Realm itself, mostly through the `Regalia` class.

Other usage is defined in the individual modules README's

- [regalia-gson](regalia-gson/)
- [regalia-logansquare](regalia-logansquare/)
- [regalia-moshi](regalia-moshi/)
- [regalia-parceler](regalia-parceler/)

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
