/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Managers;

import DAO.Factory;
import com.sun.xml.wss.impl.misc.Base64;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import toothfairy1.Helpers;
import static toothfairy1.Helpers.toByteArray;
import static toothfairy1.Managers.UserManager.GetAll;
import toothfairy1.Models.Fairy;
import toothfairy1.Models.FairyTable;
import toothfairy1.Models.User;

/**
 *
 * @author Николай
 */
public class FairyManager {
    
    public static List<Fairy> GetAll() throws SQLException, UnsupportedEncodingException
    {
        List<Fairy> list = new ArrayList<Fairy>();
        Factory atata = new Factory();
        List<FairyTable> fairies = atata.getInstance().getFairyDAO().getAllFairies();
        for(int i = 0; i < fairies.size(); ++i) {
           // System.out.println("1: " + Helpers.convert(fairies.get(i).getName()));
              Fairy f1 = new Fairy();
              f1.id = fairies.get(i).getId();
              f1.mainFairyId = fairies.get(i).getMainFairyId();
              f1.assignedToFairy =  (f1.mainFairyId > 0);
              f1.name = Helpers.convert(fairies.get(i).getName());
              f1.skill = Helpers.convert(fairies.get(i).getSkill());
              f1.character = Helpers.convert(fairies.get(i).getFCharacter());
              f1.totalMoney = fairies.get(i).getTotalMoney();
              if (fairies.get(i).getPhoto() != null) {
              
                 // byte [] alal;
                 // alal = toByteArray(fairies.get(i).getPhoto());
                  String a = Base64.encode(toByteArray(fairies.get(i).getPhoto()));
                  f1.photoContent = a;
              } else {
                  f1.photoContent = "";
              }
              
              list.add(f1);
        }
       
        return list;
    }
    
    public static Fairy GetFairyById(long id) throws SQLException, UnsupportedEncodingException
    {
        Fairy f = new Fairy();
        FairyTable fairy = Factory.getInstance().getFairyDAO().getFairyById(id);
        f.id = id;
        f.name = Helpers.convert(fairy.getName());
        f.skill = Helpers.convert(fairy.getSkill());
        f.mainFairyId = fairy.getMainFairyId();
        f.assignedToFairy =  (f.mainFairyId > 0);
        f.character = Helpers.convert(fairy.getFCharacter());
        f.totalMoney = fairy.getTotalMoney();
        if (fairy.getPhoto() != null) {
              
                 // byte [] alal;
                 // alal = toByteArray(fairies.get(i).getPhoto());
                  String a = Base64.encode(toByteArray(fairy.getPhoto()));
                  f.photoContent = a;
              } else {
                  f.photoContent = "";
              }
        return f;
    }
    
    public static List<Fairy> GetFairysByMainFairyId(long id, Boolean addUnassigned) throws SQLException, UnsupportedEncodingException
    {
       List<Fairy> list = new ArrayList<Fairy>();
        Factory atata = new Factory();
        List<FairyTable> fairies = atata.getInstance().getFairyDAO().getAllFairies();
        for(int i = 0; i < fairies.size(); ++i) {
            if (fairies.get(i).getMainFairyId() == id || (fairies.get(i).getMainFairyId() < 0 && addUnassigned))
            {
              Fairy f1 = new Fairy();
              f1.id = fairies.get(i).getId();
              f1.mainFairyId = fairies.get(i).getMainFairyId();
              f1.assignedToFairy =  (f1.mainFairyId > 0);
              f1.name = Helpers.convert(fairies.get(i).getName());
              f1.skill = Helpers.convert(fairies.get(i).getSkill());
              f1.character = Helpers.convert(fairies.get(i).getFCharacter());
              f1.totalMoney = fairies.get(i).getTotalMoney();
              if (fairies.get(i).getPhoto() != null) {
                                String a = Base64.encode(toByteArray(fairies.get(i).getPhoto()));
                  f1.photoContent = a;
              } else {
                  f1.photoContent = "";
              }
              
              list.add(f1);
            }
        }
        
        return list;
         
    }
}
