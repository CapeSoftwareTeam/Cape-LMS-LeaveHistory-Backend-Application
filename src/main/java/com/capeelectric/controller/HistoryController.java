package com.capeelectric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capeelectric.model.History;
import com.capeelectric.model.LeaveTrack;
import com.capeelectric.service.HistoryService;
import com.capeelectric.serviceImpl.HistoryServiceImpl;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class HistoryController {

	
	@Autowired
	private HistoryService historyService;
	
	
	@PostMapping("/history")
	public ResponseEntity<String> addHistoryDetails(@RequestBody History history){
		historyService.addHistoryDetails(history);
		return new ResponseEntity<String>("History details added successfully" ,HttpStatus.CREATED);
	}
//	@PutMapping("/history1") 
//	public ResponseEntity<String> updateHistoryDetails(@RequestBody History history){
//		historyService.updateHistoryDetails(history);
//		return new ResponseEntity<String>("History details updated",HttpStatus.OK);	
//	}
//	@GetMapping("/history2")
	@GetMapping("/history2/{empid}")
	public ResponseEntity<List<History>> getHistoryDetails(@PathVariable String empid){
		return new ResponseEntity<List<History>>(historyService.getHistoryDetails(empid),HttpStatus.OK);
	}
	@GetMapping("/history4/{empid}")
	public ResponseEntity <History> postdetails(@PathVariable String empid){
	    return new ResponseEntity<History>(historyService.postdetails(empid),HttpStatus.OK) ;	    
	} 

	@DeleteMapping("/history3") 
	public ResponseEntity<String> deleteHistoryDetails(@RequestBody List<History> history){
		historyService.deleteHistoryDetails(history);
		return new ResponseEntity<String>("History details deleted successfully",HttpStatus.OK);
	
	}	
	
	@PutMapping("/hrapprove/{historyId}/{status}") 
	public void updateHistoryDetails(@PathVariable Integer historyId,@PathVariable String status,@RequestBody History history){
		historyService.updateApprove(historyId,status);
		
		//return new ResponseEntity<void>("History details updated",HttpStatus.OK);	
		//return new ResponseEntity<String>("History details updated",HttpStatus.OK);	
	}
	
	@GetMapping("/getLeavedetails/{empId}") 
	public LeaveTrack getLeavedetails(@PathVariable String empId){
		return historyService.getLeavedetails(empId);
	}

}
