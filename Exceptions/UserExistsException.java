package Exceptions;

public class UserExistsException extends Exception {
   public UserExistsException() {
      System.out.println("User Already Exists!");
   }
}
