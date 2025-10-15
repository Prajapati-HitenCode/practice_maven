# Use a base image with Java runtime
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built jar file
COPY target/my-app-1.0-SNAPSHOT.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
