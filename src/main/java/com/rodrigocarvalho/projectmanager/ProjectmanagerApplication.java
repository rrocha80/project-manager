package com.rodrigocarvalho.projectmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.rodrigocarvalho.projectmanager"})
public class ProjectmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectmanagerApplication.class, args);
	}

}
