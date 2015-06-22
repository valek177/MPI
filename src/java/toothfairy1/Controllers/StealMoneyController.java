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
public class StealMoneyController {
    private Fairy currentFairy;
    private Boolean isListView;
    private Task selectedTask;
    
    public StealMoneyController() throws SQLException, UnsupportedEncodingException
    {
        currentFairy = FairyManager.GetFairyById(UserAuthController.currentUser.roleEntityId);
        isListView = true;
    }
    public Fairy getCurrentFairy() {
        return currentFairy;
    }
    
     public Task getSelectedTask() {
        return selectedTask;
    }
    
    public Boolean getIsListView() {
        if (selectedTask == null)
            return isListView;
        else
            return isListView || selectedTask.isCompleted;
    }
    
    public int getTaskCount()
    {
        if (tasksList != null)
        return tasksList.length-1;
        return 0;
    }
    
    public Task[] tasksList;
      
    public Task[] getTasksList() throws UnsupportedEncodingException, SQLException {
        tasksList = TaskManager.GetTasksForFairy(currentFairy.id).toArray(new Task[0]);
        return tasksList;
    }
    
    public void selectTask() throws SQLException, UnsupportedEncodingException
    {
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String taskId = parameterMap.get("task");
        selectedTask = TaskManager.GetTaskById(Long.valueOf(taskId));
        isListView = false;
    }
    
    public void returnToList()
    {
        selectedTask = null;
        isListView = true;
    }
}
