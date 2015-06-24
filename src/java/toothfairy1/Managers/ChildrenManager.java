/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Managers;

import DAO.Factory;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import toothfairy1.Helpers;
import toothfairy1.Models.Child;
import toothfairy1.Models.Child;
import toothfairy1.Models.ChildTable;
import toothfairy1.Models.Task;

/**
 *
 * @author Николай
 */
public class ChildrenManager {
    public static List<Child> GetAll() throws SQLException, UnsupportedEncodingException
    {
        List<Child> list = new ArrayList<Child>();
                
        Factory atata = new Factory();
        List<ChildTable> children = atata.getInstance().getChildDAO().getAllChildren();
        for(int i = 0; i < children.size(); ++i) {
           // System.out.println("1: " + Helpers.convert(children.get(i).getName()));
              Child f1 = new Child();
              f1.id = children.get(i).getId();
              f1.name = Helpers.convert(children.get(i).getName());
              f1.parentId = children.get(i).getParentId();
              f1.assignedToParent =  (f1.parentId > 0);
              f1.sleepInfo = Helpers.convert(children.get(i).getSleepInfo());
             
              list.add(f1);
        }
        return list;
    }
    
    public static Child GetChildById(long id) throws SQLException, UnsupportedEncodingException
    {
        Child f1 = new Child();
        ChildTable children = Factory.getInstance().getChildDAO().getChildById(id);
        f1.id = children.getId();
        f1.name = Helpers.convert(children.getName());
        f1.parentId = children.getParentId();
        f1.assignedToParent =  (f1.parentId > 0);
        f1.sleepInfo = Helpers.convert(children.getSleepInfo());
        return f1;
    }
    
    public static List<Child> GetAllForParent(long parentId, Boolean addUnassigned) throws SQLException, UnsupportedEncodingException
    {
        List<Child> list = new ArrayList<Child>();
                
        Factory atata = new Factory();
        List<ChildTable> children = atata.getInstance().getChildDAO().getAllChildren();
        for(int i = 0; i < children.size(); ++i) {
             if (children.get(i).getParentId() == parentId || (children.get(i).getParentId() < 0 && addUnassigned))
             {
              Child f1 = new Child();
              f1.id = children.get(i).getId();
              f1.name = Helpers.convert(children.get(i).getName());
              f1.parentId = children.get(i).getParentId();
              f1.assignedToParent =  (f1.parentId > 0);
              f1.sleepInfo = Helpers.convert(children.get(i).getSleepInfo());
             
              list.add(f1);
             }
        }

        return list;
    }
}
