package com.niit.ecom.backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecom.backend.dao.ProductDAO;
import com.niit.ecom.backend.model.Product;

public class ProductDAOTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ecom.backend");
		context.refresh();
		
		ProductDAO dao = (ProductDAO)context.getBean("productDAO");
		Product product = new Product();
		product.setBarcode(456655665);
		product.setDescription("Very cool product");
		product.setProductCost(183.23);
		product.setProductName("Perfume");
		
		dao.addProduct(product);
		System.out.println("Product Saved Successfully");
	}
}
