#parent docker image
FROM openjdk:18
LABEL maintaner="AT. Szilard"
ADD target/hospital-api-0.0.1-SNAPSHOT.jar springboot-docker-hospital-api.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-hospital-api.jar"]