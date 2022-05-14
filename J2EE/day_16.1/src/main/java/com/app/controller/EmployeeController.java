package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IEmployeeDao;

@Controller
@RequestMapping("/")
public class EmployeeController {

	// Depndencies
	@Autowired
	private IEmployeeDao empDao;
	
	@GetMapping("/")
	public String getDepartments(ModelMap map) {
		// add dept to request attr
		map.addAttribute("depts",empDao.getDepartments());
		
		return  "/choose_dept";
	}

	@GetMapping("/details")
	public String getEmployeeDetails(@RequestParam String dept, ModelMap map) {
		// set employee detail to session
		map.addAttribute("emps", empDao.getEmployees(dept));
		
		return  "/emp_details";
	}
}
