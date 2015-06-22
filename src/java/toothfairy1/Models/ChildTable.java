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
import org.hibernate.annotations.Proxy;

/**
 *
 * @author valya
 */
@Entity
@Table(name="CHILDREN")
@Proxy(lazy=false)
public class ChildTable {
    
    private long id;
    private String name;
    private long parentId;
    private String sleepInfo;
    private byte[] photoContent;
    
    public ChildTable() {
        name = null;
    }
    
    public ChildTable(ChildTable s) {
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
    @Column(name="PARENT_ID")
    public long getParentId() {
        return parentId;
    }
    @Column(name="SLEEP_INFO")
    public String getSleepInfo() {
        return sleepInfo;
    }
    @Column(name="PHOTO")
    public byte[] getPhotoContent() {
        return photoContent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public void setSleepInfo(String sleepInfo) {
        this.sleepInfo = sleepInfo;
    }

    public void setPhotoContent(byte[] photoContent) {
        this.photoContent = photoContent;
    }
    
    
}
