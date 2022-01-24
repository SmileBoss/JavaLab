FROM adoptopenjdk/openjdk11:alpine-jre

MAINTAINER Nikita Shirmanov <nfska3@gmail.com>

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} api-gateway-javalab-com-0.1.jar


EXPOSE 8072

ENTRYPOINT ["java","-jar","/api-gateway-javalab-com-0.1.jar"]
