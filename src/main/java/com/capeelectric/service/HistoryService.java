package com.capeelectric.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capeelectric.model.History;
import com.capeelectric.model.LeaveTrack;
import com.capeelectric.model.RegisterDetails;

@Service
public interface HistoryService {

	public void addHistoryDetails(History history);

	public List<History> getHistoryDetails();

	void deleteHistoryDetails(List<History> history);

	List<History> getHistoryDetails(String empid);

	public List<History> setHistoryDetails(String empid);

	History postdetails(String empid);

	public void updateApprove(Integer historyId, String status);

	public LeaveTrack getLeavedetails(String empid);

	public List<History> getHistorylist();

	public List<History> getHistoryBasedOnUser(String empid);

	public List<History> getHistoryBasedOnRole(String role);

}
