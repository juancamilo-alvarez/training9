package com.talos.javatraining.lesson9.events;

/**
 * Notice this functional interface is similar than the core interface: Consumer&lt;Object[]&gt;
 */
@FunctionalInterface
public interface CalculatorEvent
{
	void update(String[] args);
}
