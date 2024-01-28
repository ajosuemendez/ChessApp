package com.thechessnuts.storagehandlerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class StorageHandlerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageHandlerServiceApplication.class, args);
    }
}
