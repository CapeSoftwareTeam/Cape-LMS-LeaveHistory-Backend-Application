package com.capeelectric.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.capeelectric.model.History;
import com.capeelectric.model.RegisterDetails;
import com.capeelectric.repository.HistoryRepository;
import com.capeelectric.repository.RegisterRepository;
import com.capeelectric.service.HistoryService;

public class HistoryServiceImpl implements HistoryService {
   
	  @Autowired
	  private RegisterRepository registerDetailsRepository;
	  
	  @Autowired
	  private HistoryRepository historyRepository;
	
	
	@Override
	public void addHistoryDetails(History history) {
		// TODO Auto-generated method stub
		
Optional<RegisterDetails> registerDetails = registerDetailsRepository.findByEmpid(history.getEmpid());
		
		if (registerDetails.isPresent() && null != registerDetails.get() && null != history.getEmpid()
				&& registerDetails.get().getEmpid().equals(history.getEmpid())) {
			history.setLocation(registerDetails.get().getOfficelocation());
			history.setName(registerDetails.get().getName());
			history.setDepartment(registerDetails.get().getDepartment());
			historyRepository.save(history);
		}
		
		
	}

	@Override
	public void updateHistoryDetails(History history) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<History> getHistoryDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHistoryDetails(List<History> history) {
		// TODO Auto-generated method stub
		
	}

}
