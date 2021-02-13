package javaDemo.E_com_EXCEPTION;

@SuppressWarnings("serial")
public class DuplicateUserNameException extends Exception{
	
	DuplicateUserNameException(){
		
	}
	
	public DuplicateUserNameException(String s) {
		super(s);
	}
}
