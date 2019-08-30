package com.me.storyhubuserrepositorybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication
public class StoryhubUserRepositoryBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoryhubUserRepositoryBackendApplication.class, args);
    }

}
