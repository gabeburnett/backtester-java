FROM maven:3.8.5-eclipse-temurin-18-alpine
COPY src /home/app/src
COPY pom.xml /home/app
WORKDIR /home/app
RUN mvn clean compile assembly:single
ENTRYPOINT ["java", "-jar", "./target/algorithm.jar"]