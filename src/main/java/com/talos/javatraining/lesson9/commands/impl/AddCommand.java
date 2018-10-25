package com.talos.javatraining.lesson9.commands.impl;

import com.talos.javatraining.lesson9.events.EventBus;
import com.talos.javatraining.lesson9.events.EventType;


public class AddCommand extends CommandTemplate
{
	public AddCommand(EventBus eventBus, String... args)
	{
		super(eventBus, args);
	}

	@Override
	public EventType getEvent()
	{
		return EventType.ADD;
	}
}
