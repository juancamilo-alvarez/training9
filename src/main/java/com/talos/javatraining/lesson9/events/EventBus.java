package com.talos.javatraining.lesson9.events;

import java.util.function.Consumer;


public interface EventBus
{
	//void register(EventType event, CalculatorEvent observer);
	void register(EventType event, Consumer<String[]> observer);

	void notify(EventType event, String... args);
}
