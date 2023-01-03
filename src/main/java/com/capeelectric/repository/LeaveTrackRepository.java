package com.capeelectric.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capeelectric.model.LeaveTrack;


@Repository
public interface LeaveTrackRepository extends CrudRepository<LeaveTrack,Integer> {

	Optional<LeaveTrack> findByEmpid(String empid);
	
	void deleteById(Integer id);

}
