package com.roopa.service;

import java.util.List;

import com.roopa.data.EmployeeDto;

public interface EmployeeService {

	public String addEmployee(EmployeeDto employeeDto);

	public List<EmployeeDto> getEmployee();

	public List<String> getNames();

	public void updateName(EmployeeDto employeeDto);
	
	public String deleteById(String id);

	

}
