package com.talos.javatraining.lesson9.factories;

import com.talos.javatraining.lesson9.commands.AppCommand;

import java.util.Optional;


public interface CommandFactory
{
	Optional<AppCommand> createCommand(String code);
}
