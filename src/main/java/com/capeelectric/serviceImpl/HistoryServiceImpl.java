package com.capeelectric.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.capeelectric.model.History;
import com.capeelectric.model.LeaveDetails;
import com.capeelectric.model.LeaveTrack;
import com.capeelectric.model.RegisterDetails;
import com.capeelectric.repository.HistoryRepository;
import com.capeelectric.repository.LeaveDetailsRepository;
import com.capeelectric.repository.LeaveTrackRepository;
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

	@Autowired
	private LeaveTrackRepository leaveTrackRepository;

	// if anyone apply leave, this code will help you fetch it to history table
	@Override
	public void addHistoryDetails(History history) {
		history.setCreatedby(history.getName());
		history.setCreateddate(LocalDateTime.now());
		historyRepository.save(history);
	}

	// if leave gets approved this code will help you
	@Override
	public LeaveTrack getLeavedetails(String empid) {

		Optional<RegisterDetails> registerDetailsRepo = registerDetailsRepository.findByEmpid(empid);
		Optional<LeaveDetails> leaveDetailsRepo = leaveDetailsRepository
				.findByExperience(registerDetailsRepo.get().getTotalexperience());

		Optional<LeaveTrack> leaveTrackRepo = leaveTrackRepository.findByEmpid(empid);

		int i = leaveDetailsRepo.get().getCasualLeave();
		i = i / 12;

		if (leaveTrackRepo.isPresent() && null != leaveTrackRepo.get()
				&& leaveTrackRepo.get().getYear().equals(LocalDate.now().getYear())) {
			Integer availableLeave = 0;
			int monthValue = LocalDate.now().getMonthValue(); // march

			switch (monthValue) {
			case 1:
				availableLeave = i * monthValue;
				break;
			case 2:
				availableLeave = i * monthValue;
				break;
			case 3:
				availableLeave = i * monthValue;
				break;
			case 4:
				availableLeave = i * monthValue;
				break;
			case 5:
				availableLeave = i * monthValue;
				break;
			case 6:
				availableLeave = i * monthValue;
				break;
			case 7:
				availableLeave = i * monthValue;
				break;
			case 8:
				availableLeave = i * monthValue;
				break;
			case 9:
				availableLeave = i * monthValue;
				break;
			case 10:
				availableLeave = i * monthValue;
				break;
			case 11:
				availableLeave = i * monthValue;
				break;
			case 12:
				availableLeave = i * monthValue;
				break;

			}

			leaveTrackRepo.get().setCarryForwardLeave(availableLeave - leaveTrackRepo.get().getCasualLeave());

			return leaveTrackRepo.get();

		} else {

			LeaveTrack leaveTrack = new LeaveTrack();
			leaveTrack.setCasualLeave(0);
			leaveTrack.setBereavementLeave(leaveDetailsRepo.get().getBereavementLeave());
			leaveTrack.setMaternityLeave(leaveDetailsRepo.get().getMaternityLeave());
			leaveTrack.setPrivilegeLeave(leaveDetailsRepo.get().getPrivilegeLeave());
			leaveTrack.setSickLeave(leaveDetailsRepo.get().getSickLeave());
			leaveTrack.setCarryForwardLeave(i);
			leaveTrack.setEmpid(empid);
			leaveTrack.setYear(LocalDate.now().getYear());
			return leaveTrackRepository.save(leaveTrack);
		}

		// return null;
	}

// here we get status approve and calculate and get the leave track details here
	@Override
	public void updateApprove(Integer historyId, String status,String empid ) {
		Optional<LeaveTrack> leaveTrackRepo = leaveTrackRepository.findByEmpid(empid);
		Optional<History> historyRepo = historyRepository.findById(historyId);
		if (historyRepo.isPresent()) {
			History historyDetails = historyRepo.get();
			String statusin=historyDetails.setStatus(status);
			System.out.println(empid);
			System.out.println(historyId);
			System.out.println(status);
			historyDetails.setApprovedBy(historyDetails.getName());
			historyDetails.setApproveddate(LocalDateTime.now());
			if(statusin=="Approved") {
				historyDetails.setMaternityLeave(leaveTrackRepo.get().getMaternityLeave());
				historyDetails.setPrivilegeLeave(leaveTrackRepo.get().getPrivilegeLeave());
				historyDetails.setBereavementLeave(leaveTrackRepo.get().getBereavementLeave());
				historyDetails.setSickLeave(leaveTrackRepo.get().getSickLeave());
				historyDetails.setCasualLeave(leaveTrackRepo.get().getCasualLeave());	
//				historyRepo.setCasualLeave(leaveTrack.getCasualLeave());
         		historyRepository.save(historyDetails);
			}
			historyRepository.save(historyDetails);
			
			System.out.println("saved successfully");
		}
	}

	// this code is for delete history
	@Override
	public void deleteHistoryDetails(List<History> history) {
	}

	@Override
	public List<History> getHistoryDetails() {
		return (List<History>) historyRepository.findAll();
	}

	@Override
	public List<History> setHistoryDetails(String empid) {
		return null;
	}

	@Override
	public History postdetails(String empid) {
		return null;
	}

	@Override
	public List<History> getHistorylist() {
		return (List<History>) historyRepository.findAll();
	}

	@Override
	public List<History> getHistoryBasedOnUser(String empid) {
		return historyRepository.findByEmpid(empid);
	}

	@Override
	public List<History> getHistoryBasedOnRole(String role) {
		return historyRepository.findByDepartment(role);
	}

	@Override
	public Optional<LeaveDetails> leavedetails(String empid) {
		Optional<RegisterDetails> registerDetailsRepo = registerDetailsRepository.findByEmpid(empid);
		Optional<LeaveDetails> leaveDetailsRepo = leaveDetailsRepository
				.findByExperience(registerDetailsRepo.get().getTotalexperience());
		System.out.println("");
		if (registerDetailsRepo.get().getTotalexperience() == leaveDetailsRepo.get().getExperience()) {
			Integer experience = registerDetailsRepo.get().getTotalexperience();
			return (Optional<LeaveDetails>) leaveDetailsRepository.findByExperience(experience);
		}
		return null;
	}

	@Override
	public List<History> empStatusDetails(String empid) {

		return historyRepository.findByEmpid(empid);
	}

	@Override
	public List<History> StatusDetails(String empid) {
		return historyRepository.findByEmpid(empid);
	}
}
