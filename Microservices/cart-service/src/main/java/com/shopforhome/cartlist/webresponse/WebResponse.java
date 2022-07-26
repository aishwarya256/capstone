package com.shopforhome.cartlist.webresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResponse {
	
	private Boolean status;
	private String msg;
	private Object data;
}
