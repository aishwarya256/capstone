package com.shopforhome.products.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WebResponse {
	private Boolean status;
	private String msg;
	private Object data;
}
