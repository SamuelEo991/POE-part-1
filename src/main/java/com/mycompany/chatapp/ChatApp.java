/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

/**
 *
 * @author lab_services_student
 */
import java.util.Scanner; // import a scanner class


public class ChatApp {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); // creating object of a type scanner
        
        Login validator = new Login("","","","",""); // creating object userlogin of a type login
        
        System.out.println("=== QucikChat - Registration ===\n");
       
        System.out.print("Enter your First Name : "); //validates First name
        String FirstName = scanner.nextLine();
        
        System.out.print("Enter your Last name : "); //validates Last name
        String LastName = scanner.nextLine();
       
        
        
        
        String Username = ""; // Keep asking for username until input is valid
        while(true){
        System.out.println("Please enter the username: ");
        Username = scanner.nextLine();
        
         if(validator.checkUsername(Username) ==false){
       System.out.println("Username is not correctly formatted");
        
        }else
       {
       System.out.println("Username successfully captured");
       break;
       }
        System.out.println("Username is not correctly formatted, please esnure that " +
                "your username contains an underscore and is no more than " + 
                "five characters in length. \n");
        }
        
        String Password = ""; //Keeps asking for password until input is valid 
        while(true) {
        System.out.print("Enter a password  : ");
        Password = scanner.nextLine();
        
        if(validator.checkPasswordComplexity(Password)){
        System.out.println("Password succesfully captured. \n");
        break;
        }
        
        System.out.println("Password is not correctly formatted, please ensure that " + 
                "the password contains at least eight characters, a capital " + 
                "Letter, a number, and a special character. \n");
        }
        
        
        
        String PhoneNumber = ""; //Keeping asking for Phone number until its valid
        while(true) {
        System.out.print("Enter phone number (eg +27834467896) : ");
        PhoneNumber = scanner.nextLine();
        
        if(validator.checkPhoneNumber(PhoneNumber)) {
        System.out.println("Phone number successfully added. \n");
        break;
        }
        
        System.out.println("Phone number incorrectly formatted or does not "
        + "contain international code. \n");
        }
        
        // Build a registered user object
        Login login = new Login(FirstName, LastName, Username, Password, PhoneNumber);
        System.out.println("Registration succesfull! Welcome, " + FirstName + " " + LastName + " .");
        System.out.println("-------------------\n");
        
        System.out.println("=== QuickChat - Login ===\n");
        
        while(true){
        System.out.print("Username : ");
        String enteredUsername = scanner.nextLine().trim();
        
        System.out.print("Password : ");
        String enteredPassword = scanner.nextLine().trim();
        
        System.out.println();
        System.out.println(login.returnLoginStatus(enteredUsername, enteredPassword));
        System.out.println();
        
        if (login.LoginUser(enteredUsername, enteredPassword)) {
        break; //login succesful - stop 
        }
        // login failed - loop back and ask again automatically
        }
      scanner.close();
       
       } 
    }

