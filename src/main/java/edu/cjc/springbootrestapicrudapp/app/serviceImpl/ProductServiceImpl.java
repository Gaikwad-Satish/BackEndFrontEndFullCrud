package edu.cjc.springbootrestapicrudapp.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.springbootrestapicrudapp.app.exception.ProductNotFoundException;
import edu.cjc.springbootrestapicrudapp.app.model.Product;
import edu.cjc.springbootrestapicrudapp.app.repository.ProductRepository;
import edu.cjc.springbootrestapicrudapp.app.serviceI.ProductServiceI;

@Service
public class ProductServiceImpl implements ProductServiceI{
	
	@Autowired
	ProductRepository pre;

	@Override
	public Product saveProduct(Product p) {
		
		 return pre.save(p);
		
		
		
	}

	@Override
	public List<Product> getProducts() {
	
		return pre.findAll();
	}

	@Override
	public Product getProductById(int productId) {
		
		
		return pre.findByProductId(productId);
	}

	@Override
	public Product updateProduct(Integer productId, Product p) 
	{
			Optional<Product> op = pre.findById(productId);
			 if(op.isPresent()) 
			 {
				 Product product=op.get();
				 
				 if(p.getProductName()!=null) 
				 {
					 product.setProductName(p.getProductName());
				 
					 
					 if(p.getProductType()!=null) 
					 {
						 product.setProductType(p.getProductType());	 
					 }
					 if(p.getProductPrice()!=null) 
					 {
						 product.setProductPrice(p.getProductPrice());
					 }
				
				 }
				 	return pre.save(product); 
			 }else 
			 {
				 return null; 
			 }
		
	}

	@Override
	public void deleteProduct(int productId) {
		pre.deleteById(productId);
		
	}

	@Override
	public Product getProductByName(String productName) {
		
			Product p=pre.findByProductName(productName);
			if(p!=null)
			{
				return p;
			}
			else
			{
				throw new ProductNotFoundException("Product Not Available.");
			}
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
