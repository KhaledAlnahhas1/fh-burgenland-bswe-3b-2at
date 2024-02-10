FROM ubuntu:20.04
WORKDIR /app

COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle

# Download and cache the Gradle wrapper
RUN ./gradlew

# Copy the entire project
COPY . .

# Build the application
RUN ./gradlew build

# Expose the port the app will run on
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "build/libs/examination-0.0.1-SNAPSHOT.jar"]
