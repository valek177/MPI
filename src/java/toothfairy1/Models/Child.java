/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Models;

import DAO.Factory;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import static toothfairy1.Helpers.convertToDB;
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
    public boolean assignedToParent;
    
    public Child()
    {

    }
    
    public String getPhotoContent(){
        return photoContent;
    }
    
    public void SaveInDb() throws SQLException, UnsupportedEncodingException
    {
        ChildTable ch = new ChildTable();
        ch.setId(id);
        ch.setName(convertToDB(name));
        ch.setParentId(parentId);
        ch.setSleepInfo(convertToDB(sleepInfo));
        if (photoContent != null) ch.setPhotoContent(photoContent.getBytes());
        ch.setSleepInfo(convertToDB(sleepInfo));
        if (!assignedToParent) ch.setParentId((long)-1);
        Factory.getInstance().getChildDAO().updateChild(ch);
    }
    
    public boolean getAssignedToParent(){
        return assignedToParent;
    }
    
    public void setAssignedToParent(boolean assignedToParent){
       this.assignedToParent = assignedToParent;
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
    
    public void setSleepInfo(String slinfo){
        this.sleepInfo = slinfo;
    }
}
