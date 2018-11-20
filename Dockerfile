#FROM openjdk:11-jre
#alpine slim/headless
FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.1.13-slim
COPY target/exampleservice-a-0.0.1-SNAPSHOT.jar /opt
CMD java -jar /opt/exampleservice-a-0.0.1-SNAPSHOT.jar