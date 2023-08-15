package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		List<Employee> theEmployees = employeeService.findAll();
		
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		Employee theEmployee = employeeService.findById(theId);
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(
			@ModelAttribute("employee") @Valid Employee theEmployee,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "employees/employee-form";
		}
		else {		
			employeeService.save(theEmployee);
			
			return "redirect:/employees/list";
		}
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteById(theId);
		
		return "redirect:/employees/list";
		
	}
	
	
	@GetMapping("/search")
	public String search(@RequestParam("firstName") String theFirstName,
						 @RequestParam("lastName") String theLastName,
						 Model theModel) {
		

		if (theFirstName.trim().isEmpty() && theLastName.trim().isEmpty()) {
			return "redirect:/employees/list";
		}
		else {
			List<Employee> theEmployees =
							employeeService.searchBy(theFirstName, theLastName);
			
			theModel.addAttribute("employees", theEmployees);
			
			return "employees/list-employees";
		}
		
	}
}


















