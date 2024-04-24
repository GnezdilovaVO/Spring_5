package com.example.ex_3_hw.aspects;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {


    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returnedValue")
    public void trackUser(Object returnedValue){
        System.out.println("Method" + returnedValue);
    }
}
