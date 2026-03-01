package com.example.service;


import com.application.utility.PaymentSubtypeUtility;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class Service1 {

    private final PaymentSubtypeUtility utility;

    private static final Logger logger = LoggerFactory.getLogger(Service1.class);

    public void testUtility() {
           utility.doSomething();
    }

}
