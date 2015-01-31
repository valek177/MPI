/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toothfairy1.Models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author valya
 */
@Entity
@Table(name="PARENT")
public class ParentTable {
    
    private long id;
    private String name;
    private String address;
    
    public ParentTable() {
        name = null;
    }
    
    public ParentTable(ParentTable s) {
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
    
    public void setId(long i){
        id = i;    
    }
    
    @Column(name="NAME")
    public String getName() {
        return name;
    }
    @Column(name="ADDRESS")
    public String getAddress() {
        return address;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
