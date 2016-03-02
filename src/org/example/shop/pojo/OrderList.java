package org.example.shop.pojo;

import org.springframework.stereotype.Component;

@Component("orderList")
public class OrderList {
	private String userserial;
	private String goodsserial;
	public String getUserserial() {
		return userserial;
	}
	public void setUserserial(String userserial) {
		this.userserial = userserial;
	}
	public String getGoodsserial() {
		return goodsserial;
	}
	public void setGoodsserial(String goodsserial) {
		this.goodsserial = goodsserial;
	}
	
}
