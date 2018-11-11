FROM openjdk:11-jre
COPY target/exampleservice-a-0.0.1-SNAPSHOT.jar /opt
CMD java -jar /opt/exampleservice-a-0.0.1-SNAPSHOT.jar