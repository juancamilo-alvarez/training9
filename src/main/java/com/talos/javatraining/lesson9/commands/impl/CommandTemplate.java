package com.talos.javatraining.lesson9.commands.impl;

import com.talos.javatraining.lesson9.commands.AppCommand;
import com.talos.javatraining.lesson9.events.EventBus;
import com.talos.javatraining.lesson9.events.EventType;


public abstract class CommandTemplate implements AppCommand
{

	private String[] args;
	private EventBus eventBus;

	public CommandTemplate(EventBus eventBus, String... args)
	{
		this.args = args;
		this.eventBus = eventBus;
	}

	@Override
	public void execute()
	{
		eventBus.notify(getEvent(), args);
	}

	public abstract EventType getEvent();
}
