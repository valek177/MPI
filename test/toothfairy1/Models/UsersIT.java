/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toothfairy1.Models;

import DAO.Impl.UsersDAOImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Николай
 */
public class UsersIT {
    
    public UsersIT() {
    }
    
     private SessionFactory sessionFactory;
 private Session session = null;

 
  @Before
 public void before() {
  // setup the session factory
  AnnotationConfiguration configuration = new AnnotationConfiguration();
  configuration.addAnnotatedClass(Users.class);
  configuration.setProperty("hibernate.dialect",
    "org.hibernate.dialect.H2Dialect");
  configuration.setProperty("hibernate.connection.driver_class",
    "org.h2.Driver");
  configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/toothfairy");
  configuration.setProperty("hibernate.hbm2ddl.auto", "create");
 
  sessionFactory = configuration.buildSessionFactory();
  session = (Session) sessionFactory.openSession();
 }
 
 
 @Test
 public void returnUsersWithMatchingType() {
 
  // create the objects needed for testing
  
  Users hero = new Users();
  hero.setName("Hero");
  hero.setLogin("hero");
  hero.setEmail("hero@hero");
  hero.setPassword("123");
  hero.setRoleId((long)1);
  hero.setRoleEntityId((long)1);
 
  // storing the objects for the test in the database
  session.save(hero);
 session.beginTransaction();
  
  assertNotNull(hero);
 // assertEquals(1, hero.size());
 }
 
  @Test
    public void testWrite() {
        // Just a write, verify id set
        Users user = new Users();
        //Storage storage = new Storage(user);
        //storage.beginTransaction();
        //user.setRole("SuperUser");
        assertNull(user.getId());
        //storage.insert(user);
        assertNotNull(user.getId());
        //storage.commit();
    }
    
 @After
 public void after() {
  session.close();
  sessionFactory.close();
 }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Users instance = new Users();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        Long i = null;
        Users instance = new Users();
        instance.setId(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String s = "";
        Users instance = new Users();
        instance.setName(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String s = "";
        Users instance = new Users();
        instance.setEmail(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRoleId() {
        System.out.println("getRoleId");
        Users instance = new Users();
        Long expResult = null;
        Long result = instance.getRoleId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetRoleId() {
        System.out.println("setRoleId");
        Long i = null;
        Users instance = new Users();
        instance.setRoleId(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRoleEntityId() {
        System.out.println("getRoleEntityId");
        Users instance = new Users();
        Long expResult = null;
        Long result = instance.getRoleEntityId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetRoleEntityId() {
        System.out.println("setRoleEntityId");
        Long i = null;
        Users instance = new Users();
        instance.setRoleEntityId(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String s = "";
        Users instance = new Users();
        instance.setLogin(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String s = "";
        Users instance = new Users();
        instance.setPassword(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
