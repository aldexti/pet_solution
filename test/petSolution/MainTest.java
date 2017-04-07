package petSolution;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class MainTest {

	@Test
	public void testMain() {
		//Prepare to redirect output
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);

		//create args
		String[] arguments = {"input.csv", "search", "name=Azziz"};
		Main.main(arguments);
		
		assertEquals("Pet [type=DOG, name=Azziz, gender=M, update=2017-02-01 01:01:51.0]\r\n", os.toString());

		//Restore normal output
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
	}

	@Test
	public void testMain2() {
		//Prepare to redirect output
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);

		//create args
		String[] arguments = {"input2.csv", "create", "type=CAT", "name=Mimi", "gender=F"};
		Main.main(arguments);
		
		//need to write assertion for update input including last insertion

		//Restore normal output
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
	}

	@Test
	public void testMain3() {
		//Prepare to redirect output
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);

		//create args
		String[] arguments = {"input2.csv", "delete", "type=CAT", "name=Fluffy", "gender=M"};
		Main.main(arguments);

		assertEquals("", os.toString());
		//Restore normal output
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
	}


}
