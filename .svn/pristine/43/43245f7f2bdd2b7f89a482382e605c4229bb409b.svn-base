package com.yukon.atms.model;

public enum Role {
	/**
	 * User that didn't pass authentication yet
	 */
	GUEST( "ROLE_ANONYMOUS" ),
	
	/**
	 * Usual user that can ask a manager for leave.
	 * He sees only his data
	 */
	EMPLOYEE( "ROLE_EMPLOYEE" ),
	
	/** 
	 * Manager who can usually accept/decline someone's requests
	 * and see overview of whole company
	 */
	MANAGER( "ROLE_MANAGER" ),
	
	/**
	 * Administrator user in the given organization can setup all 
	 * entities (employees, absence types, departments, etc) required 
	 * for normal functioning of the application and its accessibility 
	 * for {@link Role#EMPLOYEE} and {@link Role#MANAGER} users. 
	 */
	ADMINISTRATOR( "ROLE_ADMINISTRATOR" );
	
	private String name;

	private Role( String springSecurityCompatibleName ) {
		this.name = springSecurityCompatibleName;
	}

	/**
	 * Get name of role, compatible with Spring Security naming policy (prefix ROLE_)
	 * @return name of role
	 */
	public String getIdentifier() {
		return name;
	}
	
}
