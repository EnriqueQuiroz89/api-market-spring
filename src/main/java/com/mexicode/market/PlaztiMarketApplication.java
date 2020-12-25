package com.mexicode.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication  // Es la clase que debe ejecutar

public class PlaztiMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaztiMarketApplication.class, args);
	}

}
