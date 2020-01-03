package com.icbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ServletComponentScan
@SpringBootApplication
public class KfybApplication {
	public static void main(String[] args) {
		SpringApplication.run(KfybApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(new Class[] {KfybApplication.class});
	}
}
