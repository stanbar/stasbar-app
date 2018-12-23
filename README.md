# stasbar pet-project

All pieces of the application are implemented in *Kotlin*.
Backend, Frontend, Android Application are all writen in Kotlin and sharing common **kotlin-multiplatform** module.

### Backend Server
- Google App Engine
- Ktor

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




