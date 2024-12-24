package br.com.samuel.martins.EmailServiceManagement;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class EmailServiceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceManagementApplication.class, args);
	}

}
