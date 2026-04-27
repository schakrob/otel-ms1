package com.example.demo;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Observed(name = "demo.test", contextualName = "testMethod")
    public void test() throws InterruptedException {
        System.out.println("Demo Service");
        Thread.sleep(500);
    }
}


