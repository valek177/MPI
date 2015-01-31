/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.SQLException;
import java.util.List;
import toothfairy1.Models.ToothTable;

/**
 *
 * @author valya
 */
public interface ToothDAO {   
    public void addTooth(ToothTable fairy) throws SQLException; 
    public void updateTooth(ToothTable fairy) throws SQLException;
    public ToothTable getToothById(long id) throws SQLException;    
    public List getAllTeeth() throws SQLException;              
    public void deleteTooth(ToothTable fairy) throws SQLException;
} 

