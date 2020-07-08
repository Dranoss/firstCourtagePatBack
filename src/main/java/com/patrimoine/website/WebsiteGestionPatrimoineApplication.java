package com.patrimoine.website;

import com.patrimoine.website.webServices.service.DocumentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class WebsiteGestionPatrimoineApplication implements CommandLineRunner {
	@Resource
	DocumentService documentService;
	public static void main(String[] args) {
		SpringApplication.run(WebsiteGestionPatrimoineApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		// documentService.deleteAll();
		// documentService.init();
	}
}
