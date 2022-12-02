package com.capeelectric.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.capeelectric.model.History;

@Repository
public interface HistoryRepository extends CrudRepository<History, Integer> {

	public List<History> findByEmpid(String empId);
;                                         
	public List<History> findByEmpidAndDepartment(String empid, String role);

	public List<History> findByDepartment(String role);
	
//	public List<History> findByDepartment(String department);

//	public Optional<History> findByManagerName(String managerName);

//	public List<History> findByEmpidAndManagername(String department, String managername);
//	
//public History findByEmpid(String empid);

}
