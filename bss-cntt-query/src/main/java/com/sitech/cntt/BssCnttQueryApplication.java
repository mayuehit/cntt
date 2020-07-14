package com.sitech.cntt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.sitech.cntt.inter")
@EnableDiscoveryClient
public class BssCnttQueryApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BssCnttQueryApplication.class).run(args);
	}

}
