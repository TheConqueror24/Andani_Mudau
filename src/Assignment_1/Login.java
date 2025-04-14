 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment_1;

import java.util.HashMap;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class Login {
    
    private static final HashMap<String, String> userDatabase = new HashMap<>();
     private final boolean loginStatus = false;
    
     
    // Method (Boolean) checkUserName() : for making sure that any username contains an underscore and is not more than Five. 
    public static boolean checkUserName(String username){
        String regex = "^(?=.*_)[a-zA-Z0-9_]{1,5}$";

        return username.matches(regex);
    }
    
    
    // Method (Boolean) checkPasswordComplexity() : for making sure that the password contains a capital letter, a number, a special character and at least 8 characters.
    public static boolean checkPasswordComplexity(String password){
    
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, password);
    }
    
    // Method (Boolean) checkCellPhoneNumber() :  for ensuring  that the user cell phone is correct length and contains the international country code.
    public static boolean checkCellPhoneNumber(String phone){
        String phoneRegex =  "^\\+27[6-8][0-9]{8}$";
      return Pattern.matches(phoneRegex,phone);
    }
    
    
    /*
    // Method (String) registerUser() > this return necessary registration messaging indicating if :
    // > the username is incorrectly formatted
    // > Passwords does not meet complexity requirements 
    // > and if the above two conditions hav beeen meet, the user will recieve "user and the user has been rgistered successfully" 
    //And return messages indicating user details that has been succesfully captured and added
     */
     public String registerUser(String username, String password, String phoneNumber) {
         
          if (Registration_Form.Fname.equals("")) {
             String Fname = "Please enter your Name";
            JOptionPane.showMessageDialog(null, Fname, "Registration Error", JOptionPane.ERROR_MESSAGE);
            return Fname; 
          }
          
          
          if (!Registration_Form.Surname.equals("")) {
              String Lname = "Please enter your Surname";
              JOptionPane.showMessageDialog(null, Lname, "Registration Error", JOptionPane.ERROR_MESSAGE);
              return Lname;
        }
          
          
          
        if (!checkUserName(username)) {
              
            String message = "Username is incorrectly formatted, please ensure that your username contains an underscore and is no more than five characters in lenght.";
            JOptionPane.showMessageDialog(null, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
            
            return message;
        }else {
              
            String messagee1 = "Username is successfully captured.";
            JOptionPane.showMessageDialog(null, messagee1, "Registration ", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        
        if (!checkPasswordComplexity(password)) {
            
            String message = "Password is incorrectly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and  a special character.";
            JOptionPane.showMessageDialog(null, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
            
            return message;
        }else {
            
            String messagee1 = "Password is successfully captured.";
            JOptionPane.showMessageDialog(null, messagee1, "Registration ", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        
        if (!checkCellPhoneNumber(phoneNumber)) {
            
            String message = "Cell phone number is incorrectly formatted or does not contain international code.";
            JOptionPane.showMessageDialog(null, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
            
            return message;
        }else {
            
            String message1 = "Cell phone number has been successfully added.";
            JOptionPane.showMessageDialog(null, message1, "Registration ", JOptionPane.INFORMATION_MESSAGE);
            
        }
        

        userDatabase.put(username, password);
        String successMessage = "Your Account Registration was Successful.";
        JOptionPane.showMessageDialog(null, successMessage, "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
        
        return successMessage;
    }

     // Method to verify that the login details entered match the login details stored when the user register
    public boolean loginUser(String username, String password) {
        System.out.println("Attempting login for: " + username);
        System.out.println("Stored Password: " + userDatabase.get(username));
        System.out.println("Entered Password: " + password);

      return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    // Method to return login status message

    /**
     *
     * @param isSuccess
     * @return
     */
    

    // Method to return login status message
    public String returnLoginStatus(boolean isSuccess) {
        String message;
        message = isSuccess ? Registration_Form.Fname + "Welcome " + " " + Registration_Form.Surname + ", it is great to see you again." : "Username or password incorrect, please try again.";
        JOptionPane.showMessageDialog(null, message, "Login Status", isSuccess ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
        return message;
    }

    
   public boolean LoginUser(String username, String password) {
    return username.equals("admin") && password.equals("password");
}

    public void registerUser(String kyl_1, String chsecke99) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean returnLoginStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}