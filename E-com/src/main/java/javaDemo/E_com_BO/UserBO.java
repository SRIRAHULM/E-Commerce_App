package javaDemo.E_com_BO;

import java.util.List;

import javaDemo.E_com.User;
import javaDemo.E_com_DAO.UserDAO;
import javaDemo.E_com_EXCEPTION.DuplicateUserNameException;

public class UserBO {
	UserDAO userDAO = new UserDAO();
	AddressBO addressBO = new AddressBO();
	
	
	public Boolean checkUserROll(String newRoll) {
		
		Boolean findUserRoll =false;
		
		if(newRoll.equalsIgnoreCase("ADMIN") || newRoll.equalsIgnoreCase("CUSTOMER")) {
			findUserRoll = true;
		}
		return findUserRoll;
	}
	
	public Boolean noValueFound(String inputValue) {
		
		Boolean findUserRoll =false;
		
		inputValue = inputValue.trim();
		if(inputValue.length()==0) {
			findUserRoll =  true;
		}
		
		return findUserRoll;
	}
	
	 public String findUser(String userName, String password) {
		 
		 List<User> userList= userDAO.list();
	     String value = null;
	     for(int i=0; i<userList.size();i++) {
	        if((userName.equals(userList.get(i).getUserName())) && (password.equals(userList.get(i).getPassword()))) {
	        	value =  userList.get(i).getRole();
	        }
	     }
		return value;
	 }
	 
	 
	 public void create(User user) throws DuplicateUserNameException  {
		 	
		 	try {
				userDAO.create(user);	
			}
			catch (Exception e) {
					
				 throw new DuplicateUserNameException("User Name Already EXIT!!");     
			 }
	 }
	 
	 public List<User> list() {
	
		return userDAO.list();
	 }

	public Boolean checkUserPassword(String newPassword) {
		
		Boolean findUserPassword =false;
		
		String regex_Password = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		
		if(newPassword.matches(regex_Password))  {
			findUserPassword=true;
		}
		return findUserPassword;
	}

	public Boolean checkUserEMail(String newEmail) {
		
		Boolean findUserPassword =false;
		
		String regex_Email = "^(.+)@(.+)$";
		
		
		if(newEmail.matches(regex_Email))  {
			findUserPassword=true;
		}
		return findUserPassword;
	}
	
	public Boolean checkUserMobileNumber(String newMobileNumber) {
		Boolean findUserPassword =false;
		
		if(newMobileNumber.length()==10)  {
			findUserPassword=true;
		}
		return findUserPassword;
	}

	public User checkUser(String updateUserName) {
		 
		 List<User> userList= userDAO.list();
	     User upateUserObject = null;
	     for(int i=0; i<userList.size();i++) {
	        if((updateUserName.equals(userList.get(i).getUserName()))) {
	        	upateUserObject =  userList.get(i);
	        }
	     }
		return upateUserObject;
		
	}
	
	public Boolean checkDuplicateUser(String userName) {
		 
		 List<User> userList= userDAO.list();
	     Boolean value = true;
	     for(int i=0; i<userList.size();i++) {
	        if((userName.equals(userList.get(i).getUserName()))) {
	        	value =  false;
	        	break;
	        }
	     } 
		return value;
	 }
	
	
	public Boolean checkDuplicateEmail(String emailAddress) {
		 
		 List<User> userList= userDAO.list();
	     Boolean value = false;
	     for(int i=0; i<userList.size();i++) {
	        if((emailAddress.equals(userList.get(i).getEmail()))) {
	        	value =  true;
	        	break;
	        }
	     } 
		return value;
	 }

	public void delete(User deleteUserObject_2) {
		userDAO.delete(deleteUserObject_2);	
	}

	public Integer checkUserUpdateOrCreate(User checkUserObject) {
		Integer returnValue=null;
		
		if(checkUserObject.getId()==null) {
			returnValue = 1;
		}
		
		return returnValue;
		
	}
	
}
