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
import toothfairy1.Managers.TaskManager;

/**
 *
 * @author Николай
 */
public class Fairy {
    public long id;
    public String name;
    public String character;
    public String skill;
    public int totalMoney;
    public String photoContent; 
    
    public Fairy()
    {

    }
    
    public String getPhotoContent(){
        return photoContent;
    }
    
    public void SaveInDb() throws SQLException, UnsupportedEncodingException
    {
        FairyTable f = new FairyTable();
        f.setId(id);
        f.setName(convertToDB(name));
        f.setSkill(convertToDB(skill));
        f.setFCharacter(convertToDB(character));
        f.setTotalMoney(totalMoney);
          
        Factory.getInstance().getFairyDAO().updateFairy(f);
         
    }

    public void DeleteFromDb()
    {

    }
          
    public long getId(){
        return id;
    }
    
    public void setId(long id){
       this.id = id;
    }
     
    public String getName(){
        return name;
    }
    
    public void setName(String name){
       this.name = name;
    }
    
    public String getСharacter(){
        return character;
    }
     
    public String getSkill(){
        return skill;
    }
    
    public int getTotalMoney(){
        return totalMoney;
    }
        
    public List<Task> getTasks() throws UnsupportedEncodingException, SQLException
    {
        return TaskManager.GetTasksForFairy(id);
    }
    
    public void AddTask(long taskId) throws SQLException, UnsupportedEncodingException
    {
        Task task = TaskManager.GetTaskById(taskId);
        task.fairyId = id;
       // task.id = taskId;
        task.saveInDb();
    }
    
    public void DeleteTask(long taskId) throws SQLException, UnsupportedEncodingException
    {
        Task task = TaskManager.GetTaskById(taskId);
        task.fairyId = 0;
        task.saveInDb();
    }
}
