package UserInfo;

import Exceptions.IncorrectKeyException;
import Exceptions.UserExistsException;
import Exceptions.UserNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class UserInfo {
   private Map<String, String> username;
   private final String decryption_key = "15982359853214475368412586398";

   protected UserInfo() {
      this.username = new HashMap();
   }

   protected UserInfo(Map<String, String> map) {
      Iterator var2 = map.entrySet().iterator();

      while(var2.hasNext()) {
         Entry<String, String> m = (Entry)var2.next();
         this.username.put(this.encryptKey((String)m.getKey()), (String)m.getValue());
      }

   }

   private String encryptKey(String password) {
      String newKey = new String();

      for(int i = 0; i < password.length(); ++i) {
         int ascii = password.charAt(i);
         int ascii = ascii + "15982359853214475368412586398".charAt(i);
         newKey = newKey + (char)ascii;
      }

      return newKey;
   }

   private String decryptKey(String password) {
      String key = "";
      StringBuilder old_key = new StringBuilder();

      for(int i = password.length() - 1; i >= 0; --i) {
         int ascii = password.charAt(i);
         int ascii = ascii - "15982359853214475368412586398".charAt(i);
         key = key + (char)ascii;
      }

      old_key.append(key);
      old_key = old_key.reverse();
      return old_key.toString();
   }

   protected void checkCreate(String uname, String password) throws UserExistsException {
      Iterator var3 = this.username.entrySet().iterator();

      Entry map;
      do {
         if (!var3.hasNext()) {
            String newKey = this.encryptKey(password);
            this.username.put(uname, newKey);
            return;
         }

         map = (Entry)var3.next();
      } while(!((String)map.getValue()).equals(uname));

      throw new UserExistsException();
   }

   protected void checkLogin(String uname, String password) throws UserNotFoundException, IncorrectKeyException {
      Iterator var3 = this.username.entrySet().iterator();
      if (var3.hasNext()) {
         Entry<String, String> map = (Entry)var3.next();
         if (((String)map.getValue()).equals(uname)) {
            String key = this.decryptKey((String)this.username.get(uname));
            if (!password.equals(key)) {
               throw new IncorrectKeyException();
            }
         } else {
            throw new UserNotFoundException();
         }
      }
   }
}
