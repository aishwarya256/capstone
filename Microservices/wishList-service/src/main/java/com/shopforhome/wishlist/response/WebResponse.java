package com.shopforhome.wishlist.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebResponse {
	private Boolean status;
	private Object data;
}
