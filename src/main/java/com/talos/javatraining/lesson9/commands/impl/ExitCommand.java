package com.talos.javatraining.lesson9.commands.impl;

import com.talos.javatraining.lesson9.ExitException;
import com.talos.javatraining.lesson9.commands.AppCommand;


public class ExitCommand implements AppCommand
{
	@Override
	public void execute()
	{
		throw new ExitException();
	}
}
