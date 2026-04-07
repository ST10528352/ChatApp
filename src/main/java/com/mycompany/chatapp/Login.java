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
}
    