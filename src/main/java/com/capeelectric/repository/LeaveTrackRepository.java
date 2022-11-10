package com.capeelectric.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capeelectric.model.LeaveTrack;


@Repository
public interface LeaveTrackRepository extends CrudRepository<LeaveTrack,Integer> {
	

	public Optional<LeaveTrack> findByEmpid(String empid);

}
