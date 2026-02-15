# Build stage - using Gradle 8.14+
FROM gradle:8.14-jdk21-alpine AS builder

WORKDIR /app

# Copy Gradle configuration
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Cache dependencies
RUN gradle dependencies --no-daemon || true

# Copy source and build
COPY src ./src
RUN gradle clean build -x test --no-daemon

# Runtime stage
FROM eclipse-temurin:21-jre-alpine AS runner

WORKDIR /app

# Add non-root user for security
RUN addgroup -S spring && adduser -S spring -G spring

# Copy jar
COPY --from=builder /app/build/libs/*.jar ./app.jar

# Change ownership
RUN chown spring:spring app.jar

USER spring:spring

EXPOSE 7070

ENTRYPOINT ["java", "-jar", "app.jar"]