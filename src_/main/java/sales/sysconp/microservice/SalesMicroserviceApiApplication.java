package sales.sysconp.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SalesMicroserviceApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SalesMicroserviceApiApplication.class, args);
	}
}