#!/bin/bash

./gradlew assembleRelease && \
adb install -r -t -p com.stasbar.app.android android/app/build/outputs/apk/release/app-release.apk && \
adb shell am start -n com.stasbar.app.android/.aboutme.AboutMeActivity
