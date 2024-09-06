package com.sda.java3.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200")
						.allowedMethods("GET", "PUT", "DELETE", "POST");
			}
		};
	}

	private static void trueMain(String[] argv) throws IOException {
		if (argv.length != 1) {
			System.err.println(
					"usage: MergeDocIdToFileMaps paramsFile"
							+ "outputMap\n"
							+ "inputListOfMaps: a file with one filename per line of file maps to merge\n"
							+ "allowDuplicatesAndPreferEarlierEntries: boolean controlling our behavior when we find two docIDs\n");
			System.exit(1);
		}
	}
}
