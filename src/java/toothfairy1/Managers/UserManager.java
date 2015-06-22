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
        //вот тут из базы надо брать
        /*User t1 = new User();
        t1.id = 1;
        t1.login="mf";
        t1.password="123";
        t1.roleId=2;
        t1.roleEntityId=1;

        User t2 = new User();
        t2.id = 2;
        t2.login="r";
        t2.password="123";
        t2.roleId=4;
        t2.roleEntityId=1;
        list.add(t1);
        list.add(t2);

        User t3 = new User();
        t3.id = 3;
        t3.login="sf";
        t3.password="123";
        t3.roleId=1;
        t3.roleEntityId=1;
        
        User t4 = new User();
        t4.id = 4;
        t4.login="mf2";
        t4.password="123";
        t4.roleId=2;
        t4.roleEntityId=2;
        
        User t5 = new User();
        t5.id = 5;
        t5.login="mf3";
        t5.password="123";
        t5.roleId=2;
        t5.roleEntityId=3;
        
        User t6 = new User();
        t6.id = 6;
        t6.login="mf4";
        t6.password="123";
        t6.roleId=2;
        t6.roleEntityId=4;
        
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);*/
        
        Factory atata = new Factory();
        List<Users> users = atata.getInstance().getUsersDAO().getAllUsers();
        for(int i = 0; i < users.size(); ++i) {
              User u1 = new User();
              u1.id = users.get(i).getId();
              u1.login = (users.get(i).getLogin());
              u1.name = Helpers.convert((users.get(i).getName()));
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
