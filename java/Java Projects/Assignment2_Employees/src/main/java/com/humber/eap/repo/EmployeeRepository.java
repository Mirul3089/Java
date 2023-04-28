package com.humber.eap.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.humber.eap.model.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Integer> {
	

	@Query("SELECT distinct(e) FROM Employees e LEFT OUTER JOIN "
			+ "Department d ON e.id = d.ID "
			+ "WHERE e.firstName like %:search% OR "
			+ "e.lastName like %:search%  OR "
			+ "e.role like %:search% OR "
			+ "e.dept.name like %:search%")
	List<Employees> searchByAll(@Param("search") String search);
}
