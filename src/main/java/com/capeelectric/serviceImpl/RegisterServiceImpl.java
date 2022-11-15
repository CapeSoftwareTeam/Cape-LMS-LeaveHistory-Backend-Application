package com.capeelectric.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capeelectric.model.RegisterDetails;
import com.capeelectric.repository.RegisterRepository;
import com.capeelectric.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

		@Autowired
		private RegisterRepository registerRepo;

		@Override
		public Optional<RegisterDetails> memberDetails(String empid) {
		
			return (Optional<RegisterDetails>) registerRepo.findByEmpid(empid);
			}

	}

