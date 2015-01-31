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
import javax.servlet.http.Part;
import static toothfairy1.Helpers.convertToDB;
import toothfairy1.Managers.ChildrenManager;


/**
 *
 * @author Николай
 */
public class Tooth {
        public long id;
        public String shape;
        public String texture;
        public String defect;
        public String position;       
        public double size;
        public Date lossDate;
        public String description;    
        public String photoContent; 
        
        public double cost;
        public Boolean isValid;
        
        public long childId;
        
                
        public Tooth()
        {
 
        }
               
        public String getPhotoContent(){
            return photoContent;
        }
    
        public Child getChild() throws SQLException, UnsupportedEncodingException{
            return ChildrenManager.GetChildById(childId);
        }
         
        public long getId(){
            return id;
        }
    
        public void setId(long id){
           this.id = id;
        }
        
         public double getCost(){
            return cost;
        }
        
        public void SaveInDb() throws SQLException, UnsupportedEncodingException
        {
           
            ToothTable tooth = new ToothTable();
            tooth.setCost(cost);
            tooth.setDefect(convertToDB(defect));
            tooth.setDescription(convertToDB(description));
            tooth.setLossDate(lossDate);
            tooth.setPosition(convertToDB(position));
            tooth.setShape(convertToDB(shape));
            tooth.setSize(size);
            tooth.setTexture(convertToDB(texture));
            tooth.setChildId(childId);
  //          tooth.setPhotoContent(String.getBytes(photoContent));
          
            //Сохраним их в бд, id будут сгенерированы автоматически
            Factory.getInstance().getToothDAO().addTooth(tooth);
            id = tooth.getId();
            System.out.println("alala");
        }
        
        public void DeleteFromDb()
        {
            
        }
        
        public void Validate()
        {
            isValid = (size>0 && size < 2);
            if (isValid)
            {
                cost = size * 10;
            }
        }
       
}
