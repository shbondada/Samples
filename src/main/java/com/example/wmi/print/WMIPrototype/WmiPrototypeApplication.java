package com.example.wmi.print.WMIPrototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.wmi.print.*")
public class WmiPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WmiPrototypeApplication.class, args);
	}
}
