/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Controllers;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import toothfairy1.Managers.TaskManager;
import toothfairy1.Managers.ToothManager;
import toothfairy1.Models.Task;
import toothfairy1.Models.Tooth;

/**
 *
 * @author Николай
 */
public class TaskAdminController {
    private String errorText;  
                
        private Boolean showSuccessAlert;
        
        public Task[] taskList;
                  
        public Task[] getTaskList() throws SQLException, UnsupportedEncodingException {
            taskList = TaskManager.GetAllActual().toArray(new Task[0]);
            return taskList;
        }
        
        public TaskAdminController() throws SQLException, UnsupportedEncodingException
        {
      
            if (UserAuthController.currentUser.roleId==1)
            {
                taskList = getTaskList();
            }
            else
            {
                taskList = null;
            }
        }
        
        public String GoBack()
        {
            return "TaskToFairy.jsp";
        }
        
        public Boolean getShowSuccessAlert() {
            return showSuccessAlert;
        }
        
        public String getErrorText() {
            return errorText;
        }

        public void setErrorText(String errorText) {
            this.errorText = errorText;
        }
}
