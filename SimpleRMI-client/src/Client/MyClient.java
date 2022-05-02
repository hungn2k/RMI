package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import ComputePi.ComputePi;
import ComputePi.Pi;

public class MyClient {

	public static void main(String[] args) {
		boolean done = false;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		//prompt the user for the number of decimal point and then compute PI accordingly
		try {
			System.setSecurityManager(new RMISecurityManager());
			ComputePi theServer = (ComputePi) Naming.lookup("rmi://locahost/myserver");
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
