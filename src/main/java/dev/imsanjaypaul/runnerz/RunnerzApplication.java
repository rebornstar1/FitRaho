package dev.imsanjaypaul.runnerz;

import dev.imsanjaypaul.runnerz.run.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import dev.imsanjaypaul.runnerz.run.Run;
import java.time.LocalDateTime;

import static org.springframework.http.HttpHeaders.LOCATION;

@SpringBootApplication
public class RunnerzApplication {

	public static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
		log.info("Application Started Successfully");
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(1,"First Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1),3, Location.OUTDOOR);
            log.info("Run : {}",(Run)run);
		};
	}
}
