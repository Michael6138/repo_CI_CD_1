FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
COPY target/deployment-test-exec.jar deployment-test-docker-exec.jar
ENTRYPOINT ["java","-jar","/deployment-test-docker-exec.jar"]


