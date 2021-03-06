package javaDemo.E_com_DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaDemo.E_com.Address;
import javaDemo.E_com.User;

public class AddressDAO {
	Configuration con = new Configuration().configure();
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    
    public void create(Address address) {
        
    	SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(address);
        tx.commit();
        session.close();
	}
    

}
