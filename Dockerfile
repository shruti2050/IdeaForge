# Step 1: Build the application
FROM eclipse-temurin:17-jdk-jammy AS build
COPY . .
RUN chmod +x gradlew
RUN ./gradlew bootJar

# Step 2: Run the application
FROM eclipse-temurin:17-jre-jammy
COPY --from=build /build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]