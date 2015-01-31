/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Models;

/**
 *
 * @author Николай
 */
public class Parent {
    public long id;
    public String name;
    public String address;
    
    public Parent()
    {

    }
    
    public void SaveInDb()
    {

    }

    public void DeleteFromDb()
    {

    }
          
    public long getId(){
        return id;
    }
            
    public void setId(long id){
       this.id = id;
    }
      
    public String getName(){
        return name;
    }
    
    public void setName(String name){
       this.name = name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
       this.address = address;
    }
    
}
