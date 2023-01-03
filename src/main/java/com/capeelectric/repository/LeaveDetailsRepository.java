package com.capeelectric.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capeelectric.model.History;
import com.capeelectric.model.LeaveDetails;

@Repository
public interface LeaveDetailsRepository extends CrudRepository<LeaveDetails,Integer>{

	Optional<LeaveDetails> findByExperience(Integer experience);

	//	public List<LeaveDetails> findAll();

}
