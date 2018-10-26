package com.talos.javatraining.lesson9.events.impl;

import com.talos.javatraining.lesson9.events.EventBus;
import com.talos.javatraining.lesson9.events.EventType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;


public class EventBusImpl implements EventBus
{
	private Map<EventType, List<Consumer<String[]>>> records;

	public EventBusImpl()
	{
		records = new ConcurrentHashMap<>();
	}

	@Override
	public void register(EventType event, Consumer<String[]> observer)
	{
		records.computeIfAbsent(event, e -> new ArrayList<>()).add(observer);
	}

	@Override
	public void notify(EventType event, String... args)
	{
		records.getOrDefault(event, Collections.emptyList()).forEach(o -> o.accept(args));
	}
}
