package com.shopforhome.wishlist.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopforhome.wishlist.entity.WishlistEntity;
import com.shopforhome.wishlist.repository.WishlistRepo;



@Service
public class WishlistService {
	
	@Autowired
	private WishlistRepo wishlistrepo;
	
//	Function to get wishlist of specific customer using customer id
	public java.util.List<WishlistEntity> getData(Integer customerId){
		List<WishlistEntity> user_wishlist = new ArrayList<WishlistEntity>();
			List<WishlistEntity> list =  wishlistrepo.findAll();
			System.out.println("return list data");
			System.out.println(list);
			if(list.isEmpty()) {
				return user_wishlist;
			}
			else {
				for(WishlistEntity wishlist : list) {
					if(wishlist.getCustomerId()== customerId) {
						System.out.println("CustomerId inside for loop:"+wishlist.getCustomerId());
						user_wishlist.add(wishlist);
						System.out.println(user_wishlist);
					}
				}
				return user_wishlist;
			}
			
		}
		
		
	
//	Function to add wish list data
	public Boolean saveData(WishlistEntity wishlistentity) {
		try {
			wishlistrepo.save(wishlistentity);
			wishlistrepo.flush();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Exception thrown:"+ex);
			return false;
		}
	}
	
	
//	Function to Delete particular wishlist
	public Boolean deleteData(Integer id) {
		try {
			wishlistrepo.deleteById(id);
			return true;
		}
		catch(Exception ex) {
			System.out.println("Exception thrown:"+ex);
			return false;
		}
	}

}
