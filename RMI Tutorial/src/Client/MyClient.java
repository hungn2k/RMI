package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

import ComputePi.Pi;
import Server.MyServer;

public class MyClient {

	public static void main(String[] args) {
		boolean done = false;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//allocate an instance to our server wrapper.
		
		MyServer theServer = new MyServer();
		
		//prompt the user for the number of decimal point and then compute PI accordingly
		try {
			while(!done) {
				System.out.println("Compute PI to how many decimal points?");
				String command = reader.readLine();
				if(command == null || command.equalsIgnoreCase("quit")) {
					done = true;
				}else {
					try {
						int digits = Integer.parseInt(command);
						Pi piComputation = new Pi(digits);
						BigDecimal theResult = theServer.computePi(piComputation);
						System.out.println("Congratulation! The answer is: "+ theResult);
						
					}catch (NumberFormatException e) {
						System.out.println("Whoops, that was not a valid interger value. Please try again!");
					}
				}
			}
			
		}catch (Exception e) {
			System.out.println("Uh uh, something bad happend");
		}

	}

}
