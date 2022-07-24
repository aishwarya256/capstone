package com.shopforhome.cartlist.resource;

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
import org.springframework.web.client.RestTemplate;

import com.shopforhome.cartlist.entity.CartEntity;
import com.shopforhome.cartlist.model.Products;
import com.shopforhome.cartlist.service.CartService;
import com.shopforhome.cartlist.webresponse.WebResponse;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartservice;
	
	@Autowired
	private RestTemplate res;
	
	@GetMapping("/list/{customerId}")
	public ResponseEntity<WebResponse> getData(@PathVariable Integer customerId) {
//		RestTemplate res = new RestTemplate();
		WebResponse webproducts = res.getForObject("http://localhost:8183/product/list/"+1,WebResponse.class);
//		Products product = webproducts.getData();
		System.out.println("Products:"+webproducts.getData());
		
		
		List<CartEntity> data = cartservice.getData(customerId);
		if(data.isEmpty()) {
			return ResponseEntity.badRequest().body(new WebResponse(false, "Data not available!",""));
		}
		else {
			return ResponseEntity.ok(new WebResponse(true,"Success!" , data));
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<WebResponse> saveData(@RequestBody CartEntity userCart){
		Optional<CartEntity> data = cartservice.saveData(userCart);
		if(data.isEmpty()) {
			return ResponseEntity.ok(new WebResponse(false,"Data not saved!",""));
		}
		else {
			return ResponseEntity.badRequest().body(new WebResponse(true,"Data saved succefully!",data.get()));
		}
	}
	
	@DeleteMapping("/delete/{cart_id}")
	public ResponseEntity<WebResponse> deleteData(@PathVariable Integer cart_id){
		Boolean status = cartservice.deleteData(cart_id);
		if(status) {
			return ResponseEntity.ok(new WebResponse(true, "Data deleted successfully!",""));
		}
		else {
			return ResponseEntity.badRequest().body(new WebResponse(false, "Failed to delete data!", ""));
		}
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<WebResponse> updateData(@RequestBody CartEntity updatedCart) {
		Optional<CartEntity> data = cartservice.saveData(updatedCart);
		if(data.isEmpty()) {
			return ResponseEntity.ok(new WebResponse(false,"Data not updated!",""));
		}
		else {
			return ResponseEntity.badRequest().body(new WebResponse(true,"Data updated succefully!",data.get()));
		}
	}
	
	
}
