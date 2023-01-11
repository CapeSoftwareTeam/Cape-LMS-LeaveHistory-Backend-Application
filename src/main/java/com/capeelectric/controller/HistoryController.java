package com.capeelectric.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.capeelectric.exception.ApplyLeaveException;
import com.capeelectric.model.History;
import com.capeelectric.model.LeaveDetails;
import com.capeelectric.model.LeaveTrack;
import com.capeelectric.model.RegisterDetails;
import com.capeelectric.service.HistoryService;
import com.capeelectric.service.RegisterService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class HistoryController {

	private static final Logger logger = LoggerFactory.getLogger(HistoryController.class);
	
	@Autowired
	private HistoryService historyService;

	@Autowired
	private RegisterService registerService;

	//it adds details for every request
	@PostMapping("/history")
	public ResponseEntity<String> addHistoryDetails(@RequestBody History history) throws Exception {
		historyService.addHistoryDetails(history);
		logger.info(" The leave request has been added successfully");
		return new ResponseEntity<String>("History details added successfully", HttpStatus.CREATED);
	}
	@GetMapping("/getHistoryDetails")
	public ResponseEntity<List<History>> getHistorylist() {

		return new ResponseEntity<List<History>>(historyService.getHistorylist(), HttpStatus.CREATED);
	}


	@GetMapping("/getHistory")
	public ResponseEntity<String> getHistorylist(@RequestBody History history) {
		historyService.getHistorylist();
		return new ResponseEntity<String>("History details get successfully", HttpStatus.CREATED);
	}

//	@PutMapping("/history1") 
//	public ResponseEntity<String> updateHistoryDetails(@RequestBody History history){
//		historyService.updateHistoryDetails(history);
//		return new ResponseEntity<String>("History details updated",HttpStatus.OK);	
//	}
//	@GetMapping("/history2")
	@GetMapping("/history2")
	public ResponseEntity<List<History>> getHistoryDetails() {
		return new ResponseEntity<List<History>>(historyService.getHistoryDetails(), HttpStatus.OK);
	}

	@GetMapping("/history4/{empid}")
	public ResponseEntity<History> postdetails(@PathVariable String empid) {
		return new ResponseEntity<History>(historyService.postdetails(empid), HttpStatus.OK);
	}
	
    //To get the not submitted data
	@GetMapping("/matseparation/{empid}")
	public ResponseEntity<List<History>> empStatusDetails(@PathVariable String empid) {
		logger.info("all not submitted data is passed successfully");
		return new ResponseEntity<List<History>>(historyService.empStatusDetails(empid), HttpStatus.OK);
	}
	
	@DeleteMapping("/history3/{historyId}")
	public ResponseEntity<String> deleteHistoryDetails(@PathVariable Integer historyId) {
		historyService.deleteHistoryDetails(historyId);
		logger.info("data deleted successfully");
		return new ResponseEntity<String>("History details deleted successfully", HttpStatus.OK);

	}
	
    // status update and calculation takes place
	@PutMapping("/hrapprove/{historyId}/{empid}/{status}")
	public void updateHistoryDetails(@PathVariable Integer historyId, @PathVariable String empid,
			@PathVariable String status) throws ApplyLeaveException, Exception{
		historyService.updateApprove(historyId, empid, status);
		logger.info("data updated in history table successfully");
		
	}
	 
    //status gets updated to cancelled and calculation reverts 
	@PutMapping("/updateHistory/{historyId}/{status}/{empid}")
	public void revertcalculation(@PathVariable Integer historyId,@PathVariable String empid, @PathVariable String status) {
		historyService.revertcalculation(historyId, empid, status);
		logger.info("data updated as cancelled and revert calculation is successful");
	}
	
//	@PutMapping("/yearUpdate")
//	public void updateleavetrack() {
//		historyService.updateleavetrack();
//	}

    //gets leave track details for progress bar calculation and display in home page
	@GetMapping("/getLeavedetails/{empid}")
	public LeaveTrack getLeavedetails(@PathVariable String empid) {
		logger.info("data from leavetrack has been passed successfully");
		return historyService.getLeavedetails(empid);
	}
	
    //gets individual member details
	@GetMapping("/getMemberdetails/{empid}")
	public ResponseEntity<Optional<RegisterDetails>> memberDetails(@PathVariable String empid) {
		logger.info("data from register has been passed successfully");
		return new ResponseEntity<Optional<RegisterDetails>>(registerService.memberDetails(empid), HttpStatus.OK);
	}

	@GetMapping("/getHistoryBasedOnUser/{empid}")
	public ResponseEntity<List<History>> getHistoryBasedOnUser(@PathVariable String empid) {
		return new ResponseEntity<List<History>>(historyService.getHistoryBasedOnUser(empid), HttpStatus.OK);

	}

	@GetMapping("/getHistoryBasedOnRole/{role}")
	public ResponseEntity<List<History>> getHistoryBasedOnRole(@PathVariable String role) {
		return new ResponseEntity<List<History>>(historyService.getHistoryBasedOnRole(role), HttpStatus.OK);

	}
	//gets total leave details for progress bar display in home page
	@GetMapping("/leaveDetails/{empid}")
	public ResponseEntity<Optional<LeaveDetails>> leavedetails(@PathVariable String empid) {
		logger.info("data from leavedetails table for calculation and display has been passed successfully");
		return new ResponseEntity<Optional<LeaveDetails>>(historyService.leavedetails(empid), HttpStatus.OK);
	}
	
    //deletes data based on history id in history table
	@DeleteMapping("/mystatusDel/{historyId}")
	public ResponseEntity<String> mystatusdelete(@PathVariable Integer historyId) {
		historyService.mystatusdelete(historyId);
		logger.info("data deleted successfully");
		return new ResponseEntity<String>("History details deleted successfully", HttpStatus.OK);

	}
    //get the latest updated data for displaying whether lop is present or not
	@GetMapping("/leavetrack/{empid}")
	public Optional<LeaveTrack> LeaveTrackPopUpdetails(@PathVariable String empid) {
		logger.info("leavetrack data has been passed successfully");
		return historyService.LeaveTrackPopUpdetails(empid);
	}
    
    //file upload 
	@PutMapping("/fileUpdate/{historyId}/{fileId}")
	public void updateFile(@PathVariable Integer historyId, @PathVariable Integer fileId) {
		historyService.updateFileHistory(historyId, fileId);
		logger.info("file id uploaded successfully");
	}

	@GetMapping("/getHistoryId/{historyId}")
	public Optional<History> getHistoryId(@PathVariable Integer historyId) {
		return historyService.getHistoryFile(historyId);
	}

	@PutMapping("/downloadHistory")
	public void downloadHistory(@RequestBody List<History> history) throws Exception {
		historyService.downloadHistory(history);

	}
	
	@GetMapping("/pdfDownload")
	public ResponseEntity<Resource> pdfDownload() throws Exception {
		Path path = Paths.get("hi.pdf");
		Resource resource = null;
		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "hi.pdf" + "\"").body(resource);
	}
	

}