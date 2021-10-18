FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-alpine-slim

# create user group and user without root permissions
RUN addgroup -S nonRootUsers && adduser -S nonRootUser -G nonRootUsers
USER nonRootUser:nonRootUsers

# just copy full jar file to container and run it, build first: gradlew build
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} facilitator.jar
ENTRYPOINT ["java","-jar","/facilitator.jar"]

# faster and individual layers, unzip jar first: mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/facilitator-1.0.0.jar)
# ARG DEPENDENCY=target/dependency
# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app
# ENTRYPOINT ["java","-cp","app:app/lib/*","ch.zuehlke.lambda.facilitator.FacilitatorApplication"]