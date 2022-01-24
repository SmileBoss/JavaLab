FROM adoptopenjdk/openjdk11:alpine-jre

MAINTAINER Nikita Shirmanov <nfska3@gmail.com>

ARG JAR_FILE=build/libs/api-eureka-javalab-com-0.1.jar
COPY ${JAR_FILE} api-eureka-javalab-com-0.1.jar


EXPOSE 8761

ENTRYPOINT ["java","-jar","/api-eureka-javalab-com-0.1.jar"]
