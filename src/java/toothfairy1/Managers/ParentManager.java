/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Managers;

import DAO.Factory;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import toothfairy1.Helpers;
import toothfairy1.Models.Parent;
import toothfairy1.Models.ParentTable;

/**
 *
 * @author Николай
 */
public class ParentManager {
    public static List<Parent> GetAll() throws SQLException, UnsupportedEncodingException
    {
        List<Parent> list = new ArrayList<Parent>();
        //вот тут из базы надо брать
       /* Parent t1 = new Parent();
        t1.id = 1;
        t1.address="тын тын ул1";
          
        Parent t2 = new Parent();
        t2.id = 2;
        t2.address="ул2";
        */
        Factory atata = new Factory();
        List<ParentTable> parents = atata.getInstance().getParentDAO().getAllParents();
        for(int i = 0; i < parents.size(); ++i) {
           // System.out.println("1: " + Helpers.convert(parents.get(i).getName()));
              Parent f1 = new Parent();
              f1.id = parents.get(i).getId();
              f1.name = Helpers.convert(parents.get(i).getName());
              f1.address = Helpers.convert(parents.get(i).getAddress());
             
             
              list.add(f1);
        }
      //  list.add(t1);
    //    list.add(t2);
        return list;
    }
    
    public static Parent GetParentById(long id) throws SQLException, UnsupportedEncodingException
    {
        Parent f1 = new Parent();
        ParentTable parent = Factory.getInstance().getParentDAO().getParentById(id);
        f1.id = parent.getId();
        f1.name = Helpers.convert(parent.getName());
        f1.address = Helpers.convert(parent.getAddress());
        return f1;
    }
}
