package login;

import Exceptions.IncorrectKeyException;
import Exceptions.UserNotFoundException;
import UserInfo.UserInfo;
import java.util.Map;

public class LogIn extends UserInfo {
   private static Map<String, String> custom_Map;
   private static LogIn instance = new LogIn();
   private static LogIn instance_data;

   LogIn() {
   }

   LogIn(Map<String, String> map) {
      super(map);
   }

   public static LogIn getInstance() {
      return instance;
   }

   public static LogIn getInstance(Map<String, String> map) {
      custom_Map = map;
      return instance_data;
   }

   public void login(String username, String password) {
      try {
         this.checkLogin(username, password);
      } catch (UserNotFoundException | IncorrectKeyException var4) {
         var4.printStackTrace();
      }

   }

   public void login(int phone, String password) {
      try {
         this.checkLogin(Integer.toString(phone), password);
      } catch (UserNotFoundException | IncorrectKeyException var4) {
         var4.printStackTrace();
      }

   }

   static {
      instance_data = new LogIn(custom_Map);
   }
}
