package test;

import java.io.PrintStream;

public class AutoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console c = new Console();
		PrintStream s = System.out;
		c.execute(s , new String[]{
				"-team", "-all" ,"-total"
		});

	}

}
