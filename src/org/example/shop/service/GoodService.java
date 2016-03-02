package org.example.shop.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.example.shop.dao.IGoodDao;
import org.example.shop.pojo.Goods;
import org.example.shop.pojo.OrderList;
import org.example.shop.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service("goodService")
public class GoodService {
	private IGoodDao goodDao;
	private Goods good;
	private User user;
	public User getUser() {
		return user;
	}
	@Resource(name="user")
	public void setUser(User user) {
		this.user = user;
	}

	private OrderList orderList;
	
	public OrderList getOrderList() {
		return orderList;
	}
	@Resource(name="orderList")
	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}
	public IGoodDao getGoodDao() {
		return goodDao;
	}
	@Resource(name="goodDao")
	public void setGoodDao(IGoodDao goodDao) {
		this.goodDao = goodDao;
	}
	public Goods getGood() {
		return good;
	}
	@Resource(name="good")
	public void setGood(Goods good) {
		this.good = good;
	}
	
	public void findAllGoods(HttpServletRequest request)throws Exception{
		request.getSession().setAttribute("allgood", goodDao.findAllGoods());
	}
	
	public void findGoodsByType(HttpServletRequest request,@RequestParam String type){
		request.getSession().setAttribute("allgoods", goodDao.findGoodsByType(type));
	}
	
	public void findGoodsByUser(HttpServletRequest request,String serial){
		request.getSession().setAttribute(serial+"check", goodDao.findGoodsBySerial(serial));
	}
	
	public String addGoodsToUser(String userserial,String goodsserial){
		orderList.setUserserial(userserial);
		orderList.setGoodsserial(goodsserial);
		if(goodDao.addGoodToUser(orderList)){
			return "redirect:jsp/main/booklist.jsp?serial="+userserial;
		}else
			return "redirect:jsp/main/failTobuy.jsp?serial="+userserial;
	}
	
	public void deleteGoodsByUser(String userserial,String goodsserial){
		orderList.setUserserial(userserial);
		orderList.setGoodsserial(goodsserial);
		goodDao.deleteGoodFromUser(orderList);
	}
}
