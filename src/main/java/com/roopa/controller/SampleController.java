package com.roopa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roopa.data.EmployeeDto;
import com.roopa.service.EmployeeService;

@RestController
public class SampleController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getEmployee() {
		List<EmployeeDto> response = employeeService.getEmployee();
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/names")
	public ResponseEntity<List<String>> getNames() {
		List<String> response = employeeService.getNames();
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<String> submitForm(@Valid @RequestBody EmployeeDto emp) {
		String response = employeeService.addEmployee(emp);
		return ResponseEntity.ok(response);

	}

	@PutMapping
	public ResponseEntity<String> updateName(@Valid @RequestBody EmployeeDto emp) {
		employeeService.updateName(emp);
		return ResponseEntity.ok("successfully updated name");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteName(@PathVariable String id) {
		String response = employeeService.deleteById(id);
		return ResponseEntity.ok(response);

	}

}
