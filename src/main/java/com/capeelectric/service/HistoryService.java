package com.capeelectric.service;

import java.util.List;
import java.util.Optional;

import com.capeelectric.model.History;
import com.capeelectric.model.LeaveDetails;
import com.capeelectric.model.LeaveTrack;


public interface HistoryService {

	public void addHistoryDetails(History history) throws Exception;

//	public List<History> getHistoryDetails(String empid, String managername);


	 public void deleteHistoryDetails(Integer historyid);


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

	public void downloadHistory(List<History> history) throws Exception;

	public void delete(List<History> listOfHistory);


}
