package Boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Entity.Client;
import Entity.OxygenCylinder;
import Entity.Pharmacist;

import Control.PharmacistControl;

public class PharmacistConsole {

	public static void console() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(
				"Name: " + Pharmacist.getInstance().getName() + " | Surname: " + Pharmacist.getInstance().getSurname());
		System.out.print("1. Buy.\n2. Restitution.\n: ");
		Integer i = Integer.parseInt(in.readLine());
		System.out.println("Insert data.");
		switch (i) {
		case 1:
			buy();
			break;
		case 2:
			System.out.println("Developing fase.");
			break;

		default:
			break;
		}
	}
	
	public static void buy() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***** OXYGEN CYLINDER DATA *****");
		System.out.print("Oxygen Cylinder ID: ");
		String idOxygen = in.readLine();
		System.out.print("Oxygen Cylinder volume: ");
		Integer volume = Integer.parseInt(in.readLine());
		System.out.println("***** CLIENT DATA *****");
		System.out.print("Fiscal Code: ");
		String CF = in.readLine();
		System.out.print("Name: ");
		String name = in.readLine();
		System.out.print("Surname: ");
		String surname = in.readLine();
		System.out.print("Address: ");
		String address = in.readLine();
		
		OxygenCylinder o = new OxygenCylinder(idOxygen, volume);
		Client c = new Client(name, surname, address, CF);
		
		PharmacistControl.buyOxygen(o, c);
		
		

	}

}
