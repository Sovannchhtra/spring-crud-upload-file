package com.spring.crudImage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crudImage.entity.Employee;
import com.spring.crudImage.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmp(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmpByID(long id){
		return employeeRepository.findById(id).get();
	}
	
	public Employee saveEmp(Employee employee){
		return employeeRepository.save(employee);
	}
	
	public void deleteEmp(long id){
		employeeRepository.deleteById(id);
	}
	
	
}
