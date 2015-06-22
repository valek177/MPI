/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Models;

import java.sql.Blob;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author Valya
 */
@Entity
@Table(name="TEETH")
@Proxy(lazy=false)
public class ToothTable {
        private long id;
        private String shape;
        private String texture;

    
        private String defect;
        private String position;       

    
        private double size;
        private Date lossDate;
        
        private String description;    
        private byte[] photoContent; 
        
        private double cost;
        
        
        private long childId;
        
                
        public ToothTable()
        {
 
        }
        @Id
        @GeneratedValue(generator="increment")
        @GenericGenerator(name="increment", strategy = "increment")
        @Column(name="ID")
        public long getId(){
            return id;
        }
    
        public void setId(long id){
           this.id = id;
        }
        @Column(name="SHAPE")
        public String getShape(){
            return shape;
        }

        public void setShape(String s){
            shape = s;
        } 
        
        @Column(name="COST")
        public double getCost(){
            return cost;
        }
        
        @Column(name="TEXTURE")
         public String getTexture() {
            return texture;
        }
         @Column(name="DEFECT")
        public String getDefect() {
            return defect;
        }
        @Column(name="POSITION")
        public String getPosition() {
            return position;
        }
        @Column(name="TSIZE")
        public double getSize() {
            return size;
        }
        @Column(name="LOSSDATE")
        public Date getLossDate() {
            return lossDate;
        }
        @Column(name="DESCRIPTION")
        public String getDescription() {
            return description;
        }
        
        @Column(name="PHOTO")
        public byte[] getPhotoContent() {
            return photoContent;
        }
        @Column(name="CHILD_ID")
        public long getChildId() {
            return childId;
        }
        
        public void setTexture(String texture) {
            this.texture = texture;
        }

        public void setDefect(String defect) {
            this.defect = defect;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public void setLossDate(Date lossDate) {
            this.lossDate = lossDate;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public void setPhotoContent(byte[] photoContent) {
            this.photoContent = photoContent;
        }
       
         public void setChildId(long childId) {
            this.childId = childId;
        }
}

