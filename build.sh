#!/usr/bin/env bash

./gradlew -Dorg.gradle.project.INCLUDE_ANDROID=false :backend:shadowJar
