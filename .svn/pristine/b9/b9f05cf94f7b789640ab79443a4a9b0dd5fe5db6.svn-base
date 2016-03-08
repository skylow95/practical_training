package com.yukon.atms.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class UserService {
	
	public static User getCurrentUser(){
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
