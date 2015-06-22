/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Impl;

import DAO.ChildDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import toothfairy1.Models.ChildTable;
import util.HibernateUtil;

/**
 *
 * @author valya
 */
public class ChildDAOImpl implements ChildDAO {
     
    @Override
    public void addChild(ChildTable child) throws SQLException {
        Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(child);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                   session.close();
                }
            }
    }

    @Override
    public void updateChild(ChildTable child) throws SQLException {
        Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(child);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                   session.close();
                }
            }
    }

    @Override
    public ChildTable getChildById(long id) throws SQLException {
         Session session = null;
            ChildTable child = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                child = (ChildTable) session.load(ChildTable.class, id);
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return child;
    }

    @Override
    public List getAllChildren() throws SQLException {
        Session session = null;
            List<ChildTable> children = new ArrayList<ChildTable>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                children = session.createCriteria(ChildTable.class).list();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return children;
    }

    @Override
    public void deleteChild(ChildTable child) throws SQLException {
         Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(child);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
    }
    
}
