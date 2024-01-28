package com.thechessnuts.gamesessionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GameSessionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameSessionServiceApplication.class, args);
	}

}
