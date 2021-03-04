package javaDemo.E_com_DAO;

import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaDemo.E_com.ProductType;

public class ProductTypeDAO {
	
	Configuration con = new Configuration().configure();
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    
	
	@SuppressWarnings("unchecked")
	public List<ProductType>  list() {
    	
    	SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
    	
        List<ProductType> stallList = new ArrayList<ProductType>();
        stallList=(List<ProductType>) session.createCriteria(ProductType.class).list();
        tx.commit();
        session.close();
        return stallList;
        
    }


	public void create(ProductType productObject) {
		SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(productObject);
        tx.commit();
        session.close();
		
	}
       
	
}
