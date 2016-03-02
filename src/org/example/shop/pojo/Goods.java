package org.example.shop.pojo;

import org.springframework.stereotype.Component;

@Component("good")
public class Goods {
	public static final String TYPE_BOOK  = "BOOK"; 
	public static final String TYPE_CLOTHES  = "CLOTHES"; 
	public static final String TYPE_ELECT = "ELECT"; 
	public static final String TYPE_FOOD  = "FOOD"; 
	public static final String TYPE_FURNITURE  = "FURNITURE"; 
	
	
	private String type;
	private int id;
	private String name;
	private String introduce;
	private double price;
	private String maker;
	private String picture;
	private String userserial;
	private String serial;
	
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getUserserial() {
		return userserial;
	}
	public void setUserserial(String userserial) {
		this.userserial = userserial;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	
}
