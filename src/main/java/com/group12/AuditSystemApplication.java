package com.group12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// this scans all our teams packages, looking for all the classes that are annotated

@SpringBootApplication
public class AuditSystemApplication {

    public static void main(String args[]){
        SpringApplication.run(AuditSystemApplication.class, args);

    }

}
