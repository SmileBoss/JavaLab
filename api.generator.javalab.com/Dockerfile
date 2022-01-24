FROM adoptopenjdk/openjdk11:alpine-jre

MAINTAINER Nikita Shirmanov <nfska3@gmail.com>

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} api-generator-javalab-com-0.1.jar

COPY templates /templates

EXPOSE 9080

ENTRYPOINT ["java","-jar","/api-generator-javalab-com-0.1.jar"]
