/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toothfairy1.Models;

import java.sql.Date;
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
public class TaskTableTest {
    
    private SessionFactory sessionFactory;
    private Session session = null;

 
  @Before
 public void before() {
 
    session = HibernateUtil.getSessionFactory().openSession();
 }
 
    @Test
    public void testWriteAndReadAndDelete() {

        TaskTable actor1 = new TaskTable();
        actor1.setFairyId(1);
        actor1.setDifficulty("Very difficult");
        actor1.setIsCompleted(0);
        actor1.setIsSucceed(0);
        actor1.setProbability(70);
        actor1.setToothId(1);
        actor1.setDeadline(new Date(new java.util.Date().getTime()));
        session.beginTransaction();
        
        session.save(actor1);
        assertNotNull(actor1.getId());
        session.getTransaction().commit();

        long id = actor1.getId();
        // Read and verify
        TaskTable actor2;
        
        //check CREATE
        session.beginTransaction();
        actor2 = (TaskTable) session.load(TaskTable.class, id);
        assertEquals(actor2.getFairyId(), actor1.getFairyId());
        assertEquals(actor2.getDifficulty(), actor1.getDifficulty());
        assertEquals(actor2.getId(), actor1.getId());
        session.getTransaction().commit();
        
        //check UPDATE
        actor1.setDifficulty("Not so difficulty");
        session.beginTransaction();
        session.save(actor1);
        session.getTransaction().commit();
        
        session.beginTransaction();
        actor2 = (TaskTable) session.load(TaskTable.class, id);
        assertEquals(actor2.getDifficulty(), "Not so difficulty");
        session.getTransaction().commit();
        
        //check DELETE
        session.beginTransaction();
        session.delete(actor1);
        session.getTransaction().commit();
        
        session.beginTransaction();
        actor2 = (TaskTable) session.get(TaskTable.class, id);
        assertNull(actor2);
    }
 @After
 public void after() {
     if (session != null) {
        session.close();
     }
 }
    
}
