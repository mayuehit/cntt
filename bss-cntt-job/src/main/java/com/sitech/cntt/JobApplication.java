package com.sitech.cntt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.sitech.cntt.inter")
public class JobApplication
{
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(JobApplication.class);
        builder.run(args);
    }
}
