package com.thechessnuts.gameinitialisationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class GameInitialisationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameInitialisationServiceApplication.class, args);
	}

}
