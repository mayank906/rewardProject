
package com.example.rewardsdata;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rewardsdata.model.CustomerData;
import com.example.rewardsdata.repository.RewardRepository;

@Configuration
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(RewardRepository repository) {
		return args -> {
			repository.saveAll(Arrays.asList(new CustomerData("C1", 120, LocalDate.of(2023, 1, 15)),
					new CustomerData("C1", 75, LocalDate.of(2023, 2, 10)),
					new CustomerData("C2", 200, LocalDate.of(2023, 3, 5)),
					new CustomerData("C2", 50, LocalDate.of(2023, 3, 20))));
		};
	}
}
