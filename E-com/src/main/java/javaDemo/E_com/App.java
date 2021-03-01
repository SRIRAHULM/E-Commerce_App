package javaDemo.E_com;

import java.io.*;
import java.util.List;

import javaDemo.E_com_BO.AddressBO;
import javaDemo.E_com_BO.ProductBO;
import javaDemo.E_com_BO.ProductTypeBO;
import javaDemo.E_com_BO.UserBO;

public class App {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static UserBO userBO = new UserBO();
	static AddressBO addressBO = new AddressBO();
	static ProductBO productBO = new ProductBO();
	static ProductTypeBO productTypeBO = new ProductTypeBO();

	public static void main(String[] args) throws Exception {

		//initialDataBaseUpdate();

		String userRoll;

		do {
			// call login function to get user name
			userRoll = login();
			try {

				Integer adminOrCustom = 0;

				if (userRoll == null) {
					System.out.println("Cannot find User Name or Password");
				} else {
					if (userRoll.equalsIgnoreCase("ADMIN")) {
						adminOrCustom = 1;
					} else if (userRoll.equalsIgnoreCase("CUSTOMER")) {
						adminOrCustom = 2;
					}
					do {
						switch (adminOrCustom) {
							case 1:
								System.out.println("1. Create\t\t" + "2. Update\t\t" + "3. Delete\n\n" + "LOG OUT");

								switch (Integer.parseInt(br.readLine())) {
									case 1:

										System.out.println("1. User\t\t" + "2. Address\t\t" + "3. Product\t\t");

										switch (Integer.parseInt(br.readLine())) {

											case 1:

												String yesOrNo_Value_createUser = "yes";
												do {
													User newUserObject = new User();
													createUser(newUserObject);
													System.out.println("User Created Successfully");
													System.out.println("Do you want to create another User");
													yesOrNo_Value_createUser = br.readLine();
												} while (yesOrNo_Value_createUser.equalsIgnoreCase("yes"));
												break;
												
											case 2:

												String yesOrNo_Value_createProduct = "yes";
												User updateuserObject_1 = null;
												do {
													System.out.println("Enter the User Name of the User");
													String updateUserName_1 = br.readLine();
													updateuserObject_1 = userBO.checkUser(updateUserName_1);

													if (updateuserObject_1 == null) {
														System.out.println("No Users Found");
													} else {

														createAddress(updateuserObject_1, new Address());
														userBO.create(updateuserObject_1);
														System.out.println("Address Created Successfully");
														System.out.println("Do you want to create another Address");
														yesOrNo_Value_createProduct = br.readLine();
													}

												} while (yesOrNo_Value_createProduct.equalsIgnoreCase("yes")
														|| updateuserObject_1 == null);
												break;
												
											case 3:
												System.out.println("1. Single Upload\t\t" + "2. Bulk Upload\t\t");

												switch (Integer.parseInt(br.readLine())) {
													case 1:
														String yesOrNoValue_3 = "yes";
														do {
															Product newProductObject = new Product();
															createproduct(newProductObject);
															System.out.println("Do you want to create another Product");
															yesOrNoValue_3 = br.readLine();
														} while (yesOrNoValue_3.equalsIgnoreCase("yes"));
														break;
													case 2:
														String yesOrNoValue_4 = "yes";
														do {

															BufferedReader brFile = new BufferedReader(new FileReader(
																	"C:\\Users\\Amphisoft\\git\\E-Commerce_App\\E-com\\src\\main\\java\\ProductList.csv"));
															productBO.fileUpload(brFile);
															System.out.println("Do you want to create another Product");
															yesOrNoValue_4 = br.readLine();
														} while (yesOrNoValue_4.equalsIgnoreCase("yes"));
														break;
												}
												break;
										}
										break;

									case 2:
										System.out.println("1. User\t\t" + "2. Address\t\t" + "3. Product\t\t");

										switch (Integer.parseInt(br.readLine())) {
											case 1:
												String yesOrNoValue_5 = "yes";
												User updateuserObject = null;
												do {
													System.out.println("Enter the User Name of the User");
													String updateUserName = br.readLine();
													updateuserObject = userBO.checkUser(updateUserName);

													if (updateuserObject == null) {
														System.out.println("No Users Found");
													} else {
														System.out.println(
																"Select the field to be update\n1. Name\n2. E-Mail\n3. User Name\n"
																		+ "4. Mobile Number\n5. Password\n6. Roll\n7.ALL");
														updateUser(updateuserObject);
														System.out.println("Do you want to change any other field");
														yesOrNoValue_5 = br.readLine();
													}
												} while (yesOrNoValue_5.equalsIgnoreCase("yes")
														|| updateuserObject == null);
												break;

											case 2:

												String yesOrNoValue_6 = "yes", yesOrNoValue_7 = "yes";
												User updateuserObject_2 = null;
												do {
													System.out.println("Enter the User Name of the User");
													String updateUserName_2 = br.readLine();
													updateuserObject_2 = userBO.checkUser(updateUserName_2);

													if (updateuserObject_2 == null) {
														System.out.println("No Users Found");
													} else {
														if (updateuserObject_2.getListOfAddress().size() == 0) {
															System.out.println("No Address Found\n");
															System.out.println("Do you want to create new address");
															yesOrNoValue_7 = br.readLine();
															if (yesOrNoValue_7.equalsIgnoreCase("yes")) {
																createAddress(updateuserObject_2, new Address());
																userBO.create(updateuserObject_2);
															}
															System.out
																	.println("Do you want to change any other Address");
															yesOrNoValue_6 = br.readLine();
														} else {
															for (int i = 0; i < updateuserObject_2.getListOfAddress()
																	.size(); i++) {
																System.out.println((i + 1) + " .");
																System.out.println(
																		updateuserObject_2.getListOfAddress().get(i));
																System.out.println(
																		"==========================================");
															}
															System.out.println("Which Address do you want to change");
															Integer addressChangeChoise = Integer
																	.parseInt(br.readLine());
															createAddress(updateuserObject_2, updateuserObject_2
																	.getListOfAddress().get(addressChangeChoise - 1));
															userBO.create(updateuserObject_2);
															System.out
																	.println("Do you want to change any other Address");
															yesOrNoValue_6 = br.readLine();
														}

													}
												} while (yesOrNoValue_6.equalsIgnoreCase("yes")
														|| updateuserObject_2 == null
														|| updateuserObject_2.getListOfAddress().size() == 0);
												break;

											case 3:
												System.out.println("1. Single Update\t\t" + "2. Bulk Update\t\t "
														+ "3. Update Stock of the Product");

												switch (Integer.parseInt(br.readLine())) {
													case 1:
														String yesOrNoValue_3 = "yes";
														Product updateProductObject = null;
														do {
															System.out.println("Enter the Product Name");
															String updateProductName = br.readLine();
															updateProductObject = productBO
																	.checkProduct(updateProductName);
															if (updateProductObject != null) {
																System.out.println(
																		"Select the field to be update\n1. Name\n2. Price\n3. Brand\n"
																				+ "4. Quantity\n5. Colour\n6.ProductType\n7.ALL");
																updateProduct(updateProductObject);
																System.out.println("Product Created Successfully");
																System.out.println(
																		"Do you want to update another Product");
																yesOrNoValue_3 = br.readLine();
															} else {
																System.out.println("No Product Found");
															}

														} while (yesOrNoValue_3.equalsIgnoreCase("yes"));
														break;
													case 2:
														String yesOrNoValue_4 = "yes";
														do {
															BufferedReader brFile = new BufferedReader(new FileReader(
																	"C:\\Users\\Amphisoft\\git\\E-Commerce_App\\E-com\\src\\main\\java\\ProductList.csv"));
															productBO.fileUpload(brFile);
															System.out.println("File Uploaded Successfully");
															System.out.println("Do you want to create another Product");
															yesOrNoValue_4 = br.readLine();
														} while (yesOrNoValue_4.equalsIgnoreCase("yes"));
														break;
													case 3:
														String yesOrNoValue_9 = "yes";
														Product updateProductObject_5 = null;
														do {
															System.out.println("Enter the Product Name");
															String updateProductName = br.readLine();
															updateProductObject_5 = productBO
																	.checkProduct(updateProductName);
															if (updateProductObject_5 != null) {
																getProductQuantity(updateProductObject_5);
																System.out.println("Product Created Successfully");
																System.out.println(
																		"Do you want to update another Product");
																yesOrNoValue_9 = br.readLine();
															} else {
																System.out.println("No Product Found");
															}

														} while (yesOrNoValue_9.equalsIgnoreCase("yes"));
														break;
												}
												break;

										}
										break;
									case 3:
										System.out.println("1. User\t\t" + "2. Address\t\t" + "3. Product\t\t");

										switch (Integer.parseInt(br.readLine())) {
											case 1:
												User deleteUserObject_2 = null;
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
								break;
							case 2:
								System.out.println(
										"1. Purchasing multiple products\r\n" + "2. Showing Purchase History\r\n"
												+ "3. Show Product wise Purchase history\r\n" + "4. Rate a Product\r\n"
												+ "5. See ratings for a product");

								switch (Integer.parseInt(br.readLine())) {
									case 1:
										List<ProductType> productTypeList = productTypeBO.list();
										for (int i = 0; i < productTypeList.size(); i++) {
											System.out.println(productTypeList.get(i).getName());
										}
										Integer productTypechoise = Integer.parseInt(br.readLine());
										for (int i = 0; i < productTypeList.get(productTypechoise).getProductList()
												.size(); i++) {
											System.out.println(productTypeList.get(productTypechoise).getProductList()
													.get(i).getName());
										}

								}
						}
					} while (true);
				}
			} catch (Exception e) {
				System.out.println();
				System.out.println(e);
			}
		} while (userRoll == null);

	}

	private static void updateProduct(Product updateProductObject) throws Exception {

		switch (Integer.parseInt(br.readLine())) {
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
				createProductType(updateProductObject);
				break;
			case 7:
				createproduct(updateProductObject);
				break;

			default:
				System.out.println("404 ERROR");
		}
		productBO.create(updateProductObject);
	}

	private static void createProductType(Product updateProductObject) throws Exception {
		System.out.println("Product Type");
		String productType = br.readLine();

		updateProductObject.setProductType(productTypeBO.findProductType(productType));
		productTypeBO.findProductType(productType).getProductList().add(updateProductObject);

	}

	private static void getProductColour(Product updateProductObject) throws Exception {
		System.out.println("Colour");
		String colour = br.readLine();
		updateProductObject.setColour(colour);
	}

	private static void getProductQuantity(Product updateProductObject) throws Exception {
		System.out.println("Product Quantity");
		Integer productQuantity = Integer.parseInt(br.readLine());
		updateProductObject.setQuantity(updateProductObject.getQuantity() + productQuantity);
		productBO.create(updateProductObject);
	}

	private static void getProductPrice(Product updateProductObject) throws Exception {
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
		System.out.println("Product Type");
		String productType = br.readLine();

		newProductObject.setProductType(productTypeBO.findProductType(productType));
		productTypeBO.findProductType(productType).getProductList().add(newProductObject);

		productBO.create(newProductObject);

	}

	private static void updateUser(User updateuserObject) throws Exception {

		switch (Integer.parseInt(br.readLine())) {
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
		newAddressObject = createAddress(newUserObject, newAddressObject);
		newUserObject.getListOfAddress().add(newAddressObject);
		userBO.create(newUserObject);

	}

	private static void userName(User newUserObject) throws Exception {

		System.out.println("Name");
		Integer checkValue = 0;
		do {
			String newName = br.readLine();
			newUserObject.setName(newName);
			if (userBO.noValueFound(newName)) {
				System.out.println("WARNING !!!\nThe Input is Empty");
				checkValue = 0;
			} else {
				checkValue = 1;
				if (userBO.checkUserUpdateOrCreate(newUserObject) != 1) {
					userBO.create(newUserObject);
				}
			}

		} while (checkValue == 0);

	}

	private static void userMail(User newUserObject) throws Exception {
		Integer checkValue = 0;
		do {
			System.out.println("E-mail");
			String newEmail = br.readLine();

			if (userBO.noValueFound(newEmail)) {
				System.out.println("WARNING !!!\nThe Input is Empty");
			} else {
				if (!userBO.checkUserEMail(newEmail)) {
					System.out.println("Please Enter Valid E-mail Address");
				} else {
					if (userBO.checkDuplicateEmail(newEmail)) {
						System.out.println("Email Address Already Exit \nPlease Enter new Email address");
					} else {
						checkValue = 1;
						newUserObject.setEmail(newEmail);
						if (userBO.checkUserUpdateOrCreate(newUserObject) != 1) {
							userBO.create(newUserObject);
						}
					}
				}
			}
		} while (checkValue == 0);

	}

	private static void userUserName(User newUserObject) throws Exception {

		Boolean returnUserName = null;
		Integer checkValue = 0;
		do {

			System.out.println("User Name");
			String newUserName = br.readLine();

			if (userBO.noValueFound(newUserName)) {
				System.out.println("WARNING !!!\nThe Input is Empty");
				checkValue = 0;
			} else {
				checkValue = 1;
				returnUserName = userBO.checkDuplicateUser(newUserName);
				newUserObject.setUserName(newUserName);
				if (userBO.checkUserUpdateOrCreate(newUserObject) != 1) {
					userBO.create(newUserObject);
				}
			}

		} while (returnUserName == false || (checkValue == 0));
	}

	private static void userMobileNumber(User newUserObject) throws Exception {

		Boolean returnUserPassword = false;
		Integer checkValue = 0;
		do  {
			System.out.println("Mobile Number");
			String newMobileNumber = br.readLine();
			if (userBO.noValueFound(newMobileNumber)) {
				System.out.println("WARNING !!!\nThe Input is Empty");
				checkValue = 0;
			} else {
				returnUserPassword = userBO.checkUserMobileNumber(newMobileNumber);
				if (returnUserPassword == true) {
					checkValue = 1;
					newUserObject.setMobileNo(newMobileNumber);
					if (userBO.checkUserUpdateOrCreate(newUserObject) != 1) {
						userBO.create(newUserObject);
					}
				} else {
					System.out.println(newUserObject.getId());
					System.out.println("Enter Valid Mobile Number\n");
				}
			}
			
		}while(returnUserPassword != true || checkValue == 0);
	}

	private static void userPassword(User newUserObject) throws Exception {

		Boolean returnUserPassword = false;
		Integer checkValue = 0;
		do {
			System.out.println("Password");
			String newPassword = br.readLine();
			if (userBO.noValueFound(newPassword)) {
				System.out.println("WARNING !!!\nThe Input is Empty");
				checkValue = 0;
			} else {
				returnUserPassword = userBO.checkUserPassword(newPassword);
				if (returnUserPassword == true) {
					checkValue = 1;
					newUserObject.setPassword(newPassword);
					if (userBO.checkUserUpdateOrCreate(newUserObject) != 1) {
						userBO.create(newUserObject);
					}
				} else {
					System.out.println("Password Length is too weak\n");
				}
			}
			
		}while (returnUserPassword != true || checkValue == 0);
	}

	private static void userRoll(User newUserObject) throws Exception {

		String newRoll = "CUSTOMER";	
		newUserObject.setRole(newRoll);
		if (userBO.checkUserUpdateOrCreate(newUserObject) != 1) {
			userBO.create(newUserObject);
		}
	}

	// Get Login Credentials From User
	private static String login() throws Exception {

		System.out.println("Enter Your User Name");
		String userName = br.readLine();

		System.out.println("Enter Your Password");
		String password = br.readLine();

		return userBO.findUser(userName, password);

	}

	// Initial DATABASE Update
	@SuppressWarnings("unused")
	private static void initialDataBaseUpdate() throws Exception {

		User userObject_1 = new User("Sri", "sri@abc.com", "9098765432", "sri", "sri", "ADMIN");
		User userObject_2 = new User("Rahul", "sri@abc.com", "9098765432", "Rahul", "rahul", "CUSTOMER");

		Address addressObject_1 = new Address("1st Street", "Ganabathy", "Coimbatore", "Tamilnadu", "landmark", "76818",
				userObject_1);
		Address addressObject_2 = new Address("2nd Street", "Ganabathy", "Coimbatore", "Tamilnadu", "landmark", "76818",
				userObject_2);

		userObject_1.getListOfAddress().add(addressObject_1);
		userObject_2.getListOfAddress().add(addressObject_2);

		userBO.create(userObject_1);
		userBO.create(userObject_2);

		addressBO.create(addressObject_1);
		addressBO.create(addressObject_2);

		ProductType productTypeObject = new ProductType();
		BufferedReader brFile = new BufferedReader(new FileReader(
				"C:\\Users\\Amphisoft\\git\\E-Commerce_App\\E-com\\src\\main\\java\\ProductTypeFile.csv"));
		productTypeBO.initialFileUpload(brFile);
		System.out.println("File Uploaded Successfully");
	}

}
