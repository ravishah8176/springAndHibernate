package com.ravi.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ravi.thymeleafdemo.entity.Employee;
import com.ravi.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService theEmployeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		theEmployeeService = employeeService;
	}
	
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// list all the employees from database
		List<Employee> theEmployees = theEmployeeService.findAll();
		
		// add to the Spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAddEmployee")
	public String showFormForAddEmployee(Model theModel) {
		
		// create model attribute to bind the data
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the employee
		theEmployeeService.save(theEmployee); // EmployeeController --> EmployeeService --> EmployeeRepository --> database
		
		// redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdateEmployee")
	public String showFormForUpdateEmployee(@RequestParam("employeeId") int theId, Model theModel) {
		
		// get the employee from the service 
		Employee theEmployee = theEmployeeService.findById(theId);
		
		// set employee in the model to pre populate the form
		theModel.addAttribute("employee", theEmployee);
		
		// send over to our form
		
		return "employees/employee-form";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the Employee
		theEmployeeService.deleteById(theId);
		
		// send over to our form
		return "redirect:/employees/list";
	}
}









