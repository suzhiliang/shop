package org.example.shop.dao;

import org.example.shop.pojo.User;

public interface IUserDao {
	public void add(User user);
	public User findUserByName(String username);
	public User findUserBySerial(String serial);
	public User validate(User user);
	public void changeStatus(User user);
}
