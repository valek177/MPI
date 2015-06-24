/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Controllers;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import toothfairy1.Managers.FairyManager;
import toothfairy1.Managers.TaskManager;
import toothfairy1.Models.Fairy;
import toothfairy1.Models.Task;
import toothfairy1.Models.ToothProperty;

/**
 *
 * @author Николай
 */
public class TaskToFairyController {
    private Fairy selectedFairy;
     
    public void setSelectedFairy(Fairy selectedFairy) {
        this.selectedFairy = selectedFairy;
    } 
    
    public TaskToFairyController() throws SQLException, UnsupportedEncodingException
    {
        selectedFairy = getFairyList()[0]; 
    }
    public Fairy getSelectedFairy() {
        return selectedFairy;
    }
    
    public Fairy[] fairyList;
    
    public Fairy[] getFairyList() throws SQLException, UnsupportedEncodingException {
 
        fairyList = FairyManager.GetAll().toArray(new Fairy[0]);
        return fairyList;
    }
   
     public void retrieveFairy() throws SQLException, UnsupportedEncodingException {
         
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String fairyId = parameterMap.get("fairyId");
        
        setSelectedFairy(FairyManager.GetFairyById((Long.valueOf(fairyId))));
    }    
     
     
    public String adminTasks() {
        return "TaksAdmin.jsp";
    }
      
    public Task[] tasksList;
      
    public Task[] getTasksList() throws UnsupportedEncodingException, SQLException {
        tasksList = TaskManager.GetAllUnassigned().toArray(new Task[0]);
        return tasksList;
    }
    
    public void assignTask() throws SQLException, UnsupportedEncodingException
    {
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String taskId = parameterMap.get("task");

        selectedFairy.AddTask((Long.valueOf(taskId)));
    } 
    
    public void unassignTask() throws SQLException, UnsupportedEncodingException
    {
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String taskId = parameterMap.get("task");

        selectedFairy.DeleteTask((Long.valueOf(taskId)));
    }
}
