/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the login class
 * All test data and expected response match the specification exactly.
 * The test covers:
 * Username validation
 * Password complexity
 * Phone number validation
 * Login success and failure
 *
 * @author lab_services_student
 */
public class LoginTest {
    // Shared login instances
    /*
    Valid user used for login and positive registration tests
    */
    
    private Login ValidUser;
    /** 
     * Reusable instances for single field validation tests
     */
    private Login badUsernameLogin;
    private Login badPasswordLogin;
    private Login badCellLogin;
    
    // Setup
    
    /**
     * Test of checkusername method, of class Login.
     */
    public LoginTest() {//Valid user (all fields and requirements)
        ValidUser = new Login(
        "Kyle",              // First name
        "Robertson",        // Last name
        "Kyl_1",           // Username (has underscore and more than 5 char)
        "Ch&&sec@ke99!",    // Password (8+ char, uppercase, digits and special char)
        "+27768756457"     // Phone Number (+27 + 9 digits)       
        );
        //Username too long and no underscore
        badUsernameLogin = new Login(
        "Kyle", "Robertson",
        "kyle!!!!!!!", // ussrname
        "Ch&&sec@ke99!",
        "+2734657869"        
        );
        
        //Weak password
        badPasswordLogin = new Login(
        "Kyle", "Robertson",
        "Kyl_1",
        "password",  //password
        "+27768756457"
        );        
                
         //Missin international code
         badCellLogin = new Login(
         "Kyle","Robertson",
         "Kyl_1",
         "Ch&&sec@ke99!",
         "0765467" // No +27 in phone number        
                 
         );       
       
    }
    

    //Username Test
    @Test
    public void testCheckusename() {
        assertEquals(
        "Welcome Kyle Robertson, it is great to see you again!",
           ValidUser.returnLoginStatus("Kyl_1", "Ch&&sec@ke99!")   
        );
}
    /**
     * Username: "kyle!!!!!!!" will return a error message
     */
 @Test   
void testUsernameCorrectlyFormatted_assertEquals() {
assertEquals(
"Username is not correctly formatted. Please ensure that your "
+ "Username conatains an underscore and is no more than five "
+ "characters in length.",
        badUsernameLogin.registerUser()
);
       
}

//Username correctly formatted
@Test
void testUsernameCorrectlyFormatted_assertTrue() {
assertTrue(ValidUser.checkUsername());
}

// Username incorrectly formatted
@Test
void testUsernameIncorrectlyFormatted_assertFalse() {
assertFalse(badUsernameLogin.checkUsername());

}

//Password Test

// Password: "Ch&&sec@ke99!" should say "Password succesfully captured"

@Test
void testPassword_assertTrue() {
// registerUser only reaches password when it is correct
// Test the complexity flag and build message 
Login user = new Login("Kyle", "Robertson", "Kyl_1", "Ch&&sec@ke99!", "+27768756457");
assertTrue(user.checkPasswordComplexity(),
        "Password 'Ch&&sec@ke99!' should pass the complexity check");

assertFalse(user.registerUser().contains("Password is not correctly formatted"));

}

// Password "password" should say "Password is not correctly formatted"

@Test
void testPassword_assertEquals() {
assertEquals(
"Password is not correctly formatted. Please ensure that the "
        + "Password contains at least 8 characters, a special "
        + "letter, a number and a special character.",
        badPasswordLogin.registerUser()
);

}

// Password meets complexitiy: assertTrue
@Test
void testPasswordMeetsComplexity_assertTrue() {
assertTrue(ValidUser.checkPasswordComplexity());
}

//Password does not meet complexity: assertFalse
@Test
void testPasswordDoesNotMeetComplexity_assertFalse() {
assertFalse(badPasswordLogin.checkPasswordComplexity());
}

//Phone Number Test

//Phone Number: "+27768756457" must give "Cell number successfully captured"

@Test
void testPhoneNumber_assertEquals() {
Login user = new Login("Kyle", "Robertson", "Kyl_1", "Ch&&sec@ke99!", "0768756457");
assertEquals(
        "Phone number is incorrectly formatted or does not contain "
        + "international code.",
        user.registerUser()
);

}

//Number: Correctly formatted = assertTrue
@Test
void testPhoneNumber_assertTrue() {
assertTrue(ValidUser.checkPhoneNumber());
}

// Number: Incorrectly formatted = assertFalse
@Test
void testPhoneNumber_assertFalse() {
assertFalse(badCellLogin.checkPhoneNumber());
}

//Login Test

// Login: Correct credentials = assertTrue
@Test
void testLogin_assertTrue() {
assertTrue(ValidUser.LoginUser("Kyl_1", "Ch&&sec@ke99!"));
}

// Login: Incorrect credentials = assertFalse
@Test
void testLogin_assertFalse() {
assertFalse(ValidUser.LoginUser("WrongUser", "WrongPass"));
} 
}
