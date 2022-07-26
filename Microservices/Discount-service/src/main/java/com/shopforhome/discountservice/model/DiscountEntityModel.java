package com.shopforhome.discountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountEntityModel {

	private Integer product_id;
	private Integer discount_percentage;
	private Integer actual_price;
	private Integer discount_price;
}
