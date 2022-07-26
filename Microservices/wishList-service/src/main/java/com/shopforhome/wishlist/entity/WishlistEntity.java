package com.shopforhome.wishlist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="wishListTable")
@Data
public class WishlistEntity {
	
	@Id
	@Column(name="wishList_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer WishList_id;
	
	@Column(name="product_id",nullable = false)
	private Integer Product_id;
	
	@Column(name="image_url")
	private String Image_url;
	
	@Column(name="product_type",nullable = false)
	private String Product_type;
	
	@Column(name="customerId",nullable = false)
	private Integer CustomerId; 

}
