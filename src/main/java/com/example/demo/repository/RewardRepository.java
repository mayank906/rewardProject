package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerData;

@Repository
public interface RewardRepository extends JpaRepository<CustomerData, Long> {
	List<CustomerData> findByCustomerIdAndDateBetween(String customerId, LocalDate startDate, LocalDate endDate);
}
