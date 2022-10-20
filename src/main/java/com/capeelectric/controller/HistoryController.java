package com.capeelectric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capeelectric.model.History;
import com.capeelectric.service.HistoryService;
@RestController
public class HistoryController {

	
	@Autowired
	private HistoryService historyService;
	
	
	@PostMapping("/history")
	public ResponseEntity<String> addHistoryDetails(@RequestBody History history){
		historyService.addHistoryDetails(history);
		return new ResponseEntity<String>("History details added successfully" ,HttpStatus.CREATED );
	}
	@PutMapping("/history1") 
	public ResponseEntity<String> putHistoryDetails(@RequestBody History history){
		historyService.updateHistoryDetails(history);
		return new ResponseEntity<String>("History details updated",HttpStatus.OK);
		
	}
	@GetMapping("/history2")
	public ResponseEntity<List<History>> retrive(){
		 
		return new ResponseEntity<List<History>>(historyService.getHistoryDetails(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/history3")
	public ResponseEntity<String> deleteHistoryDetails(@RequestBody List<History> history){
		historyService.deleteHistoryDetails(history);
		return new ResponseEntity<String>("History details deleted successfully",HttpStatus.ACCEPTED);
		
	
	  
	
	
	}	
}
