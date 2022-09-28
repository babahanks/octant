package com.msalman.octant.app;

import com.msalman.octant.controller.Controller;
import com.msalman.octant.service.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {Controller.class, Service.class})
public class OctentApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(OctentApplication.class);
		app.setWebApplicationType(WebApplicationType.SERVLET);
		app.run(args);
	}

}
