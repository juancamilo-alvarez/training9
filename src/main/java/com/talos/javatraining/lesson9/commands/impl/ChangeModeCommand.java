package com.talos.javatraining.lesson9.commands.impl;

import com.talos.javatraining.lesson9.events.EventBus;
import com.talos.javatraining.lesson9.events.EventType;


public class ChangeModeCommand extends CommandTemplate
{

	public ChangeModeCommand(EventBus eventBus, String... args)
	{
		super(eventBus, args);
	}

	@Override
	public EventType getEvent()
	{
		return EventType.CHANGE_MODE;
	}
}
