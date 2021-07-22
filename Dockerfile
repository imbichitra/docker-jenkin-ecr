FROM openjdk:8
ADD target/docker-jenkins-ecr.jar docker-jenkins-ecr
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-jenkins-ecr.jar"]