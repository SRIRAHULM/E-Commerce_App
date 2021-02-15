package javaDemo.E_com;

import java.io.*;
import javaDemo.E_com_BO.AddressBO;
import javaDemo.E_com_BO.ProductBO;
import javaDemo.E_com_BO.UserBO;
import javaDemo.E_com_DAO.AddressDAO;
import javaDemo.E_com_DAO.UserDAO;

public class App 
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static UserBO userBO = new UserBO();
    static AddressBO addressBO = new AddressBO();
	static ProductBO productBO = new ProductBO();
	
	public static void main(String[] args ) throws Exception
    {
		
		//initialDataBaseUpdate();
    	
    	
    	String userRoll ;
        
    	do {
    		userRoll = login();
    		Integer adminOrCustom = 0;
    		if(userRoll==null) {
    			System.out.println("Cannot find User Name or Password");
    		}
    		
    		else {
				if(userRoll.equalsIgnoreCase("ADMIN")) {
					adminOrCustom = 1;
				}
				else if(userRoll.equalsIgnoreCase("CUSTOMER")) {
					adminOrCustom = 2;
				}
    			do {
    				switch(adminOrCustom) {
            		case 1:
            			System.out.println("1. Create\t\t"
            					+ "2. Update\t\t"
            					+ "3. Delete\n\n"
            					+ "LOG OUT");
            			
            			switch(Integer.parseInt(br.readLine())) {
            				case 1:
            					System.out.println("1. User\t\t"
                    					+ "2. Address\t\t"
                    					+ "3. Product\t\t");
            					
            					switch(Integer.parseInt(br.readLine())) {
            						case 1:
            							
            							String yesOrNoValue_1 = "yes";
            							do {
            								User newUserObject = new User();
                        					createUser(newUserObject);
                        					System.out.println("Do you want to create another User");
                        					yesOrNoValue_1 = br.readLine();
            							}while(yesOrNoValue_1.equalsIgnoreCase("yes"));
                    					break;
                    					
            						case 2:
            							
            							String yesOrNoValue_2 = "yes";
                    					User updateuserObject_1 =null;
                    					do{
                    						System.out.println("Enter the User Name of the User");
                        					String updateUserName_1 = br.readLine();
                        					updateuserObject_1 = userBO.checkUser(updateUserName_1);
                    						
                    						if(updateuserObject_1==null) {
                    							System.out.println("No Users Found");
                    						}
                    						else {
                    							
                            					createAddress(updateuserObject_1,new Address());
                            					userBO.create(updateuserObject_1);
                            					System.out.println("Do you want to create another Address");
                            					yesOrNoValue_2 = br.readLine();
                    						}
                        						
                    					}while(yesOrNoValue_2.equalsIgnoreCase("yes") || updateuserObject_1==null ) ;
                    					break;
            						case 3:
            							System.out.println("1. Single Upload\t\t"
                            					+ "2. Bulk Upload\t\t");
                    					
                    					switch(Integer.parseInt(br.readLine())) {
                    						case 1:
                    							String yesOrNoValue_3 = "yes";
                    							do {
                    								Product newProductObject = new Product();
                                					createproduct(newProductObject);
                                					System.out.println("Do you want to create another Product");
                                					yesOrNoValue_3 = br.readLine();
                    							}while(yesOrNoValue_3.equalsIgnoreCase("yes"));
                            					break;
                    						case 2:
                    							String yesOrNoValue_4 = "yes";
                    							do {
                    							    
                    							    BufferedReader brFile=new BufferedReader(new FileReader("C:\\Users\\Amphisoft\\git\\E-Commerce_App\\E-com\\src\\main\\java\\file.csv"));
                    							    productBO.fileUpload(brFile);
                                					System.out.println("Do you want to create another Product");
                                					yesOrNoValue_4 = br.readLine();
                    							}while(yesOrNoValue_4.equalsIgnoreCase("yes"));
                            					break;
                    					}
                    					break;
            					}
            					
            					break;
            					
            				case 2:
            					System.out.println("1. User\t\t"
                    					+ "2. Address\t\t"
                    					+ "3. Product\t\t");
            					
            					switch(Integer.parseInt(br.readLine())) {
            						case 1:
            							String yesOrNoValue_5 = "yes";
                    					User updateuserObject =null;
                    					do{
                    						System.out.println("Enter the User Name of the User");
                        					String updateUserName = br.readLine();
                        					updateuserObject = userBO.checkUser(updateUserName);
                    						
                    						if(updateuserObject==null) {
                    							System.out.println("No Users Found");
                    						}
                    						else {
                    							System.out.println("Select the field to be update\n1. Name\n2. E-Mail\n3. User Name\n"
                        								+ "4. Mobile Number\n5. Password\n6. Roll\n7.ALL");
                        						updateUser(updateuserObject);
                        						System.out.println("Do you want to change any other field");
                        						yesOrNoValue_5 = br.readLine();
                        					}
                    					}while(yesOrNoValue_5.equalsIgnoreCase("yes") || updateuserObject==null) ;
                    					break;
                    					
            						case 2:
            							
            							String yesOrNoValue_6 = "yes" ,yesOrNoValue_7 = "yes";
                    					User updateuserObject_2 =null;
                    					do{
                    						System.out.println("Enter the User Name of the User");
                        					String updateUserName_2 = br.readLine();
                        					updateuserObject_2 = userBO.checkUser(updateUserName_2);
                    						
                    						if(updateuserObject_2==null) {
                    							System.out.println("No Users Found");
                    						}
                    						else {
                    							if(updateuserObject_2.getListOfAddress().size()==0) {
                    								System.out.println("No Address Found\n");
                    								System.out.println("Do you want to create new address");
                            						yesOrNoValue_7 = br.readLine();
                            						if(yesOrNoValue_7.equalsIgnoreCase("yes")) {
                            							createAddress(updateuserObject_2,new Address());
                                    					userBO.create(updateuserObject_2);
                            						}
                            						System.out.println("Do you want to change any other Address");
                            						yesOrNoValue_6 = br.readLine();
                    							}
                    							else {
                    								for(int i=0 ; i< updateuserObject_2.getListOfAddress().size();i++) {
                            							System.out.println((i+1) +" .");
                            							System.out.println(updateuserObject_2.getListOfAddress().get(i));
                            							System.out.println("==========================================");
                            						}
                            						System.out.println("Which Address do you want to change");
                            						Integer addressChangeChoise = Integer.parseInt(br.readLine());
                            						createAddress(updateuserObject_2, updateuserObject_2.getListOfAddress().get(addressChangeChoise-1));
                            						userBO.create(updateuserObject_2);
                            						System.out.println("Do you want to change any other Address");
                            						yesOrNoValue_6 = br.readLine();
                    							}
                        						
                        					}
                    					}while(yesOrNoValue_6.equalsIgnoreCase("yes") || updateuserObject_2==null || updateuserObject_2.getListOfAddress().size()==0) ;
                    					break;
                    				
            						case 3:
            							System.out.println("1. Single Update\t\t"
                            					+ "2. Bulk Update\t\t");
            							
                    					switch(Integer.parseInt(br.readLine())) {
                    						case 1:
                    							String yesOrNoValue_3 = "yes";
                    							Product updateProductObject = null;
                    							do {
                    								System.out.println("Enter the Product Name");
                                					String updateProductName = br.readLine();
                                					updateProductObject = productBO.checkProduct(updateProductName);
													System.out.println("Select the field to be update\n1. Name\n2. Price\n3. Brand\n"
                        								+ "4. Quantity\n5. Colour\n6.ALL");
													updateProduct(updateProductObject);
													System.out.println("Product Created Successfully");
                                					System.out.println("Do you want to create another Product");
                                					yesOrNoValue_3 = br.readLine();
                    							}while(yesOrNoValue_3.equalsIgnoreCase("yes"));
                            					break;
                    						case 2:
                    							String yesOrNoValue_4 = "yes";
                    							do {
                    							    BufferedReader brFile=new BufferedReader(new FileReader("C:\\Users\\Amphisoft\\git\\E-Commerce_App\\E-com\\src\\main\\java\\file.csv"));
                    							    productBO.fileUpload(brFile);
                    							    System.out.println("File Uploaded Successfully");
                                					System.out.println("Do you want to create another Product");
                                					yesOrNoValue_4 = br.readLine();
                    							}while(yesOrNoValue_4.equalsIgnoreCase("yes"));
                            					break;
                    					}
                    					break;
            							
            					}
            					break;
            				case 3:
            					System.out.println("1. User\t\t"
                    					+ "2. Address\t\t"
                    					+ "3. Product\t\t");
            					
            					switch(Integer.parseInt(br.readLine())) {
            						case 1:
            							User deleteUserObject_2 =null;
                    					String deleteUserName_2 = br.readLine();
                    					deleteUserObject_2 = userBO.checkUser(deleteUserName_2);
                    					userBO.delete(deleteUserObject_2); 
                    					break;
                    					
            					}
            					break;
            					
            				default:
            					System.out.println("Session Closed ! !");
            					System.exit(0);
            					
            					
            			}
            		case 2:
            			
    			}
    			}while(true);
    		}	
    		
    	}while(userRoll==null);
	
    }

	private static void updateProduct(Product updateProductObject) throws Exception {
		
		switch(Integer.parseInt(br.readLine())) {
		case 1:
			getProductName(updateProductObject);
			break;
		case 2:
			getProductPrice(updateProductObject);
			break;
		case 3:
			getProductBrandName(updateProductObject);
			break;
		case 4:
			getProductQuantity(updateProductObject);
			break;
		case 5:
			getProductColour(updateProductObject);
			break;
		case 6:
			createproduct(updateProductObject);
			break;
		default:
			System.out.println("404 ERROR");
		}
		productBO.create(updateProductObject);
	}

	private static void getProductColour(Product updateProductObject)throws Exception {
		System.out.println("Colour");
 		String colour = br.readLine();
 		updateProductObject.setColour(colour);
	}

	private static void getProductQuantity(Product updateProductObject) throws Exception {
		System.out.println("Product Quantity");
 		Integer productQuantity = Integer.parseInt(br.readLine());
 		updateProductObject.setQuantity(productQuantity);
	}

	private static void getProductPrice(Product updateProductObject)throws Exception {
		System.out.println("Product Price");
 		Double productPrice = Double.parseDouble(br.readLine());
 		updateProductObject.setPrice(productPrice);
	}

	private static void getProductName(Product updateProductObject) throws Exception {
		System.out.println("Product Name");
		String newProductName = br.readLine();
		updateProductObject.setName(newProductName);
	}

	private static void getProductBrandName(Product updateProductObject) throws Exception {
		System.out.println("Product Name");
		String newProductBrandName = br.readLine();
		updateProductObject.setName(newProductBrandName);
	}

	private static void createproduct(Product newProductObject) throws Exception {
		
		System.out.println("Product Name");
 		String productName = br.readLine();
 		newProductObject.setName(productName);
 		System.out.println("Brand Name");
 		String brandName = br.readLine();
 		newProductObject.setBrand(brandName);
 		System.out.println("Colour");
 		String colour = br.readLine();
 		newProductObject.setColour(colour);
 		System.out.println("Product Price");
 		Double productPrice = Double.parseDouble(br.readLine());
 		newProductObject.setPrice(productPrice);
 		System.out.println("Product Quantity");
 		Integer productQuantity = Integer.parseInt(br.readLine());
 		newProductObject.setQuantity(productQuantity);
 		
 		productBO.create(newProductObject);
 		
		
	}

	private static void updateUser(User updateuserObject) throws Exception {
		
		switch(Integer.parseInt(br.readLine())) {
		case 1:
			userName(updateuserObject);
			break;
		case 2:
			userMail(updateuserObject);
			break;
		case 3:
			userUserName(updateuserObject);
			break;
		case 4:
			userMobileNumber(updateuserObject);
			break;
		case 5:
			userPassword(updateuserObject);
			break;
		case 6:
			userRoll(updateuserObject);
			break;
		case 7:
			createUser(updateuserObject);
			break;
		default:
			System.out.println("404 ERROR");
		}
		
	}

	private static Address createAddress(User newUserObject, Address newAdddressObject) throws Exception {
		
		System.out.println("Address Line-1");
 		String newAddressLine1 = br.readLine();
 		newAdddressObject.setAddressLine1(newAddressLine1);
 		System.out.println("Address Line-2");
 		String newAddressLine2 = br.readLine();
 		newAdddressObject.setAddressLine2(newAddressLine2);
 		System.out.println("City");
 		String newCity = br.readLine();
 		newAdddressObject.setCity(newCity);
 		System.out.println("State");
 		String newState = br.readLine();
 		newAdddressObject.setState(newState);
 		System.out.println("Landmark");
 		String newLandmark = br.readLine();
 		newAdddressObject.setLandmark(newLandmark);
 		System.out.println("Pincode");
 		String newPincode = br.readLine();
 		newAdddressObject.setPincode(newPincode);
 		
 		newAdddressObject.setUser(newUserObject);
 		addressBO.create(newAdddressObject);
 		return newAdddressObject;
		
	}



	private static void createUser(User newUserObject) throws Exception {
		
		userName(newUserObject);
 		userMail(newUserObject);
 		userMobileNumber(newUserObject); 
 		userUserName(newUserObject);
 		userPassword(newUserObject);
 		userRoll(newUserObject);
 		
 		userBO.create(newUserObject);
 		Address newAddressObject = new Address();
 		newAddressObject = createAddress(newUserObject,newAddressObject);
 		newUserObject.getListOfAddress().add(newAddressObject);
 		userBO.create(newUserObject);
		
	}
	
	private static void userName(User newUserObject) throws Exception {
		
		System.out.println("Name");
 		String newName = br.readLine();
 		newUserObject.setName(newName);
 		if(userBO.checkUserUpdateOrCreate(newUserObject)!=1) {
				userBO.create(newUserObject);
			}
		
	}

	private static void userMail(User newUserObject) throws Exception {
		
		System.out.println("E-mail");
 		String newEmail = br.readLine();
 		newUserObject.setEmail(newEmail);
 		if(userBO.checkUserUpdateOrCreate(newUserObject)!=1) {
				userBO.create(newUserObject);
			}
		
	}
	
	private static void userUserName(User newUserObject) throws Exception {
		
		Boolean returnUserName= null;
		
		do {
			
			System.out.println("User Name");
	 		String newUserName = br.readLine();
	 		returnUserName = userBO.checkDuplicateUser(newUserName);
	 		newUserObject.setUserName(newUserName);
	 		if(userBO.checkUserUpdateOrCreate(newUserObject)!=1) {
	 				userBO.create(newUserObject);
	 			}
	 		
		}while(returnUserName==false)	;	
	}

	private static void userMobileNumber(User newUserObject) throws Exception {
		
 		Boolean returnUserPassword = false;
		while(returnUserPassword!=true) {
			 
			System.out.println("Mobile Number");
	 		String newMobileNumber = br.readLine();
 	 		returnUserPassword = userBO.checkUserMobileNumber(newMobileNumber);
 	 		if(returnUserPassword==true) {
 	 			newUserObject.setMobileNo(newMobileNumber);
 	 			if(userBO.checkUserUpdateOrCreate(newUserObject)!=1) {
 	 				userBO.create(newUserObject);
 	 			}
 	 		}
 	 		else {
 	 			System.out.println(newUserObject.getId());
 	 			System.out.println("Enter Valid Mobile Number\n");
 	 		}
 		}	
	}

	private static void userPassword(User newUserObject) throws Exception {
		
		Boolean returnUserPassword = false;
		while(returnUserPassword!=true) {
			
			System.out.println("Password");
	 		String newPassword = br.readLine();
 	 		returnUserPassword = userBO.checkUserPassword(newPassword);
 	 		if(returnUserPassword==true) {
 	 			newUserObject.setPassword(newPassword);
 	 			if(userBO.checkUserUpdateOrCreate(newUserObject)!=1) {
 	 				userBO.create(newUserObject);
 	 			}
 	 		}
 	 		else {
 	 			System.out.println("Password Length is too weak\n");
 	 		}
 		}	
	}

	private static void userRoll(User newUserObject) throws Exception {
		
		Boolean returnUserRoll = false;
		while(returnUserRoll!=true){
			
 			System.out.println("Roll (ADMIN/CUSTOMER)");
 	 		String newRoll = br.readLine();
 	 		returnUserRoll = userBO.checkUserROll(newRoll);
 	 		if(returnUserRoll==true) {
 	 			newUserObject.setRole(newRoll);
 	 			if(userBO.checkUserUpdateOrCreate(newUserObject)!=1) {
 	 				userBO.create(newUserObject);
 	 			}
 	 		}
 	 		else {
 	 			System.out.println("Enter Valid Roll\n");
 	 		}
 		}		
	}
	
	//Get Login Credentials From User
	private static String login() throws Exception {
		
		System.out.println("Enter Your User Name");
        String userName = br.readLine();
        
        System.out.println("Enter Your Password");
        String password = br.readLine();
        
        return userBO.findUser(userName, password);
		
	}
	
	//Initial DATABASE Update
	@SuppressWarnings("unused")
	private static void initialDataBaseUpdate() throws Exception {
		
		User userObject_1 = new User("Sri","sri@abc.com","9098765432","sri","sri","ADMIN");
		User userObject_2 = new User("Rahul","sri@abc.com","9098765432","Rahul","rahul","CUSTOMER");
		
		Address addressObject_1 = new Address("1st Street","Ganabathy", "Coimbatore","Tamilnadu","landmark","76818", userObject_1);
		Address addressObject_2 = new Address("2nd Street","Ganabathy", "Coimbatore","Tamilnadu","landmark","76818", userObject_2);

		userObject_1.getListOfAddress().add(addressObject_1);
		userObject_2.getListOfAddress().add(addressObject_2);
		
        userBO.create(userObject_1);
        userBO.create(userObject_2);
        
        addressBO.create(addressObject_1);
        addressBO.create(addressObject_2);
		
	}

}
