package com.itron.Kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BMI Calculator should") 
public class BMICalculatorShould {

	@Test
	@DisplayName("calculator BMI to two places correctly via inches and pounds")
	void calculateCorrcetly() {
		assertEquals(19.2, BMICalculator.calculateBmi(69, 130));
		assertEquals(21.52, BMICalculator.calculateBmi(70, 150));
	}
}
