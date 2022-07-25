package com.shopforhome.wishlist.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class WishlistModel {

	private Integer product_id;
	private String image_url;
	private String product_type;
	private Integer customer_id; 
}
