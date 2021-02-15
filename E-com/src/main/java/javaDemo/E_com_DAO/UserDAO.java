package javaDemo.E_com_DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javaDemo.E_com.User;

public class UserDAO {
	
	Configuration con = new Configuration().configure();
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    
    public void create(User user) {
        
    	SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(user);
        tx.commit();
        session.close();
	}
    
    public void delete(User user) {
        
    	SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        session.close();
	}
    
    @SuppressWarnings("unchecked")
	public List<User>  list() {
    	
    	SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
    	
        List<User> stallList = new ArrayList<User>();
        stallList=(List<User>) session.createCriteria(User.class).list();
        tx.commit();
        session.close();
        return stallList;
        
    }
    
    
}
