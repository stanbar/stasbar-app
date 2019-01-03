# stasbar pet-project

All pieces of the application are implemented in *Kotlin*.
Backend, Frontend, Android Application are all writen in Kotlin and sharing common **kotlin-multiplatform** module.

### Backend Server
- PaaS Google App Engine
- HTTP Server Ktor
- HTTP Client Retrofit
- Books repository from Goodreads API using JAXB and Jsoup
- Database SQLite
- ORM/DAO Kotlin Exposed


### Frontend WebApp
- React

### Android Application
- Instant App


## How to build and run

### Building the code

 * Make sure you have the Android SDK installed
 * Open the project in IntelliJ IDEA
 * Create a file `local.properties` in the root directory of the project, pointing to your Android SDK installation. On Mac OS, the contents should be `sdk.dir=/Users/<your username>/Library/Android/sdk`. On other OSes, please adjust accordingly.
 * Run `./gradlew build`

### Running the backend

 * Run `./gradlew backend:run` from the command line or from Gradle tool window
 * The backend will start serving on localhost:8888

### Deploying the backend

 * Run `./gradlew backend:appengineDeploy` from the command line or from Gradle tool window
 * The backend will be published on Google App Engine run `gcloud app browse` to open it in browser

### Running the Android app

 * Create a run configuration of type "Android App"
 * Select module "app" in the run configuration settings
 * Run the configuration
 * Select the emulator or connected device, as normal

### Licences
```
Copyright 2019 Stanislaw stasbar Baranski

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


         __             __
   _____/ /_____ ______/ /_  ____ ______
  / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
 (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
/____/\__/\__,_/____/_.___/\__,_/_/
           stasbar@stasbar.com
```


