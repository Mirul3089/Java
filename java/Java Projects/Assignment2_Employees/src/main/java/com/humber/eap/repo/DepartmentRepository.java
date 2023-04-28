package com.humber.eap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.humber.eap.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
