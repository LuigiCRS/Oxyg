package Boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import Entity.Client;
import Entity.OxygenCylinder;
import Entity.Pharmacist;
import Entity.Sale;
import Control.PharmacistControl;

public class PharmacistConsole {

	public static void console() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(
				"Name: " + Pharmacist.getInstance().getName() + " | Surname: " + Pharmacist.getInstance().getSurname());
		System.out.print("1. Buy.\n2. Restitution.\n3. Exit.\n: ");
		Integer i = Integer.parseInt(in.readLine());
		switch (i) {
		case 1:
			buy();
			break;
		case 2:
			restitution();
			break;
		case 3:
			exit();
			break;
		default:
			System.out.println("Input not valid. Retry.");
			break;
		}
		console();
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

	public static void restitution() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***** RESTITUTION DATA *****");
		ArrayList<Sale> sales = PharmacistControl.restitutionData();
		Iterator<Sale> i = sales.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().toString());
		}
		System.out.print("Oxygen Cylinder ID: ");
		String idOxygen = in.readLine();
		System.out.print("Fiscal code: ");
		String CF = in.readLine();
		if(restitutionDataCheck(idOxygen, CF)) 
			PharmacistControl.restitutionOxygen(idOxygen, CF);
		else
			System.out.println("Canceled operation. Too much try.\n");

	}

	public static boolean restitutionDataCheck(String id, String CF) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Integer counter = 3;
		while (counter > 0 && !PharmacistControl.validId(id) && !PharmacistControl.validCF(CF)) {
			System.out.println("Id or Fiscal Code not found. Retry.\n");
			System.out.print("Oxygen Cylinder ID: ");
			id = in.readLine();
			System.out.print("Fiscal Code: ");
			CF = in.readLine();
			--counter;
		}
		if(counter <= 0)
			return false;
		else
			return true;
	}

	public static void exit() {
		System.out.println("***** GOODBY *****");
		PharmacistControl.exitControl();
	}

}
