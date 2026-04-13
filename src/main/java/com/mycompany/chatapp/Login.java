/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 * Login class deals with user registration and authentication.
 * It validates username. password complexity and SA phone numbers.
 *
 * @author lab_services_student
 */
public class Login {
    //Stored user data
    
    private String Username;
    private String Password;
    private String PhoneNumber;
    private String FirstName;
    private String LastName;
    
    public Login (String FirstName,String LastName,String Username, String Password,
            String PhoneNumber) {
    this.FirstName = FirstName;
    this.LastName  = LastName;
    this.Username  = Username;
    this.Password  = Password;
    this.PhoneNumber = PhoneNumber;
   
    
   }
    //Checks stored username that is used after the object is built
    public boolean checkUsername() { 
        return checkUsername(this.Username);
    }
    
    /** 
     * Checks given username has a underscore and is has 5 or more characters
     * It is called from main in input collection so a full login 
     * object doesn't need to be constructed
     */
   public boolean checkUsername(String input) {
   if (input == null) return false;
   return input.contains("_") && input.length() <=5;
   }
    
   
   /**
    * Checks stored password that is used after the object is built 
    */
   public boolean checkPasswordComplexity() {
   return checkPasswordComplexity(this.Password);
   }
   
   
   /**
    * Checks if given password meets all complexity rules
    * has 8 characters at least
    * has at least 1 uppercase letter
    * has at least 1 digit
    * has at least one special character
    * Called from Main during input collection
    */
   public boolean checkPasswordComplexity(String input) {
   if(input ==null || input.length() <8) return false;
   
   boolean hasUpper  = false;
   boolean hasDigit  = false;
   boolean hasSpecial = false;
   for(char c : input.toCharArray()) {
   
       if(Character.isUpperCase(c)) 
           hasUpper = true;
       
       else if(Character.isDigit(c))
           hasDigit = true;
       
       else if(Character.isLetterOrDigit(c))
           hasSpecial = true;
   
   }
   return hasUpper && hasDigit && hasSpecial;
   }
   
   /**
    * Validates stored phone number that is used after object is fully built
    */
   public boolean checkPhoneNumber() {
   return checkPhoneNumber(this.PhoneNumber);
   }
   
   /**
    * Validates given South African phone number
    * Has to start with +27 
    * has to have 9 digits
    * Called from Main during input collection
    */
   public boolean checkPhoneNumber(String input) {
        if(input == null) 
       return false;    //+27 followed by 9 digits
   return input.matches("^\\+27[0-9]{9}$");
   }
   
   //Registration
   
   /**
    *Attempts to register a user by validating username, password and phone number in order
    */
   public String registerUser() {
   if(!checkUsername()) {
        return "Username is not correctly formatted: please that your "
           + "username contains an underscore and is no more than five "
           + "characters in length. ";
   }
   if(!checkPasswordComplexity()) {
        return "Password is not correctly formatted; please ensure that the "
           + "password contains at least eight characters, a capital "
           + "letter, a number, and a special character.";
   }
   if(!checkPhoneNumber()) {
        return "Cell phone number incorrectly formatted; please ensure that the "
           + "international code";
   }
   return "Registration successful! Welcome, " + FirstName + " " + LastName + " ";
   }
   
   //Login
   
   /**
    * Verifies supplied credentials against stored username and password
    */
   
  public boolean LoginUser(String enteredUsername, String enteredPassword) {
  
      if(enteredUsername == null || enteredPassword == null)
          return false;
      return Username.equals(enteredUsername) && Password.equals(enteredPassword);
  }
  
  /**
   * Returns a human-readable login status message
   */
  public String returnLoginStatus(String enteredUsername, String enteredPassword) {
      if(LoginUser(enteredUsername, enteredPassword)) {
          return "Welcome " + FirstName + " " + LastName + " It is great to see you again. ";
      }
  return "Username or password incorrect, please try again.";
  }
  //Getters
  
 public String getUsername() {
        return Username;
 }
 
 public String getFFirstName() {
        return FirstName;
 }
 
 public String getLastName() {
        return LastName;
 }
 
 public String getPhoneNumber() {
        return PhoneNumber;
 }
} 
   

