package com.shopforhome.cartlist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopforhome.cartlist.entity.CartEntity;
import com.shopforhome.cartlist.repository.CartRepo;

@Service
public class CartService {

	@Autowired
	private CartRepo cartrepo;
	
	//To get cart list of specific customer
	public List<CartEntity> getData(Integer customerId){
		List<CartEntity> user_cartlist = new ArrayList<CartEntity>();
		List<CartEntity> list = cartrepo.findAll();
		if(list.isEmpty()) {
			return user_cartlist;
		}
		else {
			for(CartEntity cartlist : list) {
				if(cartlist.getCustomerId()==customerId) {
					user_cartlist.add(cartlist);
				}
			}
			return user_cartlist;
		}
	}
	
	
	//To save user's cart data
	public Optional<CartEntity> saveData(CartEntity cartData) {
		try {
			cartrepo.save(cartData);
			cartrepo.flush();
			return Optional.of(cartData);
		}
		catch(Exception ex) {
			System.out.println("Error caught in cartservice:"+ex);
			return Optional.ofNullable(cartData);
		}
	}
	
	//To delete the cart data of user using cart_id
	public Boolean deleteData(Integer cart_Id) {
		try {
			cartrepo.deleteById(cart_Id);
			cartrepo.flush();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error occured:"+ex);
			return false;
		}
	}
	
	
}
