package Boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import Entity.Pharmacist;

public class PharmacistConsole {
	
	public static void console() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Name: " + Pharmacist.getInstance().getName() + " | Surname: " + Pharmacist.getInstance().getSurname());
		System.out.print("1. Oxygen cylinder registration.\n2. Restitution.\n: ");
		Integer i = Integer.parseInt(in.readLine());
		switch (i) {
		case 1:
			System.out.println("Developing fase.");
			break;
		case 2:
			System.out.println("Developing fase.");
			break;

		default:
			break;
		}
		
		
	}	

}
