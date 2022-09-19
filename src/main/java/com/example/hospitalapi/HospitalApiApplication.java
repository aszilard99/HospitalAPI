package com.example.hospitalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")

@RestController
public class HospitalApiApplication {

	@RequestMapping("/")
	public String home(){
		return "Hello Docker World";
	}

	public static void main(String[] args) {
		SpringApplication.run(HospitalApiApplication.class, args);
	}

}
