/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toothfairy1.Models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import util.HibernateUtil;

/**
 *
 * @author Валя
 */
public class ToothTableTest {
    
    private SessionFactory sessionFactory;
    private Session session = null;

 
  @Before
 public void before() {
 
    session = HibernateUtil.getSessionFactory().openSession();
 }
 
    @Test
    public void testWriteAndReadAndDelete() {

        ToothTable actor1 = new ToothTable();
        actor1.setChildId(1);
        actor1.setCost(1000);
        actor1.setDefect("no defects");
        actor1.setDescription("Very big");
       // actor1.setLossDate(null);
        actor1.setPosition("1L");
        actor1.setShape("Square");
        actor1.setSize(1.1);
        actor1.setTexture("Wavy");
        session.beginTransaction();
        
        session.save(actor1);
        assertNotNull(actor1.getId());
        session.getTransaction().commit();

        long id = actor1.getId();
        // Read and verify
        ToothTable actor2;
        
        //check CREATE
        session.beginTransaction();
        actor2 = (ToothTable) session.load(ToothTable.class, id);
        assertEquals(actor2.getCost(), actor1.getCost());
        assertEquals(actor2.getDefect(), actor1.getDefect());
        assertEquals(actor2.getDescription(), actor1.getDescription());
        assertEquals(actor2.getId(), actor1.getId());
        session.getTransaction().commit();
        
        //check UPDATE
        actor1.setDescription("Very small");
        session.beginTransaction();
        session.save(actor1);
        session.getTransaction().commit();
        
        session.beginTransaction();
        actor2 = (ToothTable) session.load(ToothTable.class, id);
        assertEquals(actor2.getDescription(), "Very small");
        session.getTransaction().commit();
        
        //check DELETE
        session.beginTransaction();
        session.delete(actor1);
        session.getTransaction().commit();
        
        session.beginTransaction();
        actor2 = (ToothTable) session.get(ToothTable.class, id);
        assertNull(actor2);
    }
 @After
 public void after() {
     if (session != null) {
        session.close();
     }
 }
    
}
