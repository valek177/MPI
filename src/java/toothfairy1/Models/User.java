/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Models;

import DAO.Factory;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import static toothfairy1.Helpers.convertToDB;

/**
 *
 * @author Николай
 */
public class User {
       public long id;
       public String login;
       public String name;

    public String getName() {
        return name;
    }
       public String password;
       public String email;
       public long roleId;
       public long roleEntityId;  

    public void saveInDb() throws SQLException, UnsupportedEncodingException
    {
        //сохранить, записать id
         Users user = new Users();
         user.setName(name);
         user.setEmail(email);
         user.setLogin(login);
         user.setPassword(password);
         user.setId(id);
         user.setRoleId(roleId);
         user.setRoleEntityId(roleEntityId);
 
          //Сохраним их в бд, id будут сгенерированы автоматически
         if (id == -1) {
             Factory.getInstance().getUsersDAO().addUser(user);
         } else {
             user.setId(id);
            Factory.getInstance().getUsersDAO().updateUser(user);
         }
    }
}
