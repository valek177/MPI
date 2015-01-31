/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Managers;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import static toothfairy1.Managers.ToothManager.GetAll;
import toothfairy1.Models.Task;
import toothfairy1.Models.Tooth;
import toothfairy1.Models.User;

/**
 *
 * @author Николай
 */
public class UserManager {
    public static List<User> GetAll()
    {
        List<User> list = new ArrayList<User>();
        //вот тут из базы надо брать
        User t1 = new User();
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
        t4.id = 1;
        t4.login="mf2";
        t4.password="123";
        t4.roleId=2;
        t4.roleEntityId=2;
        
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        return list;
    }
    
    public static User GetUser(String login, String password)
    {
        
        for (User user : GetAll()) {
          if (user.login.equals(login) && user.password.equals(password)) {
              return user;
          }
        }
        return null;
    }
}
