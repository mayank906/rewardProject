package com.example.rewardsdata;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerDataControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetRewards() throws Exception {
		mockMvc.perform(get("/api/rewards/C1").param("startDate", LocalDate.of(2023, 1, 1).toString()).param("endDate",
				LocalDate.of(2023, 3, 31).toString())).andExpect(status().isOk());
	}
}
