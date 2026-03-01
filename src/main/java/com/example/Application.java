package com.example;

import com.example.service.Service1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 * Entry point for the Retail Order Service application.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private  Service1 service1;

    public static void main(String[] args) {
        logger.info("Starting Retail Order Service Application...");
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
         service1.testUtility();
    }
}
