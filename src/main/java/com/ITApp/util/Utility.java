package com.ITApp.util;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class Utility {
		@Autowired 
		JavaMailSender mailSender;
		
	public static String getSiteUrl(HttpServletRequest request) {
		String siteURL = request.getRequestURI().toString();
		return siteURL.replace(request.getServletPath(),"");
	}
	
	
}
