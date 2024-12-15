FROM gradle:8.11-jdk17 AS builder

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN gradle build -x test

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/rating-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082


ENTRYPOINT ["java", "-jar", "app.jar"]