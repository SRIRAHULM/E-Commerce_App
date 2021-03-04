package javaDemo.E_com_BO;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javaDemo.E_com.ProductType;
import javaDemo.E_com_DAO.ProductTypeDAO;

public class ProductTypeBO {
	
	ProductTypeDAO productTypeDAO = new ProductTypeDAO(); 
	
	public List<ProductType>  list() {
		return productTypeDAO.list();
		
	}
	
	public ProductType findProductType(String productTypeName) {
		
		ProductType productTypeObject =null;
		List<ProductType> productTypeList = productTypeDAO.list();
		Integer flag = 0;
		
		for(int i=0; i<productTypeList.size();i++) {
			if(productTypeList.get(i).getName().equalsIgnoreCase(productTypeName)) {
				productTypeObject = productTypeList.get(i);
				flag++;
			}
		}
		
		/*if(flag==0) {
			ProductType newProductTypeObject = new ProductType(productTypeName);
			productTypeObject = newProductTypeObject;
		}*/
		
		return productTypeObject;
	}
	
	public void initialFileUpload(BufferedReader br) throws IOException {
		String line;
		while ((line = br.readLine()) != null) {

			String arr[] = line.split(",");
			if (arr.length >= 1) {
				ProductType productObject = new ProductType(arr[0]);
				productTypeDAO.create(productObject);

			}
		}
	}
		
		
}
