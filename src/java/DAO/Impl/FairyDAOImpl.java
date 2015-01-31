/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO.Impl;

/**
 *
 * @author valya
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import util.HibernateUtil;
import DAO.FairyDAO;
import org.hibernate.HibernateException;
import toothfairy1.Models.FairyTable;
/**
 *
 * @author valya
 */
public class FairyDAOImpl implements FairyDAO {
    
    @Override
    public void addFairy(FairyTable fairy) throws SQLException {
        Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(fairy);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
              //      session.close();
                }
            }
    }

    @Override
    public void updateFairy(FairyTable fairy) throws SQLException {
        Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(fairy);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
               //     session.close();
                }
            }
    }

    @Override
    public FairyTable getFairyById(Long id) throws SQLException {
         Session session = null;
            FairyTable fairy = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                fairy = (FairyTable) session.load(FairyTable.class, id);
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
              //      session.close();
                }
            }
            return fairy;
    }

    @Override
    public List getAllFairies() throws SQLException {
        Session session = null;
            List<FairyTable> fairies = new ArrayList<FairyTable>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                fairies = session.createCriteria(FairyTable.class).list();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
               //     session.close();
                }
            }
            return fairies;
    }

    @Override
    public void deleteFairy(FairyTable fairy) throws SQLException {
         Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(fairy);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
              //      session.close();
                }
            }
    }
}
