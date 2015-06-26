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
public class ParentTableTest {
    
    private SessionFactory sessionFactory;
    private Session session = null;

 
  @Before
 public void before() {
 
    session = HibernateUtil.getSessionFactory().openSession();
 }
 
    @Test
    public void testWriteAndReadAndDelete() {

        ParentTable actor1 = new ParentTable();
        actor1.setName("Homer");
        actor1.setAddress("Evergreen st. 4");
        session.beginTransaction();
        
        session.save(actor1);
        assertNotNull(actor1.getId());
        session.getTransaction().commit();

        long id = actor1.getId();
        // Read and verify
        ParentTable actor2;
        
        //check CREATE
        session.beginTransaction();
        actor2 = (ParentTable) session.load(ParentTable.class, id);
        assertEquals(actor2.getName(), actor1.getName());
        assertEquals(actor2.getAddress(), actor1.getAddress());
        session.getTransaction().commit();
        
        //check UPDATE
        actor1.setName("Marge");
        session.beginTransaction();
        session.save(actor1);
        session.getTransaction().commit();
        
        session.beginTransaction();
        actor2 = (ParentTable) session.load(ParentTable.class, id);
        assertEquals(actor2.getName(), "Marge");
        session.getTransaction().commit();
        
        //check DELETE
        session.beginTransaction();
        session.delete(actor1);
        session.getTransaction().commit();
        
        session.beginTransaction();
        actor2 = (ParentTable) session.get(ParentTable.class, id);
        assertNull(actor2);
    }
 @After
 public void after() {
     if (session != null) {
        session.close();
     }
 }
    
}
