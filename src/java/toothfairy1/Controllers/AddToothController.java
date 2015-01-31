/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Controllers;
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
 
		/*texturesList = new ToothProperty[3];
		texturesList[0] = new ToothProperty("Матовый шершавый", "1");
		texturesList[1] = new ToothProperty("Матовый гладкий", "2");
		texturesList[2] = new ToothProperty("Глянцевый", "3");*/
 
		return texturesList;
	}
        
        public String[] getDefectsList() {
 
		/*defectsList = new ToothProperty[4];
		defectsList[0] = new ToothProperty("Без дефектов", "1");
		defectsList[1] = new ToothProperty("С трещиной", "2");
		defectsList[2] = new ToothProperty("Со сколом", "3");
                defectsList[3] = new ToothProperty("Разрушенный", "4");*/
		return defectsList;
	}

        public String[] getPositionsList() {
 
		/*positionsList = new ToothProperty[10];
		positionsList[0] = new ToothProperty("1П", "1");
		positionsList[1] = new ToothProperty("2П", "2");
		positionsList[2] = new ToothProperty("3П", "3");
                positionsList[3] = new ToothProperty("4П", "4");
                positionsList[4] = new ToothProperty("5П", "5");
                positionsList[5] = new ToothProperty("1Л", "6");
		positionsList[6] = new ToothProperty("2Л", "7");
		positionsList[7] = new ToothProperty("3Л", "8");
                positionsList[8] = new ToothProperty("4Л", "9");
                positionsList[9] = new ToothProperty("5Л", "10");*/
		return positionsList;
	}
        
       public void upload() {
            try {
                 photoContent = new Scanner(photo.getInputStream()).useDelimiter("\\A").next();
            } 
            catch (Exception e) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Не удалось загрузить файл"));
            }
       }
       
       public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
                List<FacesMessage> msgs = new ArrayList<FacesMessage>();
                Part file = (Part)value;
                if (file != null)
                {
                    if (file.getSize() > 1024*1024) {
                      ctx.addMessage(null, new FacesMessage("Файл слишком велик"));
                    }
                    if (!"image/bmp".equals(file.getContentType())) {
                      ctx.addMessage(null, new FacesMessage("Файл имеет неверный формат"));
                    }
                }
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
