package com.skillstorm.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter  implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter init");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filtering...");
		HttpServletRequest req = (HttpServletRequest) request;
		if (req.getSession().getAttribute("userInfo") == null) {
			((HttpServletResponse)response).setStatus(401);
		}else {
			chain.doFilter(req, response);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Filter destroy");
	}

}
