package com.example.rewardsdata.service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rewardsdata.model.CustomerData;
import com.example.rewardsdata.repository.RewardRepository;

@Service
public class CustomerDataService {

    @Autowired
    private RewardRepository rewardRepository;

    public int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (amount - 100) * 2;
            amount = 100;
        }
        if (amount > 50) {
            points += (amount - 50);
        }
        return points;
    }

    public Map<String, Integer> getMonthlyPoints(String customerId, LocalDate startDate, LocalDate endDate) {
        List<CustomerData> customerDatas = rewardRepository.findByCustomerIdAndDateBetween(customerId, startDate, endDate);
        Map<String, Integer> monthlyPoints = new LinkedHashMap<>();

        for (CustomerData customerData : customerDatas) {
            String month = customerData.getDate().getMonth().toString();
            int points = calculatePoints(customerData.getAmount());
            monthlyPoints.put(month, monthlyPoints.getOrDefault(month, 0) + points);
        }
        int totalPoints = monthlyPoints.values().stream().mapToInt(Integer::intValue).sum();
        monthlyPoints.put("TOTAL", totalPoints);
        return monthlyPoints;
    }
}

