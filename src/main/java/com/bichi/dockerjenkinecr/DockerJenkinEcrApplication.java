package com.bichi.dockerjenkinecr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class DockerJenkinEcrApplication {

	@RequestMapping("/")
	public String get(){
		return "Docker Jenkins ecr work fine";
	}
	public static void main(String[] args) {
		SpringApplication.run(DockerJenkinEcrApplication.class, args);
	}

}
