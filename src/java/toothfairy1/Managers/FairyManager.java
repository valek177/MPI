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
import toothfairy1.Helpers;
import static toothfairy1.Helpers.toByteArray;
import toothfairy1.Models.Fairy;
import toothfairy1.Models.FairyTable;

/**
 *
 * @author Николай
 */
public class FairyManager {
    
    public static List<Fairy> GetAll() throws SQLException, UnsupportedEncodingException
    {
        List<Fairy> list = new ArrayList<Fairy>();
        //вот тут из базы надо брать
      /*  Fairy f1 = new Fairy();
        f1.id = 1;
        f1.character = "Дружелюбный";
        f1.name="Фея 1";
        f1.skill="Матёрая";
        f1.totalMoney=15000;
        
        
        Fairy f2 = new Fairy();
        f2.id = 2;
        f2.character = "Замкнутый";
        f2.name="Фея 2";
        f2.skill="Неопытная";
        f2.totalMoney=0;
        f2.photoContent=f1.photoContent;
        
        */
        Factory atata = new Factory();
        List<FairyTable> fairies = atata.getInstance().getFairyDAO().getAllFairies();
        for(int i = 0; i < fairies.size(); ++i) {
           // System.out.println("1: " + Helpers.convert(fairies.get(i).getName()));
              Fairy f1 = new Fairy();
              f1.id = fairies.get(i).getId();
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
       // list.add(f1);
       // list.add(f2);
        
        return list;
    }
    
    public static Fairy GetFairyById(long id) throws SQLException, UnsupportedEncodingException
    {
        Fairy f = new Fairy();
        FairyTable fairy = Factory.getInstance().getFairyDAO().getFairyById(id);
        f.id = id;
        f.name = Helpers.convert(fairy.getName());
        f.skill = Helpers.convert(fairy.getSkill());
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
}
