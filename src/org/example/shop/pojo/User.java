package org.example.shop.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("user")
public class User {
	public static final int ON_LINE = 0;
	public static final int LEAVE = 1;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private int id;
	private String serial;
	private String username;
	private String password;
	private String email;
	private int status;
	private List<OrderList> orders;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private List<OrderList> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderList> orders) {
		this.orders = orders;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String id) {
		this.serial = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
