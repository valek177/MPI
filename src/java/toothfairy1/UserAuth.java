/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toothfairy1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author valya
 */
public class UserAuth {
  
    private static String _cur_login = "111";
    private static String _cur_password = "222";
    
   public String getCurrentLogin(){
        return _cur_login;
    }

    public void setCurrentLogin(String cur_login){
        _cur_login = cur_login;
    }

    public String getCurrentPassword(){
        return _cur_password;
    }

    public void setCurrentPassword(String cur_password){
	_cur_password = cur_password;
    }
    
   
}
