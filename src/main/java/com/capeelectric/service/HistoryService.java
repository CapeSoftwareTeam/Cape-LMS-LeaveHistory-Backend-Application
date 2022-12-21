package com.capeelectric.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capeelectric.model.History;
import com.capeelectric.model.LeaveDetails;
import com.capeelectric.model.LeaveTrack;
import com.capeelectric.model.RegisterDetails;

@Service
public interface HistoryService {

	public void addHistoryDetails(History history) throws Exception;

//	public List<History> getHistoryDetails(String empid, String managername);

	void deleteHistoryDetails(Integer historyId);

//	List<History> getHistoryDetails(String empid);

	public List<History> setHistoryDetails(String empid);

	History postdetails(String empid);

	public void updateApprove(Integer historyId,String empid, String status);

	public LeaveTrack getLeavedetails(String empid);
	
	public  Optional<LeaveTrack> LeaveTrackPopUpdetails(String empid);

	public List<History> getHistorylist();

	public List<History> getHistoryBasedOnUser(String empid);

	public List<History> getHistoryBasedOnRole(String role);

	public Optional<LeaveDetails> leavedetails(String empid);

	public List<History> empStatusDetails(String empid);

	public List<History> StatusDetails(String empid);

	public List<History> getHistoryDetails();

//	List<History> getHistoryDetails(String department);

	
    public void mystatusdelete(Integer historyId);

	public void revertcalculation(Integer historyId, String status, String empid);

	public void updateFileHistory(Integer historyId, Integer fileId);

	public Optional<History> getHistoryFile(Integer historyId);

}
