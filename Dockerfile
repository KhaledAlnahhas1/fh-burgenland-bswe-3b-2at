FROM ubuntu:20.04
WORKDIR /app
# Copy the entire project
COPY build/libs/*.jar /app/app.jar

# Expose the port the app will run on
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "build/libs/examination-0.0.1-SNAPSHOT.jar"]
