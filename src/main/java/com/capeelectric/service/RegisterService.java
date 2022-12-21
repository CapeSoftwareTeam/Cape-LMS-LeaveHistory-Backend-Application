package com.capeelectric.service;

import java.util.List;
import java.util.Optional;

import com.capeelectric.model.RegisterDetails;

public interface RegisterService {

	public Optional<RegisterDetails> memberDetails(String empid);



//	public Optional<RegisterDetails> teamDetails(String department, String officelocation);


	
}
