package com.example.rewardsdata.controller;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rewardsdata.service.CustomerDataService;

@RestController
@RequestMapping("/api/rewards")
public class CustomerDataController {

	@Autowired
	private CustomerDataService customerDataService;

	@GetMapping("/{customerId}")
	public ResponseEntity<Map<String, Integer>> getRewards(@PathVariable String customerId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
		Map<String, Integer> rewards = customerDataService.getMonthlyPoints(customerId, startDate, endDate);
		return ResponseEntity.ok(rewards);
	}
}
