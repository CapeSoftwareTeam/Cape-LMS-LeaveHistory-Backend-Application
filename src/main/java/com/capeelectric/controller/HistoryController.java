package com.capeelectric.controller;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

	@Autowired
	private HistoryService historyService;

	@Autowired
	private RegisterService registerService;

	@PostMapping("/history")
	public ResponseEntity<String> addHistoryDetails(@RequestBody History history) throws Exception {
		historyService.addHistoryDetails(history);
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

	@GetMapping("/matseparation/{empid}")
	public ResponseEntity<List<History>> empStatusDetails(@PathVariable String empid) {
		return new ResponseEntity<List<History>>(historyService.empStatusDetails(empid), HttpStatus.OK);
	}

	@GetMapping("/matAprrovalseparation/{empid}")
	public ResponseEntity<List<History>> StatusDetails(@PathVariable String empid) {
		return new ResponseEntity<List<History>>(historyService.StatusDetails(empid), HttpStatus.OK);
	}

	@DeleteMapping("/history3/{historyId}")
	public ResponseEntity<String> deleteHistoryDetails(@PathVariable Integer historyId) {
		historyService.deleteHistoryDetails(historyId);
		return new ResponseEntity<String>("History details deleted successfully", HttpStatus.OK);

	}

	@PutMapping("/hrapprove/{historyId}/{empid}/{status}")
	public void updateHistoryDetails(@PathVariable Integer historyId, @PathVariable String empid,
			@PathVariable String status) throws ApplyLeaveException, Exception{
		historyService.updateApprove(historyId, empid, status);

		// return new ResponseEntity<void>("History details updated",HttpStatus.OK);
		// return new ResponseEntity<String>("History details updated",HttpStatus.OK);
	}

	@PutMapping("/updateHistory/{historyId}/{status}/{empid}")
	public void revertcalculation(@PathVariable Integer historyId,
			@PathVariable String empid, @PathVariable String status) {
		historyService.revertcalculation(historyId, empid, status);
	}
	
//	@PutMapping("/yearUpdate")
//	public void updateleavetrack() {
//		historyService.updateleavetrack();
//	}

	@GetMapping("/getLeavedetails/{empid}")
	public LeaveTrack getLeavedetails(@PathVariable String empid) {
		return historyService.getLeavedetails(empid);
	}

	@GetMapping("/getMemberdetails/{empid}")
	public ResponseEntity<Optional<RegisterDetails>> memberDetails(@PathVariable String empid) {
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

	@GetMapping("/leaveDetails/{empid}")
	public ResponseEntity<Optional<LeaveDetails>> leavedetails(@PathVariable String empid) {
		return new ResponseEntity<Optional<LeaveDetails>>(historyService.leavedetails(empid), HttpStatus.OK);
	}

	@DeleteMapping("/mystatusDel/{historyId}")
	public ResponseEntity<String> mystatusdelete(@PathVariable Integer historyId) {
		historyService.mystatusdelete(historyId);
		return new ResponseEntity<String>("History details deleted successfully", HttpStatus.OK);

	}

	@GetMapping("/leavetrack/{empid}")
	public Optional<LeaveTrack> LeaveTrackPopUpdetails(@PathVariable String empid) {
		return historyService.LeaveTrackPopUpdetails(empid);
	}

	@PutMapping("/fileUpdate/{historyId}/{fileId}")
	public void updateFile(@PathVariable Integer historyId, @PathVariable Integer fileId) {
		historyService.updateFileHistory(historyId, fileId);

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