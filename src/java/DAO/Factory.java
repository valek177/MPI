/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DAO.Impl.ChildDAOImpl;
import DAO.Impl.UsersDAOImpl;
import DAO.Impl.FairyDAOImpl;
import DAO.Impl.ParentDAOImpl;
import DAO.Impl.TaskDAOImpl;
import DAO.Impl.ToothDAOImpl;

public class Factory {
     
      private static UsersDAO userDAO = null;
      private static Factory instance = null;

      public static synchronized Factory getInstance(){
            if (instance == null){
              instance = new Factory();
            }
            return instance;
      }

      public UsersDAO getUsersDAO(){
            if (userDAO == null){
              userDAO = new UsersDAOImpl();
            }
            return userDAO;
      }  
      
      private static FairyDAO fairyDAO = null;

      public FairyDAO getFairyDAO(){
            if (fairyDAO == null){
              fairyDAO = new FairyDAOImpl();
            }
            return fairyDAO;
      }  
      
      private static ToothDAO toothDAO = null;

      public ToothDAO getToothDAO(){
            if (toothDAO == null){
              toothDAO = new ToothDAOImpl();
            }
            return toothDAO;
      }  
      
      private static TaskDAO taskDAO = null;

      public TaskDAO getTaskDAO(){
            if (taskDAO == null){
              taskDAO = new TaskDAOImpl();
            }
            return taskDAO;
      }  
      
      private static ChildDAO childDAO = null;

      public ChildDAO getChildDAO(){
            if (childDAO == null){
              childDAO = new ChildDAOImpl();
            }
            return childDAO;
      }  
      
      private static ParentDAO parentDAO = null;

      public ParentDAO getParentDAO(){
            if (parentDAO == null){
              parentDAO = new ParentDAOImpl();
            }
            return parentDAO;
      }  
}