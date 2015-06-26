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
public class ChildTableTest {
    
    private SessionFactory sessionFactory;
    private Session session = null;

 
  @Before
 public void before() {
 
    session = HibernateUtil.getSessionFactory().openSession();
 }
 
    @Test
    public void testWriteAndReadAndDelete() {

        ChildTable actor1 = new ChildTable();
        actor1.setName("Valya");
        actor1.setParentId(1);
        actor1.setSleepInfo("Not bad");
        session.beginTransaction();
        
        session.save(actor1);
        assertNotNull(actor1.getId());
        session.getTransaction().commit();

        long id = actor1.getId();
        // Read and verify
        ChildTable actor2;
        
        //check CREATE
        session.beginTransaction();
        actor2 = (ChildTable) session.load(ChildTable.class, id);
        assertEquals(actor2.getName(), "Valya");
        assertEquals(actor2.getSleepInfo(), "Not bad");
        assertEquals(actor2.getId(), actor1.getId());
        session.getTransaction().commit();
        
        //check UPDATE
        actor1.setName("Nikolay");
        session.beginTransaction();
        session.save(actor1);
        session.getTransaction().commit();
        
        session.beginTransaction();
        actor2 = (ChildTable) session.load(ChildTable.class, id);
        assertEquals(actor2.getName(), "Nikolay");
        assertEquals(actor2.getSleepInfo(), "Not bad");
        assertEquals(actor2.getId(), actor1.getId());
        session.getTransaction().commit();
        
        //check DELETE
        session.beginTransaction();
        session.delete(actor1);
        session.getTransaction().commit();
        
        session.beginTransaction();
        actor2 = (ChildTable) session.get(ChildTable.class, id);
        assertNull(actor2);
    }
 @After
 public void after() {
     if (session != null) {
        session.close();
     }
 }
    
}
