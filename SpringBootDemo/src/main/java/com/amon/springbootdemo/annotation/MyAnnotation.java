package com.amon.springbootdemo.annotation;


import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

@ResponseBody
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface MyAnnotation {
}
