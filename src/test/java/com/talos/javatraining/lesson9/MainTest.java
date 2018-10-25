package com.talos.javatraining.lesson9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;



public class MainTest
{
	private static final String EXPECTED = "These are the possible operations:\n"
			+ "{a} + {b} : Sums {a} and {b}\n"
			+ "{a} - {b} : Subtracts {b} from {a}\n"
			+ "{a} * {b} : Multiplies {a} and {b}\n"
			+ "{a} / {b} : Divides {a} by {b}\n"
			+ "=> {mode} : Sets the mode you want. The possible modes are: basic or scientific\n"
			+ "x         : Finishes the program\n"
			+ "\n"
			+ "Type the operation: \n"
			+ "mode: basic\n"
			+ "Type the operation: \n"
			+ "> 268.91435\n"
			+ "Type the operation: \n"
			+ "> 10.56860\n"
			+ "Type the operation: \n"
			+ "> 30.06667\n"
			+ "Type the operation: \n"
			+ "> 303030.30303\n"
			+ "Type the operation: \n"
			+ "not supported mode: scientifics\n"
			+ "Type the operation: \n"
			+ "mode: scientific\n"
			+ "Type the operation: \n"
			+ "> 5.8124000100E04\n"
			+ "Type the operation: \n"
			+ "> 4.5211000000E04\n"
			+ "Type the operation: \n"
			+ "> 7.2943697310E05\n"
			+ "Type the operation: \n"
			+ "> 2.9429430146E05\n"
			+ "Type the operation: \n";
	private Main main = new Main();
	private StringWriter writer;

	@Before
	public void setup()
	{
		StringReader reader = new StringReader("=> basic\n"
				+ "23.4567894 + 245.45756\n"
				+ "45.1231455 - 34.554544\n"
				+ "3.3 * 9.1111111\n"
				+ "3333333.3333 / 11\n"
				+ "=> scientifics\n"
				+ "=> scientific\n"
				+ "55000.99999999 + 3123.0001\n"
				+ "45212 - 1.0000000000001\n"
				+ "66312.4521 * 11\n"
				+ "9123123.345123 / 31\n"
				+ "x\n");
		writer = new StringWriter();
		main.init(reader, new PrintWriter(writer, true));
	}

	@Test
	public void testApp() throws Exception
	{
		main.execute();

		String actual = writer.toString();
		Assert.assertEquals(EXPECTED, actual);
	}

	@Test
	public void checkRemovedClasses()
	{
		boolean ok = true;
		ClassLoader classLoader = MainTest.class.getClassLoader();
		ok &= checkClass(classLoader, "commands.impl.ExitCommand");
		ok &= checkClass(classLoader, "commands.impl.ChangeModeCommand");
		ok &= checkClass(classLoader, "commands.impl.AddCommand");
		ok &= checkClass(classLoader, "commands.impl.SubtractCommand");
		ok &= checkClass(classLoader, "commands.impl.MultiplyCommand");
		ok &= checkClass(classLoader, "commands.impl.DivideCommand");
		ok &= checkClass(classLoader, "events.CalculatorEvent");
		ok &= checkClass(classLoader, "strategies.impl.BasicStrategy");
		ok &= checkClass(classLoader, "strategies.impl.ScientificStrategy");
		Assert.assertTrue("Some classes should be removed", ok);
	}

	private boolean checkClass(ClassLoader classLoader, String name)
	{
		boolean result;
		try
		{
			classLoader.loadClass("com.talos.javatraining.lesson9." + name);
			System.err.println("Class " + name + " should be removed");
			result = false;
		}
		catch (ClassNotFoundException ex)
		{
			result = true;
		}
		return result;
	}
}
