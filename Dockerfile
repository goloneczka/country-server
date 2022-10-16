FROM openjdk:18-alpine
EXPOSE 8080
ADD /app/target/app-0.0.1-SNAPSHOT.jar country-server.jar
ENTRYPOINT ["java", "-jar", "country-server.jar"]

# USAGE
# docker build -t server -f containerization/backend/Dockerfile .
# docker run -p 8080:8080 server
# Add add start if needed DOCKER_BUILDKIT=0