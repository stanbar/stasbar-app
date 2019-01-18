FROM gradle:4.10.1

USER root

WORKDIR /app

COPY . .

RUN chown -R gradle .

USER gradle

RUN gradle -Dorg.gradle.project.INCLUDE_ANDROID=false :backend:shadowJar

CMD ["java", "-server", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-XX:InitialRAMFraction=2", "-XX:MinRAMFraction=2", "-XX:MaxRAMFraction=2", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=100", "-XX:+UseStringDeduplication", "-jar", "./backend/build/libs/backend.jar"]
