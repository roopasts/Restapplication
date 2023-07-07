package com.roopa.data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	
	@NotBlank
	private String name;
	
	@NotNull(message = "Id must not be null")
	private String id;
	
	@Pattern(regexp = "[0-9]{2}-[0-9]{2}-[0-9]{4}", message = "DOB is not correct format")
	private String dob;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
