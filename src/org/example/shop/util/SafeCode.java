package org.example.shop.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SafeCode{
	
	public static final String RANDOMCODE = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String getCode(int randomNumber){
		return RANDOMCODE.charAt(randomNumber)+"";
	}
	
	public static Color getRandomColor(int fc,int bc){
		Random rand = new Random();
		if(fc>255||fc<0)
			fc = 255;
		if(bc>255||bc<0)
			bc = 255;
		int num = Math.abs(bc-fc);
		System.out.println("num="+num);
		int red =  rand.nextInt(num);
		int green = rand.nextInt(num);
		int blue = rand.nextInt(num);
		System.out.println(red+"//"+green+"//"+blue);
		return new Color(red,green,blue);
	}
	
}
