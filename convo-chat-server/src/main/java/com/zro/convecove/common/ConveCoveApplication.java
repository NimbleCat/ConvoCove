package com.zro.convecove.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = {"com.zro.convecove"})
public class ConveCoveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConveCoveApplication.class,args);
    }

}