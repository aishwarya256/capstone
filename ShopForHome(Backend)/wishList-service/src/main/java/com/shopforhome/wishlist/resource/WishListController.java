package com.shopforhome.wishlist.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopforhome.wishlist.entity.WishlistEntity;
import com.shopforhome.wishlist.response.WebResponse;
import com.shopforhome.wishlist.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

	@Autowired
	private WishlistService wishlistservice;
	
	@GetMapping("/listData/{customer_id}")
	public ResponseEntity<WebResponse> getData(@PathVariable Integer customer_id) {
		List<WishlistEntity> data = wishlistservice.getData(customer_id);
		if(data.isEmpty())
			return ResponseEntity.badRequest().body(new WebResponse(false,"No data is available!"));
		else
			return ResponseEntity.ok(new WebResponse(true, data));
	}
	
	@PostMapping("/save")
	public ResponseEntity<WebResponse> saveWishlistData(@RequestBody WishlistEntity wishlistentity) {
		System.out.println("Image url:");
		System.out.println(wishlistentity.getImage_url());
		System.out.println("Id of wishlist");
		System.out.print(wishlistentity.getWishList_id());
		Boolean status = wishlistservice.saveData(wishlistentity);
		if(status)
			return ResponseEntity.ok(new WebResponse(true,"Wish li"));
		else
			return ResponseEntity.badRequest().body(new WebResponse(false, "Data not saved!"));
	}
	
	@DeleteMapping("/deleteAll/{wishlist_id}")
	public ResponseEntity<WebResponse> deleteWishlistData(@PathVariable Integer wishlist_id){
		Boolean status = wishlistservice.deleteData(wishlist_id);
		if(status)
			return ResponseEntity.ok(new WebResponse(true,"Data Deleted!"));
		else
			return ResponseEntity.badRequest().body(new WebResponse(false, "Data Not deleted!"));
	}
	

}
