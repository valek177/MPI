/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Models;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import toothfairy1.Managers.ParentManager;

/**
 *
 * @author Николай
 */
public class Child {
    public long id;
    public long parentId;
    public String name;
    public String sleepInfo;
    public String photoContent; 
    
    public Child()
    {

    }
    
    public String getPhotoContent(){
        return photoContent;
    }
    
    public void SaveInDb()
    {

    }

    public void DeleteFromDb()
    {

    }
    
    public Parent getParent() throws SQLException, UnsupportedEncodingException{
        return ParentManager.GetParentById(parentId);
    }
          
    public long getId(){
        return id;
    }
            
    public void setId(long id){
       this.id = id;
    }
    
    public void setParentId(long id){
       this.id = id;
    }
    
     public long getParentId(){
        return id;
    }
     
    public String getName(){
        return name;
    }
    
    public void setName(String name){
       this.name = name;
    }
    
    public String getSleepInfo(){
        return sleepInfo;
    }
}
