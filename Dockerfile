FROM openjdk:8
EXPOSE 8081
RUN mkdir -p /app/
ADD build/libs/control-service-0.0.1-SNAPSHOT.jar /app/control-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/control-service-0.0.1-SNAPSHOT.jar"]