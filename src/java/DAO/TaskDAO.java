/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.SQLException;
import java.util.List;
import toothfairy1.Models.TaskTable;

/**
 *
 * @author valya
 */
public interface TaskDAO {
    public void addTask(TaskTable task) throws SQLException; 
    public void updateTask(TaskTable task) throws SQLException;
    public TaskTable getTaskById(long id) throws SQLException;    
    public List getAllTasks() throws SQLException;              
    public void deleteTask(TaskTable task) throws SQLException;
} 
