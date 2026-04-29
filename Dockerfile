# Stage 1: Build the jar
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app
COPY backend/pom.xml .
COPY backend/src ./src

RUN mvn clean package -DskipTests

# Stage 2: Run the jar
FROM eclipse-temurin:17

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]