package com.mycompany.chatapp;

import java.util.Scanner;

/**
 * Main entry point for the QuickChat application.
 * Handles the registration and login flow.
 * 
 * showing friend how to push stuff
 */

public class ChatApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== QuickChat ===");
        System.out.println("Please register to continue.");
        
        //Collect user details
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        
        System.out.println("Enter username (must contain '_' and be max 5 characters): ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password (min 8 chars, must have uppercase, number, special char): ");
        String password = scanner.nextLine();
 
        System.out.print("Enter cell phone number (SA numbers only, e.g. +27831234567): ");
        String cellNumber = scanner.nextLine();
        
         // Attempt registration
        Login user = new Login(username, password, cellNumber, firstName, lastName);
        String registrationResult = user.registerUser();
        System.out.println("\n" + registrationResult);
        
        // Stop if registration failed
        if (!registrationResult.equals("User registered successfully.")) {
            System.out.println("Registration failed. Please restart and try again.");
            scanner.close();
            return;
        }
        
        //Login
        System.out.println("\n--- Login ---");
        System.out.println("Enter username: ");
        String loginUsername = scanner.nextLine();
        
        System.out.println("Enter password: ");
        String loginPassword = scanner.nextLine();
        
        String loginStatus = user.returnLoginStatus(loginUsername, loginPassword);
        System.out.println("\n" + loginStatus);
        
      scanner.close();
    }
}
