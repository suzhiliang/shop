package org.example.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
		System.out.println("request.getParameter:"+request.getParameter("serial"));
		String username = (String)request.getSession().getAttribute(request.getParameter("serial"));
		System.out.println("filter:"+username);
		if(username==null){
			HttpServletResponse response = (HttpServletResponse)arg1;
			response.sendRedirect("../jsp/login.jsp");
		}else{
			arg2.doFilter(arg0, arg1);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
