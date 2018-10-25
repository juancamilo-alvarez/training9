package com.talos.javatraining.lesson9.strategies.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class BasicStrategy extends CalculatorTemplate
{


	@Override
	protected String convertToString(BigDecimal value)
	{
		return value.setScale(5, RoundingMode.HALF_UP).toString();
	}
}
