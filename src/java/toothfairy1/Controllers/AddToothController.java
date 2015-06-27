/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Controllers;
import toothfairy1.Models.*;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.IOException;
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
import static toothfairy1.Controllers.UserAuthController.currentUser;
import toothfairy1.Models.ToothProperty;

/**
 *
 * @author Николай
 */
public class AddToothController {
    
	private String selectedShape;
        private String selectedTexture;
        private String selectedDefect;
        private String selectedPosition;       
        private double size;
        private Date lossDate;
        private String description;    
        private Part photo; 
        private String photoContent; 
        private String errorText; 
        private double cost;
        
        private Boolean showSuccessAlert;
        
        public AddToothController()
        {
            lossDate = new java.sql.Date(new java.util.Date().getTime());
            size = 1.5;
            isValid = false;
            firstUpload = true;
        }
        
        public String unAuthorize() {
          currentUser = null;
          return "main.jsp";
        }
        
        public String adminTooth() {
          return "ToothAdmin.jsp";
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
        
         public String getPhotoContent() {
            if (photoContent != null)
                return new String(photoContent.getBytes());
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
        }
        
         public String getDescription() {
		return description;
	}
 
	public void setDescription(String description) {
		this.description = description;
	}
        
        public Date getLossDate() {
		return lossDate;
	}
 
	public void setLossDate(Date lossDate) {
		this.lossDate = lossDate;
	}
        
        public double getSize() {
		return size;
	}
 
	public void setSize(double size) {
		this.size = size;
	}
        
        public String getSelectedTexture() {
		return selectedTexture;
	}
 
	public void setSelectedTexture(String selectedTexture) {
		this.selectedTexture = selectedTexture;
	}
        
        public String getSelectedDefect() {
		return selectedDefect;
	}
 
	public void setSelectedDefect(String selectedDefect) {
		this.selectedDefect = selectedDefect;
	}
        
        public String getSelectedShape() {
		return selectedShape;
	}
 
	public void setSelectedShape(String selectedShape) {
		this.selectedShape = selectedShape;
	}
        
        public String getSelectedPosition() {
		return selectedPosition;
	}
 
	public void setSelectedPosition(String selectedPosition) {
		this.selectedPosition = selectedPosition;
	}
         
	public String[] shapesList;
        public String[] texturesList;
        public String[] defectsList;
        public String[] positionsList;
 
	public String[] getShapesList() {
		return shapesList;
	}
        
        public String[] getTexturesList() {
		return texturesList;
	}
        
        public String[] getDefectsList() {
		return defectsList;
	}

        public String[] getPositionsList() {
		return positionsList;
	}
        
        Boolean isValid;
        
        Boolean firstUpload;
        
       public void upload() {
            try {
                               
                 if (photo != null && photo.getInputStream() != null)
                 {
                    isValid = true;
              
                   
                    if (photo.getSize() > 1024*1024) {
                       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Файл слишком велик"));
                      isValid = false;
                    }
                    if (!"image/bmp".equals(photo.getContentType())) {
                      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Файл имеет формат, отличный от .bmp"));
                      isValid = false;
                    }
                    
  
                    if (isValid)
                    {
                        photoContent = (Base64.encode(new Scanner(photo.getInputStream()).useDelimiter("\\A").next().getBytes()));
                    }
                 }
                 else
                 {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Файл не задан"));
                 }
            } 
            catch (Exception e) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Не удалось загрузить файл"));
            }

       }
       
       public void validateFile(FacesContext ctx, UIComponent comp, Object value) throws IOException
       { 
               /* isValid = true;
                Part file = (Part)value;
                if (file != null)
                {
                    if (file.getSize() > 1024*1024) {
                      ctx.addMessage(null, new FacesMessage("Файл слишком велик"));
                      isValid = false;
                    }
                    if (!"image/bmp".equals(file.getContentType())) {
                      ctx.addMessage(null, new FacesMessage("Файл имеет формат, отличный от .bmp"));
                      isValid = false;
                    }
                }
                else   
                {
                    isValid = false;
                }
                if (!isValid) { if (photo != null) photo.delete(); }*/
      }   
       
      public String addTooth() throws SQLException, UnsupportedEncodingException
      {
          Tooth newTooth = new Tooth();
          
          newTooth.shape=selectedShape;
          newTooth.defect=selectedDefect;
          newTooth.lossDate = new java.sql.Date(lossDate.getTime());
          newTooth.size = size;
          newTooth.photoContent = photoContent;
          newTooth.childId=1;
          newTooth.position = selectedPosition;
          newTooth.texture = selectedTexture;
          newTooth.description = description;
          newTooth.cost = 123;
          
          newTooth.Validate();
          if (newTooth.isValid)
          {
                newTooth.SaveInDb();

                Task task = new Task();
                task.toothId = newTooth.getId();
                task.deadline = new java.sql.Date(newTooth.lossDate.getTime() + 1 * 24 * 60 * 60 * 1000 * 10);
                task.difficulty="Сложно";
                task.probability = 0.5;
                task.isCompleted = false;
                task.isSucceed = false;
                task.id = -1; // just flag
                task.saveInDb();

                showSuccessAlert = true;
                return "TeethSuccess.jsp";

          }
          else
          {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Зуб не настоящий"));
          }
          return "";
      }
}
