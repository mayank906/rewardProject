package com.example.rewardsdata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rewardsdata.service.CustomerDataService;

@SpringBootTest
public class CustomerDataServiceTest {

	@Autowired
	private CustomerDataService customerDataService;

	@Test
	public void testCalculatePoints() {
		assertEquals(90, customerDataService.calculatePoints(120));
		assertEquals(25, customerDataService.calculatePoints(75));
		assertEquals(250, customerDataService.calculatePoints(200));
		assertEquals(0, customerDataService.calculatePoints(50));
	}

	@Test
	public void testGetMonthlyPoints() {
		Map<String, Integer> points = customerDataService.getMonthlyPoints("C1", LocalDate.of(2023, 1, 1),
				LocalDate.of(2023, 3, 31));
		assertEquals(90, points.get("JANUARY"));
		assertEquals(25, points.get("FEBRUARY"));
	}
}
