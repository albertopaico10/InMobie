package com.inmobile.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String uri = request.getRequestURI();
		System.out.println("URL DE LLAMADA: "+uri);
		String prefix = request.getSession().getServletContext().getContextPath();
		if(!(prefix+"/inicio.htm").equals(uri)
				&& !(prefix+"/continue.htm").equals(uri)
				&& !(prefix+"/getProvince.htm").equals(uri)
				&& !(prefix+"/getDistrict.htm").equals(uri)
				&& !(prefix+"/registerProvider.htm").equals(uri)
				&& !(prefix+"/registerDistrictProvider.htm").equals(uri)
				&& !(prefix+"/registerRestaurant.htm").equals(uri)
				&& !(prefix+"/saveScheduler.htm").equals(uri)
				&& !(prefix+"/validateUser.htm").equals(uri)){
			System.out.println("ENTRO ACA!");
			System.out.println("--->"+request.getSession().getAttribute("isUserLogin"));
			boolean redirectLogin = true;
			if(request.getSession().getAttribute("isUserLogin") != null){
				String isUserLogin = request.getSession().getAttribute("isUserLogin").toString();
				if("1".equals(isUserLogin)){
					redirectLogin = false;
				}
			}
			if(redirectLogin){
				response.sendRedirect("inicio.htm");
			}
			return false;
		}
		return true;
	}

}
