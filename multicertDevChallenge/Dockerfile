FROM openjdk:16-jdk-alpine
ARG JAR_FILE=target/developmentChallenge-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY create.sql create.sql
ENTRYPOINT ["java","-jar","/app.jar"]