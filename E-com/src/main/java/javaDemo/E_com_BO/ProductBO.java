package javaDemo.E_com_BO;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javaDemo.E_com.Product;
import javaDemo.E_com.ProductType;
import javaDemo.E_com_DAO.ProductDAO;
import javaDemo.E_com_DAO.ProductTypeDAO;

public class ProductBO {
	
	ProductDAO productDAO = new ProductDAO();
	ProductTypeDAO productTypeDAO = new ProductTypeDAO();
	ProductTypeBO productTypeBO = new ProductTypeBO();

	public void create(Product newProductObject) {
		productDAO.create(newProductObject);
	}

	public void fileUpload(BufferedReader br) throws IOException {
		String line;
		while ((line = br.readLine()) != null) {

			String arr[] = line.split(",");
			if (arr.length >= 1) {
				ProductType newProductTypeObject = productTypeBO.findProductType(arr[5]);
				Product productObject = new Product(arr[0], Double.parseDouble(arr[1]), arr[2], arr[3],
									Integer.parseInt(arr[4]),  newProductTypeObject);
				newProductTypeObject.getProductList().add(productObject);
				updateProduct(productObject);

			}
		}
	}
	

	public Product checkProduct(String updateProductName) {
		List<Product> productList = productDAO.list();
		Product upateUserObject = null;
		for (int i = 0; i < productList.size(); i++) {
			if ((updateProductName.equals(productList.get(i).getName()))) {
				upateUserObject = productList.get(i);
			}
		}
		return upateUserObject;
	}

	public void updateProduct(Product updateProduct) {

		List<Product> productList_1 = productDAO.list();
		System.out.println(productList_1.size());
		if (productList_1.size() != 0) {
			for (int i = 0; i < productList_1.size(); i++) {
				if ((updateProduct.getName().equals(productList_1.get(i).getName()))) {
					updateProduct.setQuantity(updateProduct.getQuantity() + productList_1.get(i).getQuantity());
					updateProduct.setId(productList_1.get(i).getId());
					productDAO.create(updateProduct);
				}

			}
		}
		productDAO.create(updateProduct);

	}
	
	

}
