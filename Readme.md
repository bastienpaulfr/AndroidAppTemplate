Android Template Project
========================

This template provides a starting point for Android project.

 ## Checklist

 - [ ] Clone this repository into a folder of your project's name `git clone git@github.com:bastienpaulfr/AndroidAppTemplate.git MY_PROJECT`. Or if you're copying the folder, don't forget hidden files!
 - [ ] Update this template with new features if suitable
 - [ ] Commit new features to template repo
 - [ ] Reinitialize git
     - [ ] Delete the `.git` folder
     - [ ] Start a git repo with `git init`
     - [ ] Make initial git commit with all files
 - [ ] According to project, keep only app, lib or both modules
 - [ ] Change sources folder
     - [ ] Replace `template` by your own package name in main and tests sources
     - [ ] Change Application ID in `manifest.xml`
     - [ ] Change all path pointing to template package in `manifest.xml`
     - [ ] Change App's name
     - [ ] Update `settings.gradle` to point to the modules you added
     - [ ] Update `dependencies.gradle` and respective `build.gradle` files to make sure dependencies are hooked up and compiling properly
     - [ ] Update all fabric api keys if not public project
 - [ ] Update this `README.md` file to reflect your project.
     - [ ] Update the Travis Build Status badge to reflect your project
     - [ ] Delete everything above including these checkboxes


# Project Name

Replace this text with a synopsis of the library.

## Motivation

Explain why this library exists and what problems it solves.

## Requirements

Add a link to requirements file or system

## Download

Include instructions on how to integrate the library into your projects. For instance install in your build.gradle:

```groovy
dependencies {

}
```

## Usage

Provide instructions on how to use and integrate the library into a project.

If there's some special pieces for testing (ie Mocks) explain those here as well.

### Logs

This library uses [SLF4J](http://www.slf4j.org/) for logging. Please use android binding to
log into logcat. More info on [Android binding](http://www.slf4j.org/android/)

```groovy
dependencies {
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-android
    implementation 'org.slf4j:slf4j-android:1.7.30'
}
```

You can also bind SLF4J to timber. In this case please use this dependency

```groovy
dependencies {
    implementation 'com.arcao:slf4j-timber:3.1'
}
```

To activate verbose logging, please add this into your code :

```java
LogDefines.setVerbose(true);
```

Sometimes, it can have log for profiling, in this case, to activate them please add
this in code :

```java
LogDefines.setProfile(true);
```

One `TAG` is used for all logging from lib. It would be easy to filter on this tag if you
want to disable all logging from lib. Filtering can be done with `Timber` and a `Tree`
from [Treessence](https://github.com/bastienpaulfr/Treessence)


```groovy
dependencies {
    implementation 'com.github.bastienpaulfr:Treessence:1.0.5'
}
```

## License

    Copyright (C) 2020 Bastien PAUL

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

