package com.shopforhome.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopforhome.products.entity.ProductsEntity;
import com.shopforhome.products.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productrepo;
	
	//To get all the products data
	public List<ProductsEntity> getData(){
		return productrepo.findAll();
	}
	
	
	//Save single products in db or to update the current entry
	public Boolean saveData(ProductsEntity productsentity) {
		try {
			productrepo.save(productsentity);
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error caught in products:"+ex);
			return false;
		}
	}
	
	//Delete the product with the help of product id
	public Boolean deleteData(Integer product_id) {
		try {
			productrepo.deleteById(product_id);
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error caught in deleting product entry:"+ex);
			return false;
		}
	}
	
	//Service to service communication
	//To return particular product which is to be added to cart
	public Optional<ProductsEntity> getSpecificProduct(Integer product_id) {
		return productrepo.findById(product_id);
	}
	
	
	//Returns a particular entry 
	public Optional<ProductsEntity> getById(Integer product_id){
		try {
			Optional<ProductsEntity> data = productrepo.findById(product_id);
			return data;
		}
		catch(Exception ex) {
			System.out.println("exception in connecting:"+ex);
			Optional<ProductsEntity> opt = Optional.empty();
			return opt;
		}
	}
	
}
