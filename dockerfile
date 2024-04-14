# Use a base image with Maven and OpenJDK installed
FROM maven:3.8.3-openjdk-17 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file into the container at the specified working directory
COPY pom.xml .

# Download Maven dependencies specified in pom.xml (to cache dependencies)
RUN mvn dependency:go-offline -B

# Copy the entire project to the working directory
COPY . .

# Package the Spring Boot application into a JAR file
RUN mvn package -DskipTests

# Use a base image with OpenJDK installed
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the builder stage into the container
COPY --from=builder /app/target/electradrive-backend.jar /app/app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Define command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
