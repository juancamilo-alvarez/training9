package com.talos.javatraining.lesson9.factories.impl;

import com.talos.javatraining.lesson9.commands.AppCommand;
import com.talos.javatraining.lesson9.commands.impl.*;
import com.talos.javatraining.lesson9.events.EventBus;
import com.talos.javatraining.lesson9.factories.CommandFactory;

import javax.inject.Inject;
import java.util.Optional;


public class CommandFactoryImpl implements CommandFactory
{
	private static final String EXIT = "x";
	private static final String MODE = "=>";
	private static final String ADD = "+";
	private static final String SUBTRACT = "-";
	private static final String MULTIPLY = "*";
	private static final String DIVIDE = "/";

	@Inject
	private EventBus eventBus;


	@Override
	public Optional<AppCommand> createCommand(String line)
	{
		String[] parts = line.trim().split("\\s+");
		Optional<AppCommand> result;
		int size = parts.length;
		if(size == 1 && EXIT.equals(parts[0])){
			result = Optional.of(new ExitCommand());
		} else if (size == 2 && MODE.equals(parts[0]))
		{
			result = Optional.of(new ChangeModeCommand(eventBus, parts[1]));
		}
		else if (size == 3)
		{
			AppCommand command = null;
			switch (parts[1])
			{
				case ADD:
					command = new AddCommand(eventBus, parts[0], parts[2]);
					break;
				case SUBTRACT:
					command = new SubtractCommand(eventBus, parts[0], parts[2]);
					break;
				case MULTIPLY:
					command = new MultiplyCommand(eventBus, parts[0], parts[2]);
					break;
				case DIVIDE:
					command = new DivideCommand(eventBus, parts[0], parts[2]);
					break;
			}
			result = Optional.ofNullable(command);
		}
		else
		{
			result = Optional.empty();
		}
		return result;
	}
}
