package com.itron.Kata;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BMICalculator {

	public static double calculateBmi(Integer inches, Integer pounds) {
		Double bmi = (double) (pounds * 703) / (inches * inches);
		double roundToTwoPlaces = new BigDecimal(bmi).setScale(2, RoundingMode.HALF_UP).doubleValue();
		return roundToTwoPlaces;
	}

}
