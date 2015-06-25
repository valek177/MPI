/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Models;

import DAO.Factory;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import static toothfairy1.Helpers.convertToDB;
import toothfairy1.Managers.ChildrenManager;
import toothfairy1.Managers.FairyManager;
import toothfairy1.Managers.ToothManager;

/**
 *
 * @author Николай
 */
public class Task {

    public long id;
    public long toothId;
    public long fairyId;
    public String difficulty;
    public Date deadline;
    public double probability;
    public Boolean isCompleted;
    public Boolean isSucceed;
    
    public long getId(){
        return id;
    }
    
    public void setId(long id){
       this.id = id;
    }
         
    public void setToothId(long toothId){
       this.toothId = toothId;
    }
    
    public long getToothId(){
        return toothId;
    }
    
    public Tooth getTooth() throws UnsupportedEncodingException, SQLException {
        return ToothManager.GetToothById(toothId);
    }
    
      public Fairy getFairy() throws UnsupportedEncodingException, SQLException {
        return FairyManager.GetFairyById(fairyId);
    }
    
     public void setFairyId(long toothId){
       this.toothId = toothId;
    }
     
      public String getFairyName() throws SQLException, UnsupportedEncodingException{
             try    
             {
                Fairy fairy =  FairyManager.GetFairyById(fairyId);
                if (fairy != null) return fairy.name; else return "-";
             }
             catch (Exception ex)
            {
                return "-";
            }
         }
    
    public long getFairyId(){
        return toothId;
    }
    
    public String getDifficulty(){
        return difficulty;
    }
    
    public void setDifficulty(String difficulty){
       this.difficulty = difficulty;
    }
    
    public Date getDeadline(){
        return deadline;
    }
    
    public double getProbability(){
        return probability;
    }
    
     public double getFairyMoney() throws UnsupportedEncodingException, SQLException{
        return getTooth().cost/2;
    }
     
   public void setDeadline(Date deadline){
       this.deadline = deadline;
    }
   
    public Boolean getIsCompleted(){
        return isCompleted;
    }
    
     public Boolean getIsSucceed(){
        return isSucceed;
    }
    
    public List<Task> GetTasks()
    {
        return null;
    }
    
    public void saveInDb() throws SQLException, UnsupportedEncodingException
    {
        //сохранить, записать id
         TaskTable task = new TaskTable();
         task.setDeadline(deadline);
         task.setDifficulty(convertToDB(difficulty));
         task.setFairyId(fairyId);
         task.setIsCompleted((isCompleted ? 1 : 0));
         task.setIsSucceed((isSucceed ? 1 : 0));
         task.setProbability(probability);
         task.setToothId(toothId);
          
         //Сохраним их в бд, id будут сгенерированы автоматически
         if (id == -1) {
             Factory.getInstance().getTaskDAO().addTask(task);
         } else {
             task.setId(id);
            Factory.getInstance().getTaskDAO().updateTask(task);
         }
    }
    
    public void deleteFromDb() throws SQLException, UnsupportedEncodingException
    {
         TaskTable task = Factory.getInstance().getTaskDAO().getTaskById(id);
         Factory.getInstance().getTaskDAO().deleteTask(task);
    }
    
    public void executeTask() throws SQLException, UnsupportedEncodingException
    {
        
        isCompleted = true;
        
        Random rand = new Random(); 
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        
        isSucceed = (randomNum <= 50);
        if (isSucceed)
        {
            Fairy fairy = FairyManager.GetFairyById(fairyId);
            fairy.totalMoney+=getFairyMoney();
            fairy.SaveInDb();
        }
        saveInDb();
        
    }
}
