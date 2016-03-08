package com.yukon.atms.bank;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.yukon.atms.model.Absence;
import com.yukon.atms.service.UserService;

@SuppressWarnings("rawtypes")
public class AbsenceBank {

	private static Map<String, Set> absences;

	@SuppressWarnings("unchecked")
	public void init() {
		if (absences == null) {
			EmployeeBank employeeBank = new EmployeeBank();
			employeeBank.init();
			Set forBodnarjuk = new HashSet<Absence>();
			forBodnarjuk.add(new Absence(177016, 1, "2016-02-01T09:00-09:00[America/Anchorage]",
					"2016-02-01T17:00-09:00[America/Anchorage]", null, 3557, null, 1));
			forBodnarjuk.add(new Absence(177015, 1, "2016-03-24T09:00-08:00[America/Anchorage]",
					"2016-03-26T17:00-08:00[America/Anchorage]", null, 3557, null, 2));
			forBodnarjuk.add(new Absence(177014, 1, "2016-03-24T09:00-08:00[America/Anchorage]",
					"2016-03-25T17:00-08:00[America/Anchorage]", null, 3557, null, 3));
			forBodnarjuk.add(new Absence(177002, 3, "2016-01-31T09:00-09:00[America/Anchorage]",
					"2016-01-31T17:00-09:00[America/Anchorage]", null, 3557, null, 1));
			absences = new ConcurrentHashMap<String, Set>();
			absences.put("bodnarjuk", forBodnarjuk);
			
			Set forParoviy = new HashSet<Absence>();
			   forParoviy.add( new Absence(177000, 1, "2017-02-01T09:00-09:00[America/Anchorage]", "2017-02-01T17:00-09:00[America/Anchorage]", null, 4158, null, 1));
			   forParoviy.add( new Absence(177019, 1, "2017-03-24T09:00-08:00[America/Anchorage]", "2017-03-26T17:00-08:00[America/Anchorage]", null, 4158, null, 2));
			   forParoviy.add( new Absence(177018, 1, "2017-03-24T09:00-08:00[America/Anchorage]", "2017-03-25T17:00-08:00[America/Anchorage]", null, 4158, null, 3));
			   forParoviy.add( new Absence(177007, 3, "2017-01-31T09:00-09:00[America/Anchorage]", "2017-01-31T17:00-09:00[America/Anchorage]", null, 4158, null, 2));
			   absences.put("paroviy", forParoviy);
			   
			   Set forRiaboy = new HashSet<Absence>();
			   forRiaboy.add( new Absence(177026, 1, "2018-02-01T09:00-09:00[America/Anchorage]", "2017-02-01T17:00-09:00[America/Anchorage]", null, 101857, null, 2));
			   forRiaboy.add( new Absence(177035, 1, "2018-03-24T09:00-08:00[America/Anchorage]", "2017-03-26T17:00-08:00[America/Anchorage]", null, 101857, null, 3));
			   forRiaboy.add( new Absence(177044, 1, "2018-03-24T09:00-08:00[America/Anchorage]", "2017-03-25T17:00-08:00[America/Anchorage]", null, 101857, null, 2));
			   forRiaboy.add( new Absence(177062, 3, "2018-01-31T09:00-09:00[America/Anchorage]", "2017-01-31T17:00-09:00[America/Anchorage]", null, 101857, null, 1));
			   absences.put("riaboy", forRiaboy);
			   
		}

	}

	public Set getAbsenesByEmploye(String employeeName) {
		init();
		return absences.containsKey(employeeName) ? absences.get(employeeName) : null;
	}

	public Absence addAbsence(Absence absence) {
		init();
		if (absences.containsKey(UserService.getCurrentUser().getUsername())) {
			absences.get(UserService.getCurrentUser().getUsername()).add(absence);
		} else {
			Set set = new HashSet<Absence>();
			set.add(absence);
			absences.put(UserService.getCurrentUser().getUsername(), set);
		}
		return absence;
	}
	
	public Absence updateAbsence(Absence absence) {
		init();
		 for(Object item: getAbsenesByEmploye(UserService.getCurrentUser().getUsername())){
			 Absence bean = (Absence) item;
			 if(bean.getId()==absence.getId()){
				 bean.setStatusId( absence.getStatusId() );
				 absence = bean;
				 break;
			 }
		 }
		return absence;
	}

	
}
