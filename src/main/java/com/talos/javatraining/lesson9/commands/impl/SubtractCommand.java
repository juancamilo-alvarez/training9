package com.talos.javatraining.lesson9.commands.impl;

import com.talos.javatraining.lesson9.events.EventBus;
import com.talos.javatraining.lesson9.events.EventType;


public class SubtractCommand extends CommandTemplate
{
	public SubtractCommand(EventBus eventBus, String... args)
	{
		super(eventBus, args);
	}

	@Override
	public EventType getEvent()
	{
		return EventType.SUBTRACT;
	}
}
