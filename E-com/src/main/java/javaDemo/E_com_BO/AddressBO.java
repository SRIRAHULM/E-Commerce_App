package javaDemo.E_com_BO;

import javaDemo.E_com.Address;
import javaDemo.E_com_DAO.AddressDAO;

public class AddressBO {

    AddressDAO addressDAO = new AddressDAO(); 
    
    
    
    
    
    public void create(Address address) {
		 addressDAO.create(address);
	 }
}
