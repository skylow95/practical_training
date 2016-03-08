package com.yukon.atms.service;

import java.util.Iterator;
import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yukon.atms.bank.AbsenceBank;
import com.yukon.atms.bank.AbsenceTypeBank;
import com.yukon.atms.model.Absence;
import com.yukon.atms.model.AbsenceType;

@Controller
@RequestMapping("/api/v1")
public class WebServiceController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/absences", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public Set<Absence> absences() {
		AbsenceBank absenceBank = new AbsenceBank();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return absenceBank.getAbsenesByEmploye(user.getUsername());
	}
	
	@RequestMapping(value = "/absences", method = RequestMethod.POST, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public Absence addAbsences(@RequestParam("absenceTypeId") int absenceTypeId,
			@RequestParam("employeeId") int employeeId,
			@RequestParam("startDateTime") String startDateTime,
			@RequestParam("endDateTime") String endDateTime){
		AbsenceBank absenceBank = new AbsenceBank();
		Absence absence = new Absence(startDateTime, endDateTime, absenceTypeId, employeeId);
		
		return absenceBank.addAbsence(absence);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/absences/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public Absence getAbsence(@PathVariable("id") int absenceId) {
		AbsenceBank absenceBank = new AbsenceBank();
		Iterator<Absence> iterator = absenceBank.getAbsenesByEmploye(UserService.getCurrentUser().getUsername()).iterator();
		while(iterator.hasNext()){
			Absence item = iterator.next();
			if(item.getId() == absenceId){
				return item;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/absences/{id}", method = RequestMethod.PUT)
	@ResponseBody
    public Absence updateAbsence(@PathVariable("id") int absenceId, @RequestBody int statusId) {
      
        AbsenceBank absenceBank = new AbsenceBank();
	 
        return absenceBank.updateAbsence(new Absence(absenceId, statusId));
    }

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/absences/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Integer deleteAbsence(@PathVariable("id") int absenceId) {
		AbsenceBank absenceBank = new AbsenceBank();
		Set<Absence> absence = absenceBank.getAbsenesByEmploye(UserService.getCurrentUser().getUsername());
		Iterator<Absence> iterator = absence.iterator();
		while(iterator.hasNext()){
			Absence item = iterator.next();
			if(item.getId() == absenceId){
				absence.remove(item);
				return absenceId;
			}
		}
		return null;
	
	}
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/types", method = RequestMethod.GET, headers = "Accept=application/json", produces = {
			"application/json" })
	@ResponseBody
	public Set<AbsenceType> types() {
		AbsenceTypeBank.init();
		return AbsenceTypeBank.getTypes();
	}

}
