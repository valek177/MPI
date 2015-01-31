/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.SQLException;
import java.util.List;
import toothfairy1.Models.FairyTable;

/**
 *
 * @author valya
 */
public interface FairyDAO {   
    public void addFairy(FairyTable fairy) throws SQLException; 
    public void updateFairy(FairyTable fairy) throws SQLException;
    public FairyTable getFairyById(Long id) throws SQLException;    
    public List getAllFairies() throws SQLException;              
    public void deleteFairy(FairyTable fairy) throws SQLException;
} 
