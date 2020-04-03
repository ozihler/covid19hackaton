FROM openjdk:11-jre
COPY backend/build/libs/backend-0.1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]