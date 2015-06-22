/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toothfairy1.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;


/**
 *
 * @author valya
 */
@Entity
@Table(name="USERS")
@Proxy(lazy=false)
public class Users {
    private Long ID;
    private Long ROLE_ID;
    private String NAME;
    private String LOGIN;
    private String PASSWORD;
    private Long ROLE_ENTITY_ID;
    
    public Users() {
        NAME = null;
    }
    
    public Users(Users s) {
        NAME = s.getName();
    }
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="ID")
    public Long getId() {
        return ID;
    }
    
    public void setId(Long i){
        ID = i;    
    }
   
    @Column(name="NAME")
    public String getName(){
        return NAME;
    }
  
    public void setName(String s){
        NAME = s;
    } 
    
    @Column(name="ROLE_ID")
    public Long getRoleId(){
        return ROLE_ID;
    }
  
    public void setRoleId(Long i){
        ROLE_ID = i;
    }  
    
    
    @Column(name="ROLE_ENTITY_ID")
    public Long getRoleEntityId(){
        return ROLE_ENTITY_ID;
    }
  
    public void setRoleEntityId(Long i){
        ROLE_ENTITY_ID = i;
    }  
   
    @Column(name="LOGIN")
    public String getLogin(){
        return LOGIN;
    }
  
    public void setLogin(String s){
        LOGIN = s;
    }
    
    @Column(name="PASSWORD")
    public String getPassword(){
        return PASSWORD;
    }
  
    public void setPassword(String s){
        PASSWORD = s;
    } 
}
