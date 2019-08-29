package com.blaisedev.zipkinservice;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class ZipkinServiceApplication {


	private static Logger log = LoggerFactory.getLogger(ZipkinServiceApplication.class);

	@RequestMapping("/")
	public String home() {
		log.info("Handling home");
		return "Hello World";
	}

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServiceApplication.class, args);
	}

}
