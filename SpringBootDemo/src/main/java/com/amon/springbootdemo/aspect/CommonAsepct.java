package com.amon.springbootdemo.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonAsepct {
    
    @Around("@within(com.amon.springbootdemo.annotation.MyAnnotation) && execution(public * *(..))")
    public void around(){
        System.out.println("you are being around!!");
    }
    
}
