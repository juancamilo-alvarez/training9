package com.talos.javatraining.lesson9.events;

public interface EventBus
{
	void register(EventType event, CalculatorEvent observer);

	void notify(EventType event, String... args);
}
