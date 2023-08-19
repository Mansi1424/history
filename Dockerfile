FROM openjdk:17-alpine
ENV PORT 8082
EXPOSE 8082
ADD target/springboot-docker-compose.jar springboot-docker-compose.jar
ENTRYPOINT ["java","-jar","springboot-docker-compose.jar"]