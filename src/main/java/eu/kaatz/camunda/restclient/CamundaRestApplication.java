package eu.kaatz.camunda.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamundaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaRestApplication.class, args);
	}

}
