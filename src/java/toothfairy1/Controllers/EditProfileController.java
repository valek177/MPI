/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Controllers;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import toothfairy1.Models.Task;
import toothfairy1.Models.Tooth;
import toothfairy1.Models.User;
import toothfairy1.Models.*;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.servlet.http.*;
import java.util.Scanner;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.*;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import java.lang.Exception;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import toothfairy1.Managers.FairyManager;
import toothfairy1.Models.ToothProperty;

/**
 *
 * @author Николай
 */
public class EditProfileController {
        private String fio;
        private String email;
        private String errorText;  
        
        User currentUser;
        
        private Boolean showSuccessAlert;
        
        public Fairy[] fairyList;
    
        public Fairy[] getFairyList() throws SQLException, UnsupportedEncodingException {
            fairyList = FairyManager.GetFairysByMainFairyId(currentUser.roleEntityId).toArray(new Fairy[0]);
            return fairyList;
        }
        
        public EditProfileController() throws SQLException, UnsupportedEncodingException
        {
            currentUser = UserAuthController.currentUser;
            fio = currentUser.name;
            email = "test@test.com";
            if (currentUser.roleId==1)
            {
                fairyList = getFairyList();
            }
            else
            {
                fairyList = null;
            }
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
        
         public String getFIO() {
		return fio;
	}
 
	public void setFIO(String fio) {
		this.fio = fio;
	}
        
        public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
        
       
      public String updateProfile() throws SQLException, UnsupportedEncodingException
      {
          if (fairyList.length > 0)
          {
              for (Fairy fairy : fairyList)
              {
                  if (fairy.assignedToFairy)
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
      }
}
