package com.shopforhome.cartlist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="cartlist_table")
public class CartEntity {
	
	public CartEntity() {
		super();
	}
	
	public CartEntity(Integer customer_id,String product_type,
			Integer product_stock,Integer quantity_req,Integer product_price,
			String product_name,String image_url,
			Boolean offer_used,Integer discount_price) {
		this.customerId = customer_id;
		this.product_type = product_type;
		this.total_stock = product_stock;
		this.quantity_req = quantity_req;
		this.price = product_price;
		this.product_name = product_name;
		this.image_url = image_url;
		this.offer_used = offer_used;
		this.discount_price = discount_price;
	}
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer cart_id;
	
	@Column(name="customerId")
	private Integer customerId;
	
	
	@Column(name="product_type")
	private String product_type;
	
	@Column(name="total_stock")
	private Integer total_stock;
	
	@Column(name="quantity_req")
	private Integer quantity_req;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="product_name")
	private String product_name;
	
	@Column(name="image_url")
	private String image_url;
	
	@Column(name="offer_used")
	private Boolean offer_used;
	
	@Column(name="discount_price")
	private Integer discount_price;

}
