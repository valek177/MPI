/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Impl;

import DAO.ToothDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import toothfairy1.Models.ToothTable;
import util.HibernateUtil;

/**
 *
 * @author valya
 */
public class ToothDAOImpl implements ToothDAO {
     
    @Override
    public void addTooth(ToothTable tooth) throws SQLException {
        Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(tooth);
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
    public void updateTooth(ToothTable tooth) throws SQLException {
        Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(tooth);
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
    public ToothTable getToothById(long id) throws SQLException {
         Session session = null;
            ToothTable tooth = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                tooth = (ToothTable) session.load(ToothTable.class, id);
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                   // session.close();
                }
            }
            return tooth;
    }

    @Override
    public List getAllTeeth() throws SQLException {
        Session session = null;
            List<ToothTable> teeth = new ArrayList<ToothTable>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                teeth = session.createCriteria(ToothTable.class).list();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                 //   session.close();
                }
            }
            return teeth;
    }

    @Override
    public void deleteTooth(ToothTable tooth) throws SQLException {
         Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(tooth);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                //    session.close();
                }
            }
    }
}
