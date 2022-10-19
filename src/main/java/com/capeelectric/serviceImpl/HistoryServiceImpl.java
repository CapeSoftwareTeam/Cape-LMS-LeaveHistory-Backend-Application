package com.capeelectric.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capeelectric.model.History;
import com.capeelectric.model.LeaveDetails;
import com.capeelectric.model.RegisterDetails;
import com.capeelectric.repository.HistoryRepository;
import com.capeelectric.repository.LeaveDetailsRepository;
import com.capeelectric.repository.RegisterRepository;
import com.capeelectric.service.HistoryService;
@Service
public class HistoryServiceImpl implements HistoryService {
   
	  @Autowired
	  private RegisterRepository registerDetailsRepository;
	  
	  @Autowired
	  private HistoryRepository historyRepository;
	
	  @Autowired
	  private LeaveDetailsRepository leaveDetailsRepository;
	
	@Override
	public void addHistoryDetails(History history) {
		// TODO Auto-generated method stub
		
        Optional<RegisterDetails> registerDetails = registerDetailsRepository.findByEmpid(history.getEmpid());
		if (registerDetails.isPresent() && null != registerDetails.get() && null != history.getEmpid()
				&& registerDetails.get().getEmpid().equals(history.getEmpid())) {
			history.setLocation(registerDetails.get().getOfficelocation());
			history.setName(registerDetails.get().getName());
			history.setExperience(registerDetails.get().getTotalexperience());
			history.setDepartment(registerDetails.get().getDepartment());
			historyRepository.save(history);
		}
		
		Optional<LeaveDetails> leaveDetails= leaveDetailsRepository.findByExperience(history.getExperience());	
		
		if(leaveDetails.isPresent() && null!=leaveDetails.get() && null != history.getExperience()&& 
				leaveDetails.get().getExperience().equals(history.getExperience())) {
		    history.setCasualLeave(leaveDetails.get().getCasualLeave());
		    history.setSickLeave(leaveDetails.get().getSickLeave());
		    history.setBereavementLeave(leaveDetails.get().getBereavementLeave());
		    history.setPrivilegeLeave(leaveDetails.get().getPrivilegeLeave());
		    history.setMaternityLeave(leaveDetails.get().getMaternityLeave());
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
