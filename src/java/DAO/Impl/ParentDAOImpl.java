/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Impl;

import DAO.ParentDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import toothfairy1.Models.ParentTable;
import util.HibernateUtil;

/**
 *
 * @author valya
 */
public class ParentDAOImpl implements ParentDAO {
     
    @Override
    public void addParent(ParentTable parent) throws SQLException {
        Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(parent);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                   // session.close();
                }
            }
    }

    @Override
    public void updateParent(ParentTable parent) throws SQLException {
        Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(parent);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                 //   session.close();
                }
            }
    }

    @Override
    public ParentTable getParentById(long id) throws SQLException {
         Session session = null;
            ParentTable parent = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                parent = (ParentTable) session.load(ParentTable.class, id);
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                  //  session.close();
                }
            }
            return parent;
    }

    @Override
    public List getAllParents() throws SQLException {
        Session session = null;
            List<ParentTable> parents = new ArrayList<ParentTable>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                parents = session.createCriteria(ParentTable.class).list();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                //    session.close();
                }
            }
            return parents;
    }

    @Override
    public void deleteParent(ParentTable parent) throws SQLException {
         Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(parent);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                 //   session.close();
                }
            }
    }
    
}
