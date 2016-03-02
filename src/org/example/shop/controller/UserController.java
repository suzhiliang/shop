package org.example.shop.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.example.shop.pojo.User;
import org.example.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("userController")
public class UserController {
	public UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}
	
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/add")
	@ResponseBody
	public Map<String,String> add(HttpServletRequest request,HttpServletResponse response)throws Exception{
		return userService.validateOradd(request, response, true);
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Map<String,String> login(HttpServletRequest request,HttpServletResponse response)throws Exception{
		return userService.validateOradd(request, response, false);
	}
	
	@RequestMapping("/safecode")
	public void safedCode(HttpServletRequest request,HttpServletResponse response)throws Exception{
		userService.safeCode(request, response);
	}
	
	@RequestMapping("/index")
	@ResponseBody
	public Map<String,String> getLogoName(HttpServletRequest request,HttpServletResponse response)throws Exception{
		return userService.findNameBySerial(request, response);
	}
	
	@RequestMapping(value = "/leave",method=RequestMethod.GET)
	public String leave(HttpServletRequest request,@RequestParam String serial)throws Exception{
		userService.leave(request, serial);
		return "redirect:jsp/login.jsp";
	}
}
