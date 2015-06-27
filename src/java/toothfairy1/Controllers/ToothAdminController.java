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
import toothfairy1.Managers.ChildrenManager;
import toothfairy1.Managers.FairyManager;
import toothfairy1.Managers.TaskManager;
import toothfairy1.Managers.ToothManager;
import toothfairy1.Models.Child;
import toothfairy1.Models.Fairy;
import toothfairy1.Models.Tooth;
import toothfairy1.Models.User;

/**
 *
 * @author Николай
 */
public class ToothAdminController {
        private String errorText;  
                
        private Boolean showSuccessAlert;
        
        public Tooth[] teethList;
                  
        public Tooth[] getToothList() throws SQLException, UnsupportedEncodingException {
            teethList = ToothManager.GetAllForParent(UserAuthController.currentUser.roleEntityId).toArray(new Tooth[0]);
            return teethList;
        }
        
        public ToothAdminController() throws SQLException, UnsupportedEncodingException
        {                  
            if (UserAuthController.currentUser.roleId==4)
            {
                teethList = getToothList();
            }
            else
            {
                teethList = null;
            }
        }
                
        public String GoBack()
        {
            return "AddTooth.jsp";
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
        
     /*   public void deleteTask() throws SQLException, UnsupportedEncodingException
    {
        Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String taskId = parameterMap.get("task");

        TaskManager.GetTaskById((long)taskId.;
    }*/
        
        /*public String getPhotoContent() {
            if (photoContent != null)
                return Base64.encode(photoContent.getBytes());
            else return "";
        }

        public void setPhotoContent(String photoContent) {
            this.photoContent = photoContent;
        }
        
        public Part getPhoto() {
            return photo;
        }

        public void setPhoto(Part photo) {
            this.photo = photo;
        }*/
               
/*      public String updateTeeth() throws SQLException, UnsupportedEncodingException
      {
          if (teethList != null && teethList.length > 0)
          {
              for (Tooth tooth : teethList)
              {
                  if (tooth.)
                  {
                      fairy.mainFairyId = currentUser.roleEntityId;
                  }
                  else
                  {
                      fairy.mainFairyId = -1;
                  }
                  fairy.SaveInDb();
              }
          }
         
          return "";
      }*/
}
