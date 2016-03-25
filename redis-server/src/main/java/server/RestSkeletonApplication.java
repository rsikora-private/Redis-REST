package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:app-context.xml")
public class RestSkeletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestSkeletonApplication.class, args);
	}
}
