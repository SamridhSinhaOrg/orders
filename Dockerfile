FROM gradle:7.6.1-jdk17 AS GRADLE_BUILD
WORKDIR /usr/src/app
COPY . /usr/src/app

# package our application code
# RUN gradle --build-cache assemble
RUN gradle --build-cache clean build -x test

FROM gradle:7.6.1-jdk17 as runner

# Install Docker inside the runner container
RUN apt-get update && apt-get install -y docker.io

COPY --from=GRADLE_BUILD /usr/src/app/build/libs/Order-0.0.1-SNAPSHOT.jar /app.jar
# CMD ["./gradlew","test","--debug"]

CMD ["java","-jar","/app.jar"]