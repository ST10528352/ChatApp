package com.mycompany.chatapp;

public class Login { 
/*
 * Login class for QuickChat.
 * Handles user registration and login.
 *
// Reference: Friedl, J. (2006). Mastering Regular Expressions. O'Reilly Media.
// Used to validate SA cell numbers starting with +27 followed by 9 digits.
*/


    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // Constructor - stores all the user details
    public Login(String username, String password, String cellPhoneNumber,
                 String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Checks username has underscore and is 5 or less characters
    public boolean checkUserName() {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        }
        return false;
    }
     // Checks password is at least 8 chars, has a capital, number and special character
    public boolean checkPasswordComplexity() {
        if (password.length() < 8) {
            return false;
        }
 
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
 
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
 
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetter(c) && !Character.isDigit(c)) {
                hasSpecial = true;
            }
        }
 
        if (hasCapital && hasNumber && hasSpecial) {
            return true;
        }
        return false;
    }
     // Checks cell number starts with +27 and is 12 characters total
    // +27 = 3 chars, then 9 digits = 12 total e.g. +27838968976
    // Reference: Regexr.com (2023). Phone number patterns. Retrieved from https://www.regexr.com/
    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber.startsWith("+27") && cellPhoneNumber.length() == 12) {
            return true;
        }
        return false;
    }
     // Registers the user and returns the correct message
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "User registered successfully.";
    }
 
    // Checks if the entered username and password match what was registered
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            return true;
        }
        return false;
    }
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
 
    // Getters so Main.java can access the stored details
    public String getFirstName() {
        return firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public String getUsername() {
        return username;
    }
}
    