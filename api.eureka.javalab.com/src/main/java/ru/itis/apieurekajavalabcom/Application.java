package ru.itis.apieurekajavalabcom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_PURPLE = "\u001B[35m";
        SpringApplication.run(Application.class, args);
        System.out.println(ANSI_PURPLE + "***************************");
        System.out.println(ANSI_RED + "APPLICATION STARTED");
        System.out.println(ANSI_PURPLE + "***************************");
    }
}
