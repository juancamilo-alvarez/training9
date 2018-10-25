package com.talos.javatraining.lesson9.strategies;

import java.math.BigDecimal;
import java.math.MathContext;

@FunctionalInterface
public interface ProcessCalculation
{
	BigDecimal calculate(BigDecimal a, BigDecimal b, MathContext context);
}
