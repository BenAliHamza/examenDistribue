# discovery-server/Dockerfile
FROM eclipse-temurin:17-jdk-alpine

# → installe curl pour le health-check
RUN apk add --no-cache curl

WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

EXPOSE 8761
CMD ["java","-jar","target/discovery-server-0.0.1-SNAPSHOT.jar"]
