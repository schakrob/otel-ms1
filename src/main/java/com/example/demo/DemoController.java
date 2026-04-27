package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final DemoService demoService;
    public DemoController(DemoService demoService) { this.demoService = demoService; }

    @GetMapping("/demo")
    public String run() throws InterruptedException {
        demoService.test();
        return "done";
    }
}
