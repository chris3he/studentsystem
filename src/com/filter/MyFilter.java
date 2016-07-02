package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MyFilter
 */
// @WebFilter("/MyFilter")
public class MyFilter implements Filter {

	public FilterConfig config;

	public MyFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		String requestUrl = req.getRequestURI();
		HttpSession session = req.getSession();
		session.removeAttribute("loginUserName");
		if (session.getAttribute("loginUserName") == null) {
			if (requestUrl.contains(config.getInitParameter("userLoginSuccess"))
					|| requestUrl.contains(config.getInitParameter("userLoginFailure"))) {
				request.getRequestDispatcher("/users/Users_login.jsp").forward(req, rep);
			} else {//之前的else位置弄错了导致User_login.jsp访问不了，所以以后要出问题了还是要找代码逻辑的问题
				chain.doFilter(req, rep);
			}
			}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		config = fConfig;
	}

}
