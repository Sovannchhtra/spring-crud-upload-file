package com.spring.crudImage.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.crudImage.entity.Employee;
import com.spring.crudImage.service.EmployeeService;
import com.spring.crudImage.service.util.GetUrl;
import com.spring.crudImage.service.util.ImageHandler;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/emp")
	public ResponseEntity<Map<String, Object>> getAllEmp(){
		List<Employee> emps = empService.getAllEmp();
		for(Employee employee : emps) {
			employee.setFileImage(GetUrl.GetURLString("image",employee.getFileImage()));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("status",true);
		map.put("data",emps);
		return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
	}
	
	
	@PostMapping("/create")
	public Employee createEmp(
			@RequestParam("image") MultipartFile file,
			@RequestParam("name") String name,
			@RequestParam("sex") String sex) throws IOException
	{
		
		String imageName = ImageHandler.ImageProcessHandling(file);
        Employee emp = new Employee();
        emp.setName(name);
        emp.setSex(sex);
        emp.setFileImage(imageName);
		return empService.saveEmp(emp);
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmp(
			@RequestParam("image") MultipartFile file,
			@RequestParam("name") String name,
			@RequestParam("sex") String sex,
			@PathVariable long id)throws IOException
	{
		String imageName = ImageHandler.ImageProcessHandling(file);
		Employee emp = empService.getEmpByID(id);
		Employee updateEmp = emp;
		
		updateEmp.setName(name);
		updateEmp.setSex(sex);
		updateEmp.setFileImage(imageName);
		return empService.saveEmp(updateEmp);
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmp(@PathVariable long id) {
		empService.deleteEmp(id);
	}
	
	
}
