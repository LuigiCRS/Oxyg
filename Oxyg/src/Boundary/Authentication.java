package Boundary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Control.AuthenticationManager;

public class Authentication {

	public static void start() throws IOException {
		System.out.println("******     LOGIN     ******");
		AuthenticationManager.openConnection();
		Login();
		PharmacistConsole.console();
	}
	
	public static void Login() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Username: ");
		String user = in.readLine();
		System.out.print("Password: ");
		String pass = in.readLine();
		AuthenticationManager.Authentication(user, pass);
		if(!AuthenticationManager.isAuthenticated()) {
			System.out.println("Incorrect username or password, retry.");
			Login();
		} 
	}
}
