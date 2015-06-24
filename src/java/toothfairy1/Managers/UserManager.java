/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Managers;

import DAO.Factory;
import com.sun.xml.wss.impl.misc.Base64;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import toothfairy1.Helpers;
import static toothfairy1.Helpers.toByteArray;
import static toothfairy1.Managers.ToothManager.GetAll;
import toothfairy1.Models.Child;
import toothfairy1.Models.ChildTable;
import toothfairy1.Models.Fairy;
import toothfairy1.Models.FairyTable;
import toothfairy1.Models.Task;
import toothfairy1.Models.Tooth;
import toothfairy1.Models.User;
import toothfairy1.Models.Users;

/**
 *
 * @author Николай
 */
public class UserManager {
    public static List<User> GetAll() throws SQLException, UnsupportedEncodingException
    {
        List<User> list = new ArrayList<User>();
                
        Factory atata = new Factory();
        List<Users> users = atata.getInstance().getUsersDAO().getAllUsers();
        for(int i = 0; i < users.size(); ++i) {
              User u1 = new User();
              u1.id = users.get(i).getId();
              u1.login = (users.get(i).getLogin());
              u1.name = Helpers.convert((users.get(i).getName()));
              u1.email = (users.get(i).getEmail());
              u1.password = (users.get(i).getPassword());
              u1.roleId = (users.get(i).getRoleId());
              u1.roleEntityId = (users.get(i).getRoleEntityId());

              /*if (users.get(i).getPhoto() != null) {
              
                 // byte [] alal;
                 // alal = toByteArray(fairies.get(i).getPhoto());
                  String a = Base64.encode(toByteArray(fairies.get(i).getPhoto()));
                  f1.photoContent = a;
              } else {
                  f1.photoContent = "";
              }*/
              
              list.add(u1);
        }

        return list;
    }
    
    public static User GetUser(String login, String password) throws SQLException, UnsupportedEncodingException
    {
        
        for (User user : GetAll()) {
          if (user.login.trim().equals(login) && user.password.trim().equals(password)) {
              return user;
          }
        }
        return null;
    }
}
