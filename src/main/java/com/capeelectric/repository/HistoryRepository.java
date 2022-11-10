package com.capeelectric.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capeelectric.model.History;


@Repository
public interface HistoryRepository extends CrudRepository<History,Integer> {


	

	public List<History> findByEmpid(String empId);

}
