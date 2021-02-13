package javaDemo.E_com_BO;

import java.io.BufferedReader;
import java.io.IOException;

import javaDemo.E_com.Product;
import javaDemo.E_com_DAO.ProductDAO;

public class ProductBO {
	ProductDAO productDAO = new ProductDAO();
	public void create(Product newProductObject) {
		productDAO.create(newProductObject);
		
	}
	
	public void fileUpload(BufferedReader br) throws IOException
    {
        String line;
        while((line=br.readLine())!= null)
        {
            String arr[]=line.split(",");
            if(arr.length==5)
            {
            	Product productObject=new Product(arr[0],Double.parseDouble(arr[1]),arr[2],arr[3],Integer.parseInt(arr[4]));
            	productDAO.create(productObject);
            }
        }
    }

}
