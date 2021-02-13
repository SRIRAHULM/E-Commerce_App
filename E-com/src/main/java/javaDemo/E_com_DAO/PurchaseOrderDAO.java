package javaDemo.E_com_DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaDemo.E_com.PurchaseOrder;

public class PurchaseOrderDAO {
	Configuration con = new Configuration().configure();
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    
    public void update(PurchaseOrder pO) {
        
    	SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(pO);
        tx.commit();
        session.close();  
	}
    
    
    
}
