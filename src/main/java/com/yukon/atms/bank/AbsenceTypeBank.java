package com.yukon.atms.bank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.yukon.atms.model.AbsenceType;

@SuppressWarnings("rawtypes")
public class AbsenceTypeBank {
	 
	private static Set types;
	 
	@SuppressWarnings("unchecked")
	public static void init(){
		types = new HashSet<AbsenceType>(); 
		Gson gson = new Gson();
		types.add(new AbsenceType(4158, "FOR_MANAGER", null, "DAY_OFF",gson.fromJson("{\"DUTCH\": \"For manager only_NL\", \"GERMAN\": \"For manager only_DE\", \"ENGLISH\": \"For manager only\"}",HashMap.class) ));
		types.add(new AbsenceType(3557, "VACATION", null, "DAY_OFF", gson.fromJson("{\"ENGLISH\": \"Vacation\"}",HashMap.class)));
		types.add(new AbsenceType(101857, "DAY_OFF", null, "DAY_OFF",gson.fromJson("{\"DUTCH\": \"1\", \"GERMAN\": \"123\", \"ENGLISH\": \"Day off\"}",HashMap.class)));
	} 
	 
	public static Set getTypes() {
		return types;
	} 
}
