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

}