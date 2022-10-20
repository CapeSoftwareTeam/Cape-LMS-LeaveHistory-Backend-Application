package com.capeelectric.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capeelectric.model.History;

@Service
public interface HistoryService {

	public void addHistoryDetails(History history);

	

	public List<History> getHistoryDetails();

	public void deleteHistoryDetails(List<History> history);

	public void updateHistoryDetails(History history);
	

}
