package com.roopa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.roopa.entity.EmployeeEntity;
import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

	@Query("Select employee.firstName from EmployeeEntity employee")
	List<String> getNames();

	@Transactional
	@Modifying
	@Query("UPDATE EmployeeEntity employee SET employee.firstName = (:firstName), employee.lastName = (:lastName) WHERE employee.id = (:id)")
	void updateName(String firstName, String lastName, String id);

}
