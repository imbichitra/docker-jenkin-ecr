FROM openjdk:8
ADD target/bichi-image.jar bichi-image.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","bichi-image.jar"]