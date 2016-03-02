package org.example.shop.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.example.shop.dao.IUserDao;
import org.example.shop.pojo.User;
import org.example.shop.util.SafeCode;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	public IUserDao userDao;
	public User user;
	
	public User getUser() {
		return user;
	}
	
	@Resource(name="user")
	public void setUser(User user) {
		this.user = user;
	}

	public IUserDao getUserDao() {
		return userDao;
	}
	
	@Resource(name="userDao")
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	public boolean isExit(User user){
		if(userDao.findUserByName(user.getUsername())!=null)
			return true;
		else return false;
	}
	
	public void safeCode(HttpServletRequest request,HttpServletResponse response)throws Exception{
		response.setContentType("image/jpeg");
		response.setHeader("Cache-Control","no-chache");
		int width = 60;
		int height = 20;
		BufferedImage image = new BufferedImage(width,height,1);
		Graphics g = image.getGraphics();
		Random rand = new Random();
		g.setColor(SafeCode.getRandomColor(rand.nextInt(200), rand.nextInt(200)));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Arial",0,19));
		String randstring = "";
		for(int i =0;i<4;i++){
			String rands = SafeCode.getCode(rand.nextInt(36));
			randstring += rands;
			g.setColor(new Color(20+rand.nextInt(110),20+rand.nextInt(110),20+rand.nextInt(110)));
			g.drawString(rands, 13*i+8, 16);
		}
		HttpSession session = request.getSession();
		session.setAttribute("randcode", randstring);
		g.dispose();
		ServletOutputStream sos = response.getOutputStream(); 
		ImageIO.write(image, "jpeg", sos); 
	}
	
	public Map<String,String> validateOradd(HttpServletRequest request,HttpServletResponse response,boolean isAdd)throws Exception{
		String msg = new String(readRequest(request)
				.getBytes("iso-8859-1"),"utf-8");

		JSONObject json = JSONObject.fromObject(msg);
		String username = json.getString("name");
		String password = json.getString("pwd");
		
		System.out.println(username+"@@"+password);
		Random rand = new Random();
		Map<String,String> map = new HashMap<String,String>();
		user.setUsername(username);
		user.setSerial(null);
		user.setStatus(User.LEAVE);
		user.setPassword(password);
		user.setOrders(null);
		//如果该操作是用户添加则需要读取email
		String scode = json.getString("safecode");
		System.out.println(scode);
		String code = (String) request.getSession().getAttribute("randcode");
		System.out.println(code);
		if(!code.equalsIgnoreCase(scode)){
			System.out.println("wrong");
			map.put("result", "wrong");
		}else if(isAdd){
			String email = json.getString("email");
			String number = json.getString("number");
			System.out.println("!!"+number);
			user.setId(rand.nextInt(1000)*13+rand.nextInt(1000)*17+rand.nextInt(14000)*5);
			user.setSerial(number);
			user.setEmail(email);
			if(isExit(user)){
				map.put("result", "error");
				System.out.println(true);
			}else{
				map.put("result", "correct");
				userDao.add(user);
			}
		}else{
			User u = userDao.validate(user);
			if(u!=null){
				u.setStatus(User.ON_LINE);
				userDao.changeStatus(u);
				map.put("result", u.getSerial());
				request.getSession().setAttribute(u.getSerial(), u.getUsername());
				request.getSession().removeAttribute("randcode");
			}else{
				System.out.println(false);
				map.put("result", "fail");
			}
		}
		return map;
	}
	
	
	public String readRequest(HttpServletRequest request){
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader bufi = request.getReader();
			String line = null;
			while((line=bufi.readLine())!=null){
				sb.append(line);
			}
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	public Map<String,String> findNameBySerial(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String msg = new String(readRequest(request)
				.getBytes("iso-8859-1"),"utf-8");
		Map<String,String> map = new HashMap<String,String>();
		JSONObject json = JSONObject.fromObject(msg);
		String serial = json.getString("username");
		if(serial.contains("http")||serial.equals("")){
			map.put("username", "back");
			return map;
		}
		System.out.println("serial = "+serial);
		User u = userDao.findUserBySerial(serial);
		String username = u.getUsername();
		System.out.println("now username is "+username+"//");
		map.put("username", username);
		return map;
	}

	
	public void leave(HttpServletRequest request,String serial)throws Exception{
		request.getSession().removeAttribute(serial);
	}
}
