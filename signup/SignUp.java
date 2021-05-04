package signup;

import Exceptions.UserExistsException;
import UserInfo.UserInfo;
import java.util.Map;

public class SignUp extends UserInfo {
   private static Map<String, String> custom_Map;
   private static SignUp instance = new SignUp();
   private static final SignUp instance_data;

   private SignUp() {
   }

   private SignUp(Map<String, String> map) {
      super(map);
   }

   public static SignUp getInstance() {
      return instance;
   }

   public static SignUp getInstance(Map<String, String> map) {
      custom_Map = map;
      return instance_data;
   }

   public void createUser(String username, String password) {
      try {
         this.checkCreate(username, password);
      } catch (UserExistsException var4) {
         var4.printStackTrace();
      }

   }

   public void createUser(int phone, String password) {
      try {
         this.checkCreate(Integer.toString(phone), password);
      } catch (UserExistsException var4) {
         var4.printStackTrace();
      }

   }

   static {
      instance_data = new SignUp(custom_Map);
   }
}
