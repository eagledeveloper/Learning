package ch.gmtech.learning.refactoring.extractmethod;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrinterTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	private final String expected = "**************************\n" +
			"***** Customer Owes ******\n" +
			"**************************\n" +
			"name: Valentino\n" +
			"amount: 30.0\n";

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testPrintOwing() {
		Printer printer = new Printer();
		printer.addOrder(new Order(10));
		printer.addOrder(new Order(20));
		printer.printOwing();
		assertEquals(expected, outContent.toString());
		
	}

}
