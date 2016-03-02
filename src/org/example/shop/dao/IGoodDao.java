package org.example.shop.dao;

import java.util.List;

import org.example.shop.pojo.Goods;
import org.example.shop.pojo.OrderList;
import org.example.shop.pojo.User;
import org.springframework.core.annotation.Order;

public interface IGoodDao {
	
	public List<Goods> findAllGoods();
	public void addGoods(Goods gd);
	public boolean addGoodToUser(OrderList order);
	public void deleteGoodFromUser(OrderList order);
	public List<Goods> findGoodsByType(String type);
	public List<Goods>findGoodsBySerial(String userserial);
	
}
