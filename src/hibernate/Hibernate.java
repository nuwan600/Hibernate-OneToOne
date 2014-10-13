/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import OneToOne.HibernateUtil;
import OneToOne.Stock;
import OneToOne.StockDetail;
import java.util.Date;

/**
 *
 * @author nuwan600
 */
public class Hibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Hibernate one to one (XML mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
 
		Stock stock = new Stock();
 
		stock.setStockCode("4715");
		stock.setStockName("GENM");
 
		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("GENTING Malaysia");
		stockDetail.setCompDesc("Best resort in the world");
		stockDetail.setRemark("Nothing Special");
		stockDetail.setListedDate(new Date());
 
		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);
                createPerson(stock);
                listPerson();
    }
    
    
       private static void listPerson() {
        Transaction tx = null;
        Session session = HibernateUtil.getCurrentSession();
        try {
        tx = session.beginTransaction();
        List persons = session.createQuery(
        "select p from Stock as p").list();
        System.out.println("*** Content of the Person Table ***");
        System.out.println("*** Start ***");
        for (Iterator iter = persons.iterator(); iter.hasNext();) {
        Stock element = (Stock) iter.next();
        System.out.println(element.getStockCode());
        System.out.println(element.getStockDetail());
        System.out.println(element.getStockId());
        System.out.println(element.getStockName());
        }
        System.out.println("*** End ***");
        tx.commit();
    } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
            try {
                // Second try catch as the rollback could fail as well
                tx.rollback();
            } catch (HibernateException e1) {
                System.out.println("Error rolling back transaction");
            }
                throw e;
            }
        }
    }
    
    
    private static void deletePerson(Stock person) {
        Transaction tx = null;
        Session session = HibernateUtil.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.delete(person);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");

                }
            }
            // throw again the first exception
            throw e;
        }
    }
    
    private static void createPerson(Stock person) {
        Transaction tx = null;
        Session session = HibernateUtil.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                    // throw again the first exception
                    throw e;
            }
        }
    }
    
    private static void updatePerson(Stock person) {
Transaction tx = null;
Session session = HibernateUtil.getCurrentSession();
try {
tx = session.beginTransaction();
session.update(person);
tx.commit();
} catch (RuntimeException e) {
if (tx != null && tx.isActive()) {
try {
// Second try catch as the rollback could fail as well
tx.rollback();
} catch (HibernateException e1) {
System.out.println("Error rolling back transaction");
}
// throw again the first exception
throw e;
}
}
}
    
}
