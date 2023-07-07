package com.roopa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.roopa.data.EmployeeDto;
import com.roopa.entity.EmployeeEntity;
import com.roopa.mapper.EmployeeMapper;
import com.roopa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String addEmployee(EmployeeDto employeeDto) {
		EmployeeEntity entity = employeeMapper.dtoToEntity(employeeDto);
		employeeRepository.saveAndFlush(entity);
		return "Added Employee to DataBase";
	}

	@Override
	public List<EmployeeDto> getEmployee() {
		List<EmployeeDto> empList = new ArrayList<>();
		List<EmployeeEntity> entityList = employeeRepository.findAll();
		for (EmployeeEntity entity : entityList) {
			empList.add(employeeMapper.entityToDto(entity));

		}
		return empList;
	}

	@Override
	public List<String> getNames() {
		return employeeRepository.getNames();
	}

	@Override
	public void updateName(EmployeeDto employeeDto) {
		String[] nameParts = employeeDto.getName().split(" ");
		Optional<EmployeeEntity> empOpt = employeeRepository.findById(employeeDto.getId());
		if (empOpt.isPresent()) {
			employeeRepository.updateName(nameParts[0], nameParts[1], employeeDto.getId());
		} else {
			throw new NoSuchElementException("Record with id " + employeeDto.getId() + " is not found");
		}
	}

	@Override
	public String deleteById(String id) {
		try {
			employeeRepository.deleteById(id);
			return "Employee with ID " + id + " successfully deleted";
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchElementException("Record with id " + id + " is not found");
		}
	}
}
