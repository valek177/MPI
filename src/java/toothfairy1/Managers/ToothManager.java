/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Managers;

import DAO.Factory;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import toothfairy1.Helpers;
import static toothfairy1.Managers.TaskManager.GetAllActual;
import toothfairy1.Models.Task;
import toothfairy1.Models.Tooth;
import toothfairy1.Models.ToothTable;

/**
 *
 * @author Николай
 */
public class ToothManager {
    public static List<Tooth> GetAll() throws SQLException, UnsupportedEncodingException
    {
        List<Tooth> list = new ArrayList<Tooth>();

        Factory atata = new Factory();
        List<ToothTable> teeth = atata.getInstance().getToothDAO().getAllTeeth();
        for(int i = 0; i < teeth.size(); ++i) {
           // System.out.println("1: " + Helpers.convert(teeth.get(i).getName()));
              Tooth t = new Tooth();
              t.id = teeth.get(i).getId();
              t.childId = teeth.get(i).getChildId();
              t.defect = Helpers.convert(teeth.get(i).getDefect());
              t.description = Helpers.convert(teeth.get(i).getDescription());
              t.position = Helpers.convert(teeth.get(i).getPosition());
              t.shape = Helpers.convert(teeth.get(i).getShape());
              t.texture = Helpers.convert(teeth.get(i).getTexture());
              t.lossDate = teeth.get(i).getLossDate();
              t.cost = teeth.get(i).getCost();
              if (teeth.get(i).getPhotoContent() != null)
              t.photoContent = "data:image/jpg;base64,"+new String(teeth.get(i).getPhotoContent());
              list.add(t);
        }
        
        return list;
    }
    
    public static void GetToothForChild(String childrId)
    {
        
    }
    
    public static Tooth GetToothById(long id) throws SQLException, UnsupportedEncodingException
    {
         Tooth t = new Tooth();
        ToothTable tooth = Factory.getInstance().getToothDAO().getToothById(id);
        t.id = tooth.getId();
        t.description = Helpers.convert(tooth.getDescription());
        t.defect = Helpers.convert(tooth.getDefect());
        t.position = Helpers.convert(tooth.getPosition());
        t.shape = Helpers.convert(tooth.getShape());
        t.texture = Helpers.convert(tooth.getTexture());
        t.lossDate = tooth.getLossDate();
        t.cost = tooth.getCost();
        t.size = tooth.getSize();
        t.childId = tooth.getChildId();
        if (tooth.getPhotoContent() != null)
        t.photoContent = "data:image/jpg;base64,"+new String(tooth.getPhotoContent());
        return t;
    }
    
    public static List<Tooth> GetAllForParent(long parentId) throws SQLException, UnsupportedEncodingException
    {
        List<Tooth> list = new ArrayList<Tooth>();

        Factory atata = new Factory();
        List<ToothTable> teeth = atata.getInstance().getToothDAO().getAllTeeth();
        for(int i = 0; i < teeth.size(); ++i) {
           // System.out.println("1: " + Helpers.convert(teeth.get(i).getName()));
              Tooth t = new Tooth();
              t.id = teeth.get(i).getId();
              t.childId = teeth.get(i).getChildId();
              t.defect = Helpers.convert(teeth.get(i).getDefect());
              t.description = Helpers.convert(teeth.get(i).getDescription());
              t.position = Helpers.convert(teeth.get(i).getPosition());
              t.shape = Helpers.convert(teeth.get(i).getShape());
              t.texture = Helpers.convert(teeth.get(i).getTexture());
              t.lossDate = teeth.get(i).getLossDate();
              t.cost = teeth.get(i).getCost();
              if (teeth.get(i).getPhotoContent() != null)
              t.photoContent = "data:image/jpg;base64,"+new String(teeth.get(i).getPhotoContent());
              list.add(t);
        }
        
        return list;
    }
}
