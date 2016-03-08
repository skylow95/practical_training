package com.yukon.atms.security;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yukon.atms.bank.EmployeeBank;
import com.yukon.atms.model.Employee;

@Component
class APMSUserDetailsService implements UserDetailsService { 

	public UserDetails loadUserByUsername(String username){
		
		EmployeeBank employeeBank = new EmployeeBank();
		
		Employee employee =  employeeBank.getByName( username );
		if ( employee == null ) {
			//it's a Spring Security legal way to notify the core of security framework about the user-not-found situation
			throw new UsernameNotFoundException( "User is not registered : " + username );
		}
		
		return new User( employee.getAuthName(), employee.getAuthPassword(), Arrays.asList( new SimpleGrantedAuthority( employee.getRole().getIdentifier() ) ) );
	}

}
