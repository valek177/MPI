/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.SQLException;
import java.util.List;
import toothfairy1.Models.ParentTable;

/**
 *
 * @author valyap
 */
public interface ParentDAO {
    public void addParent(ParentTable parent) throws SQLException; 
    public void updateParent(ParentTable parent) throws SQLException;
    public ParentTable getParentById(long id) throws SQLException;    
    public List getAllParents() throws SQLException;              
    public void deleteParent(ParentTable parent) throws SQLException;
}
