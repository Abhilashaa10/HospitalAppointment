# FROM openjdk:17

# WORKDIR /app

# COPY target/*.jar app.jar

# EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "app.jar"]


# Dockerfile (at root)
FROM eclipse-temurin:17
WORKDIR /app

# Copy only backend jar
COPY backend/target/*.jar app.jar

# Run app
ENTRYPOINT ["java","-jar","/app.jar"]