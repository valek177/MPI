/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import toothfairy1.Models.Users;

/**
 *
 * @author Николай
 */
public class UsersDAOImplIT {
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
    public void testGetUserById() throws Exception {
        System.out.println("getUserById");
        Long id = (long)6;
        UsersDAOImpl instance = new UsersDAOImpl();
        Users hero = new Users();
  hero.setName("Hero");
  hero.setLogin("hero");
  hero.setEmail("hero@hero");
  hero.setPassword("123");
  hero.setRoleId((long)1);
  hero.setRoleEntityId((long)1);
        Users result = instance.getUserById(id);
        assertEquals(hero, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
 @After
 public void after() {
  session.close();
  sessionFactory.close();
 }
 
    public UsersDAOImplIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

   /* @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        Users user = null;
        UsersDAOImpl instance = new UsersDAOImpl();
        instance.addUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        Users user = null;
        UsersDAOImpl instance = new UsersDAOImpl();
        instance.updateUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUserById() throws Exception {
        System.out.println("getUserById");
        Long id = null;
        UsersDAOImpl instance = new UsersDAOImpl();
        Users expResult = null;
        Users result = instance.getUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllUsers() throws Exception {
        System.out.println("getAllUsers");
        UsersDAOImpl instance = new UsersDAOImpl();
        List expResult = null;
        List result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteUser() throws Exception {
        System.out.println("deleteUser");
        Users user = null;
        UsersDAOImpl instance = new UsersDAOImpl();
        instance.deleteUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
