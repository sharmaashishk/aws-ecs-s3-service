FROM openjdk:8
EXPOSE 8095
ADD target/spring-boot-aws-s3-0.0.1-SNAPSHOT.jar spring-boot-aws-s3-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-boot-aws-s3-0.0.1-SNAPSHOT.jar"]