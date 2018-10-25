package com.talos.javatraining.lesson9.strategies.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class ScientificStrategy extends CalculatorTemplate
{

	@Override
	protected String convertToString(BigDecimal value)
	{
		return getFormatter().format(value);
	}

	private DecimalFormat getFormatter()
	{
		DecimalFormat formatter = new DecimalFormat("0.00E00");
		formatter.setRoundingMode(RoundingMode.HALF_UP);
		formatter.setMinimumFractionDigits(10);
		return formatter;
	}
}
