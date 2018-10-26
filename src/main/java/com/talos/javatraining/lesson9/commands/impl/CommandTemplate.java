package com.talos.javatraining.lesson9.commands.impl;

import com.talos.javatraining.lesson9.commands.AppCommand;
import com.talos.javatraining.lesson9.events.EventBus;
import com.talos.javatraining.lesson9.events.EventType;


public class CommandTemplate implements AppCommand
{

	private String[] args;
	private EventBus eventBus;
	private EventType eventType;

	public CommandTemplate(EventBus eventBus, String... args)
	{
		this.args = args;
		this.eventBus = eventBus;
	}

	public CommandTemplate(EventBus eventBus, EventType eventType, String... args) {
		this.args = args;
		this.eventType = eventType;
		this.eventBus = eventBus;
	}

	@Override
	public void execute()
	{
		eventBus.notify(getEvent(), args);
	}

	// public abstract EventType getEvent();

	public EventType getEvent() {
		return eventType;
	}
}
