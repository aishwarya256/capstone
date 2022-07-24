package com.shopforhome.products.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.products.entity.ProductsEntity;
import com.shopforhome.products.response.WebResponse;
import com.shopforhome.products.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@GetMapping("/list")
	public ResponseEntity<WebResponse> getData(){
		List<ProductsEntity> data = productservice.getData();
		if(data.isEmpty()) {
			return ResponseEntity.badRequest().body(new WebResponse(false,"No data available!",""));
		}
		else {
			return ResponseEntity.ok(new WebResponse(true,"Success!", data));
		}
	}
	
	@GetMapping("/list/{product_id}")
	public ResponseEntity<WebResponse> getDataById(@PathVariable Integer product_id){
		Optional<ProductsEntity> opt = productservice.getById(product_id);
		if(opt.isEmpty())
		{
			return ResponseEntity.badRequest().body(new WebResponse(false,"No data found", ""));
		}
		else {
			return ResponseEntity.ok(new WebResponse(true, "Success!", opt.get()));
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<WebResponse> saveData(@RequestBody ProductsEntity productsentity){
		Boolean status = productservice.saveData(productsentity);
		if(status) {
			return ResponseEntity.ok(new WebResponse(true,"Success!", productsentity));
		}
		else {
			return ResponseEntity.badRequest().body(new WebResponse(false,"Failed!",productsentity));
		}
	}
	
	@DeleteMapping("/delete/{product_id}")
	public ResponseEntity<WebResponse> deleteData(@PathVariable Integer product_id){
		Boolean status = productservice.deleteData(product_id);
		if(status) {
			return ResponseEntity.ok(new WebResponse(status,"Success!",""));
		}
		else {
			return ResponseEntity.badRequest().body(new WebResponse(status, "Failed!",product_id));
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<WebResponse> updateData(@RequestBody ProductsEntity productsentity){
		Boolean status = productservice.saveData(productsentity);
		if(status) {
			return ResponseEntity.ok(new WebResponse(true,"Success!", productsentity));
		}
		else {
			return ResponseEntity.badRequest().body(new WebResponse(false,"Failed!",productsentity));
		}
	}
	
	
	
}
