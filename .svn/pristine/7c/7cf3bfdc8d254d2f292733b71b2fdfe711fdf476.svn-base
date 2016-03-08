package com.yukon.atms.bank;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.yukon.atms.model.Employee;
import com.yukon.atms.model.Role;

public class EmployeeBank {
	private static Map<String,Employee> users;
	
	public void init(){
		if(users ==  null){
		users = new ConcurrentHashMap<String, Employee>(); 
		users.put( "bodnarjuk", new Employee( "bodnarjuk", "$2a$04$X3ljPOAnGmGRkd0RJ9/oQeZ/.Zcx9unpjJSLrYWNYpfFe0tZM2J2G",Role.EMPLOYEE));
		users.put( "riaboy", new Employee( "riaboy", "$2a$04$//sXGiL0/um0kEfM1RfmZu4RtYgJDDvMfeNxyHihTtlbDgmUrz8Mq",Role.EMPLOYEE));
		users.put( "paroviy", new Employee( "paroviy", "$2a$04$qD1YPB9hU4F/OuS.V7n2AepfPLOMNXAKk3plLtpKIbd.L4iV/GuG2",Role.EMPLOYEE));
		}
	}
	
	public boolean isUser(String employee){
		init();
		return users.containsKey(employee);
	}
	
	public Employee getByName(String name){
		init(); 
			if(isUser(name)){
			  return users.get(name);	
			
		}
		return null;
	}
}
