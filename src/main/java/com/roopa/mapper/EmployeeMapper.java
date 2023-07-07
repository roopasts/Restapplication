package com.roopa.mapper;

import org.springframework.stereotype.Component;

import com.roopa.data.EmployeeDto;
import com.roopa.entity.EmployeeEntity;

@Component
public class EmployeeMapper {

	public EmployeeEntity dtoToEntity(EmployeeDto dto) {

		EmployeeEntity entity = new EmployeeEntity();
		String fullName = dto.getName();
		String[] nameParts = fullName.split(" ");
		entity.setFirstName(nameParts[0]);
		entity.setLastName(nameParts[1]);
		entity.setDob(dto.getDob());
		entity.setId(dto.getId());
		return entity;

	}

	public EmployeeDto entityToDto(EmployeeEntity entity) {

		EmployeeDto dto = new EmployeeDto();
		dto.setDob(entity.getDob());
		dto.setId(entity.getId());
		dto.setName(entity.getFirstName() + " " + entity.getLastName());
		return dto;

	}
}
