/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toothfairy1.Models;

import java.sql.Date;
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
@Table(name="TASKS")
public class TaskTable {
    private long id;
    private long toothId;
    private long fairyId;
    private String difficulty;
    private Date deadline;
    private double probability;
    private int isCompleted;
    private int isSucceed;

    @Id
        @GeneratedValue(generator="increment")
        @GenericGenerator(name="increment", strategy = "increment")
        @Column(name="ID")
    public long getId() {
        return id;
    }
@Column(name="TOOTH_ID")
    public long getToothId() {
        return toothId;
    }
@Column(name="FAIRY_ID")
    public long getFairyId() {
        return fairyId;
    }
@Column(name="DIFFICULTY")
    public String getDifficulty() {
        return difficulty;
    }
@Column(name="DEAD_LINE")
    public Date getDeadline() {
        return deadline;
    }
@Column(name="PROBABILITY")
    public double getProbability() {
        return probability;
    }
@Column(name="IS_COMPLETED")
    public int getIsCompleted() {
        return isCompleted;
    }
@Column(name="IS_SUCCEED")
    public int getIsSucceed() {
        return isSucceed;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setToothId(long toothId) {
        this.toothId = toothId;
    }

    public void setFairyId(long fairyId) {
        this.fairyId = fairyId;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setIsSucceed(int isSucceed) {
        this.isSucceed = isSucceed;
    }
    
    
}
