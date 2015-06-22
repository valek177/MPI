/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Models;

import java.sql.Blob;
import java.util.List;
import java.util.UUID;

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
 * @author Николай &   valya
 */

@Entity
@Table(name="ASS_FAIRIES")
@Proxy(lazy=false)
public class FairyTable {
    
    private Long id;
    private String name;
    private String character;
    private String skill;
    private int totalMoney;
    private Long mainFairyId;
   
    
    public FairyTable() {
        name = null;
    }
    
    public FairyTable(FairyTable s) {
        name = s.getName();
    }
    // for Hibernate
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="ID")
    public Long getId() {
        return id;
    }
    
    public void setId(Long i){
        id = i;    
    }
    @Column(name="NAME")
    public String getName(){
        return name;
    }
  
    public void setName(String s){
        name = s;
    } 
    @Column(name="CHARACTER")
    public String getFCharacter(){
        return character;
    }
  
    public void setFCharacter(String s){
        character = s;
    }
    
    @Column(name="SKILL")
    public String getSkill(){
        return skill;
    }
  
    public void setSkill(String s){
        skill = s;
    }
    @Column(name="TOTAL_MONEY")
    public int getTotalMoney() {
        return totalMoney;
    }
    
    public void setTotalMoney(int i){
        totalMoney = i;    
    }
    
    @Column(name="PHOTO")
    @Lob
    private Blob photoContent;
    public Blob getPhoto() {
        return photoContent;
    }
    
    public void setPhoto(Blob photo){
        photoContent = photo;    
    }
    
    @Column(name="MAIN_FAIRY_ID")
    public Long getMainFairyId(){
        return mainFairyId;
    }
  
    public void setMainFairyId(Long s){
        mainFairyId = s;
    }
    //
    
}
