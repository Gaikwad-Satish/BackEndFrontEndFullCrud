package edu.cjc.springbootrestapicrudapp.app.serviceI;

import java.util.List;

import edu.cjc.springbootrestapicrudapp.app.model.Product;

public interface ProductServiceI {

	Product saveProduct(Product p);

	List<Product> getProducts();

	Product getProductById(int productId);

	Product updateProduct(Integer productId, Product p);

	void deleteProduct(int productId);

	Product getProductByName(String productName);

}
