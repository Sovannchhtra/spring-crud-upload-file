package com.spring.crudImage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crudImage.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
