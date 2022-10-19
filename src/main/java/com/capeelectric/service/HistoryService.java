package com.capeelectric.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capeelectric.model.History;

@Service
public interface HistoryService {

	void addHistoryDetails(History history);

	void updateHistoryDetails(History history);

	List<History> getHistoryDetails();

	void deleteHistoryDetails(List<History> history);
	

}
