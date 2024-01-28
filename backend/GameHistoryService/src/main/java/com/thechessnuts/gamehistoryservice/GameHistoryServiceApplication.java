package com.thechessnuts.gamehistoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class GameHistoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameHistoryServiceApplication.class, args);
	}

}
