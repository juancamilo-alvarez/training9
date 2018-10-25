package com.talos.javatraining.lesson9;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.talos.javatraining.lesson9.commands.AppCommand;
import com.talos.javatraining.lesson9.events.EventBus;
import com.talos.javatraining.lesson9.events.EventType;
import com.talos.javatraining.lesson9.factories.CommandFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Optional;


public class Main
{

	private BufferedReader reader;
	private PrintWriter out;
	private EventBus eventBus;
	private CommandFactory commandFactory;

	public static void main(String[] args)
	{
		Main main = new Main();
		main.init(new InputStreamReader(System.in), new PrintWriter(System.out, true));
		main.execute();
	}

	public void init(Reader input, PrintWriter out)
	{
		this.reader = new BufferedReader(input);
		this.out = out;
		Injector injector = Guice.createInjector(new AppModule());
		this.eventBus = injector.getInstance(EventBus.class);
		this.commandFactory = injector.getInstance(CommandFactory.class);
		eventBus.register(EventType.RESULT, args -> out.println(args[0]));
	}

	public void execute()
	{
		printInstructions();
		while (true)
		{
			out.println("Type the operation: ");
			try
			{
				String line = reader.readLine();
				Optional<AppCommand> commandOptional = commandFactory.createCommand(line);
				commandOptional.ifPresent(AppCommand::execute);
			}
			catch (ExitException ex)
			{
				break;
			}
			catch (Exception ex)
			{
				System.err.println(ex.getMessage());
			}
		}
	}

	private void printInstructions()
	{
		out.println("These are the possible operations:");
		out.println("{a} + {b} : Sums {a} and {b}");
		out.println("{a} - {b} : Subtracts {b} from {a}");
		out.println("{a} * {b} : Multiplies {a} and {b}");
		out.println("{a} / {b} : Divides {a} by {b}");
		out.println("=> {mode} : Sets the mode you want. The possible modes are: basic or scientific");
		out.println("x         : Finishes the program");
		out.println("");
	}
}

