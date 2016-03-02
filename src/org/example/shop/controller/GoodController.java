package org.example.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.example.shop.service.GoodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("goodController")

public class GoodController {
	private GoodService goodService;
	
	
	public GoodService getGoodService() {
		return goodService;
	}

	@Resource(name="goodService")
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}

	/**
	 * 用户购买物品的controller
	 * @param request
	 * @param serial
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/buy")
	public String showAllGoods(HttpServletRequest request,@RequestParam("goodsserial") String goodsserial,@RequestParam("userserial") String userserial) throws Exception{
			
		return goodService.addGoodsToUser(userserial, goodsserial);
	}
	
	/**
	 * 根据请求中的type参数，列出相应的货物
	 * @param request
	 * @param serial
	 * @param type
	 * @return
	 */
	@RequestMapping("/showgoods")
	@ResponseBody
	public String showGoodsByType(HttpServletRequest request,@RequestParam("type") String type){
		System.out.println("type is :"+type);
		goodService.findGoodsByType(request, type);
		return "";
	}
	
	/**
	 * 用户查询购物车
	 * @param request
	 * @param serial
	 * @return
	 */
	@RequestMapping("/check")
	@ResponseBody
	public String checkGoodsByUser(HttpServletRequest request,@RequestParam("serial") String serial){
		goodService.findGoodsByUser(request, serial);
		return "";
	}
	
	@RequestMapping("/delete")
	public String deleteGoodsBuUser(HttpServletRequest request,@RequestParam("userserial") String userserial,
											@RequestParam("goodsserial") String goodsserial){
		goodService.deleteGoodsByUser(userserial, goodsserial);
		goodService.findGoodsByUser(request, userserial);
		return "redirect:jsp/main/mylist.jsp?serial="+userserial;
	}
	
}
