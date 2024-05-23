package edu.cjc.springbootrestapicrudapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import edu.cjc.springbootrestapicrudapp.app.model.Product;
import edu.cjc.springbootrestapicrudapp.app.serviceI.ProductServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceI psi;
	
	
	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product p)
	{
//		Product product=psi.saveProduct(p);
//		System.out.println("Data inserted Successfully");
//		return new ResponseEntity<Product>(HttpStatus.CREATED);
		if(p.getProductId()>=0)
		{
			Product product=psi.saveProduct(p);
			
		}else {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Product>(HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts()
	{
		List<Product> pList= psi.getProducts();
		return new ResponseEntity<List<Product>>(pList,HttpStatus.OK);
	}
	
	@GetMapping("/products/{productId}")
	public Product getSpecificProduct(@PathVariable int productId)
	{
		Product product= psi.getProductById(productId);
		return product;
	}
	
	@PutMapping("/product/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable int productId,@RequestBody Product p)
	{
		 Product product=psi.updateProduct(productId,p);
		 return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int productId)
	{
		psi.deleteProduct(productId);
		System.out.println("This is Product Controller method");
		return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/product/{productName}")
	public ResponseEntity<Product> getProductByName(@PathVariable String productName)
	{
//		int a=10/0;
		Product product=psi.getProductByName(productName);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
		
	}
	
	
	
	
	
	

}





