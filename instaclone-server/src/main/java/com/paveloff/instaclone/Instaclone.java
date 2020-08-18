package com.paveloff.instaclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.paveloff.instaclone.repositories.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Instaclone {

	public static void main(String[] args) {
		SpringApplication.run(Instaclone.class, args);
	}

}
