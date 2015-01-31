/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.SQLException;
import java.util.List;
import toothfairy1.Models.ChildTable;

/**
 *
 * @author valya
 */
public interface ChildDAO {
    public void addChild(ChildTable child) throws SQLException; 
    public void updateChild(ChildTable child) throws SQLException;
    public ChildTable getChildById(long id) throws SQLException;    
    public List getAllChildren() throws SQLException;              
    public void deleteChild(ChildTable child) throws SQLException;
}
