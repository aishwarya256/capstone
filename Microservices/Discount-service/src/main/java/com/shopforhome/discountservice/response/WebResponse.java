package com.shopforhome.discountservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebResponse {
	private Boolean status;
	private String msg;
	private Object data;
}
