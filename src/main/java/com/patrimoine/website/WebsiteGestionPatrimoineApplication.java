package com.patrimoine.website;

import com.patrimoine.website.webServices.service.DocumentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class WebsiteGestionPatrimoineApplication implements CommandLineRunner, WebMvcConfigurer {
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

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (!registry.hasMappingForPattern("/accessible/**")) {
			try {
				String path = "file:///" + new File("./uploads/").getCanonicalPath();
				registry.addResourceHandler("/uploads/**")
						.addResourceLocations("classpath:/", path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
