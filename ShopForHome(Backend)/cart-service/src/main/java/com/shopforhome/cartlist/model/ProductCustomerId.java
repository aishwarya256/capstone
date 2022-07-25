package com.shopforhome.cartlist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCustomerId {
		private Integer product_id;
		private Integer customer_id;
}
