FROM openjdk:17-alpine
ADD target/springboot-mongo-docker.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]