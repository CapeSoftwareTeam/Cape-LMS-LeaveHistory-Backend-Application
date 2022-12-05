package com.capeelectric.serviceImpl;

import com.capeelectric.config.AWSConfig;
import com.capeelectric.model.EmailContent;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
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
	
	  @Autowired
      private RestTemplate restTemplate;
       
      @Autowired
      private AWSConfig awsConfiguration;

	// if anyone apply leave, this code will help you fetch it to history table
	@Override
	public void addHistoryDetails(History history) throws Exception {
		history.setCreatedby(history.getName());
		history.setCreateddate(LocalDateTime.now());
		historyRepository.save(history);	
		sendEmailForLeaveApply(history.getManageremail(),"sangeetha@capindia.net","subject: Need in response to the leave applied from the"+history.getEmpid()+"-"+history.getName()+"\\r\\n"
				
				                +"\\r\\n"
				                +"This is to inform you that"+history.getEmpid()+"-"+history.getName()+"has applied for the leave"+ history.getLeaveType()+"on"+history.getTodate()+"-"+history.getTodate()+"\\r\\n"
				                +"\\r\\n"
				                +"Do login to LMS application to know the details.\\r\\n"
				                +"\\r\\n"
				                +"Regards,\\r\\n"
				                +"Leave Management System.\\r\\n"
				                +history.getEmpid()+"-"+history.getName()
				);
	}

	// if leave gets approved this code will help you
	@Override
	public LeaveTrack getLeavedetails(String empid) {
		  System.out.println("aaaaaaaaaaaasssssssssssssssssssssss");
		Optional<RegisterDetails> registerDetailsRepo = registerDetailsRepository.findByEmpid(empid);
		Optional<LeaveDetails> leaveDetailsRepo = leaveDetailsRepository.findByExperience(registerDetailsRepo.get().getTotalexperience());

		Optional<LeaveTrack> leaveTrackRepo = leaveTrackRepository.findByEmpid(empid);

		int i = leaveDetailsRepo.get().getCasualLeave();
		i= i / 12;

		if (leaveTrackRepo.isPresent() && null != leaveTrackRepo.get()
				&& leaveTrackRepo.get().getYear().equals(LocalDate.now().getYear())) {
			System.out.println("issssssssssssssssssssssssssssssssssss");
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
            System.out.println("usssssssssssssssssssssss");
			LeaveTrack leaveTrack = new LeaveTrack();
			leaveTrack.setCasualLeave(leaveDetailsRepo.get().getCasualLeave());
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
		Optional<RegisterDetails> registerDetailsRepo = registerDetailsRepository.findByEmpid(empid);
		Optional<History> historyRepo = historyRepository.findById(historyId);
		String sangeethaEmpid=historyRepo.get().getEmpid();
		Optional<LeaveTrack> leaveTrackRepo = leaveTrackRepository.findByEmpid(sangeethaEmpid);
		if (historyRepo.isPresent()) {
			History historyDetails = historyRepo.get();
			
			LeaveTrack leaveTrack = leaveTrackRepo.get();
//			System.out.println(empid);
//			System.out.println(historyId);
//			System.out.println(status);
			
			if(status.equalsIgnoreCase("Approved")) 
				if(historyDetails.getLeaveType().equalsIgnoreCase("casual")) {
					if(leaveTrackRepo.get().getCarryForwardLeave()!=null && leaveTrackRepo.get().getCarryForwardLeave()>0) {
						if(historyDetails.getNoofdays()<=(leaveTrackRepo.get().getCarryForwardLeave())) {
							int carry=leaveTrackRepo.get().getCarryForwardLeave()-historyDetails.getNoofdays();
							int casual=leaveTrackRepo.get().getCasualLeave()-leaveTrackRepo.get().getCarryForwardLeave();
							leaveTrack.setCasualLeave(casual);
							leaveTrack.setCarryForwardLeave(carry);
							leaveTrackRepository.save(leaveTrack);
						}
						else {
//							int casualForless=leaveTrackRepo.get().getCasualLeave()-historyDetails.getNoofdays();
							int lop=historyDetails.getNoofdays()-leaveTrackRepo.get().getCarryForwardLeave();
//							leaveTrack.setCasualLeave(casualForless);
							leaveTrack.setCarryForwardLeave(0);
							leaveTrackRepository.save(leaveTrack);
							historyDetails.setLopdays(lop);
						}
					}
					else {
						int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getCarryForwardLeave();
						historyDetails.setLopdays(lop);
						leaveTrackRepository.save(leaveTrack);
					}
					
				}
				 if(historyDetails.getLeaveType().equalsIgnoreCase("sick")) {
					if(leaveTrackRepo.get().getSickLeave()!= null && leaveTrackRepo.get().getSickLeave() > 0) {
						if(historyDetails.getNoofdays()<=leaveTrackRepo.get().getSickLeave()) {
					    int num=historyDetails.getNoofdays();
					   	int sick= leaveTrackRepo.get().getSickLeave()-historyDetails.getNoofdays() ;
							if(sick < 1) {
								leaveTrack.setSickLeave(0);
								historyDetails.setLopdays(num);
								leaveTrackRepository.save(leaveTrack);
							
							}else {
								leaveTrack.setSickLeave(sick);
								leaveTrackRepository.save(leaveTrack);
							}
							
						}
						else {
							int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getSickLeave();
							System.out.println("sick"+lop);
							leaveTrack.setSickLeave(lop);
							historyDetails.setLopdays(lop);
							leaveTrackRepository.save(leaveTrack);
							}
					}
						
					
					else {
							int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getSickLeave();
							historyDetails.setLopdays(lop);
							leaveTrackRepository.save(leaveTrack);
						}
				 }
	
				 if(historyDetails.getLeaveType().equalsIgnoreCase("sick")) {
						if(leaveTrackRepo.get().getSickLeave()!= null && leaveTrackRepo.get().getSickLeave() > 0) {
							if(historyDetails.getNoofdays()<=leaveTrackRepo.get().getSickLeave()) {
						    int num=historyDetails.getNoofdays();
						   	int sick= leaveTrackRepo.get().getSickLeave()-historyDetails.getNoofdays() ;
								if(sick < 1) {
									leaveTrack.setSickLeave(0);
									historyDetails.setLopdays(num);
									leaveTrackRepository.save(leaveTrack);
								
								}else {
									leaveTrack.setSickLeave(sick);
									leaveTrackRepository.save(leaveTrack);
								}
								
							}
							else {
								int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getSickLeave();
								System.out.println("sick"+lop);
								leaveTrack.setSickLeave(lop);
								historyDetails.setLopdays(lop);
								leaveTrackRepository.save(leaveTrack);
								}
						}
							
						
						else {
								int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getSickLeave();
								historyDetails.setLopdays(lop);
								leaveTrackRepository.save(leaveTrack);
							}
					 }
				 if(historyDetails.getLeaveType().equalsIgnoreCase("bereavement")) {
						if(leaveTrackRepo.get().getBereavementLeave()!= null && leaveTrackRepo.get().getBereavementLeave() > 0) {
							if(historyDetails.getNoofdays()<=leaveTrackRepo.get().getBereavementLeave()) {
						    int num=historyDetails.getNoofdays();
						   	int sick= leaveTrackRepo.get().getBereavementLeave()-historyDetails.getNoofdays() ;
								if(sick < 1) {
									leaveTrack.setBereavementLeave(0);
									historyDetails.setLopdays(num);
									leaveTrackRepository.save(leaveTrack);
								
								}else {
									leaveTrack.setBereavementLeave(sick);
									leaveTrackRepository.save(leaveTrack);
								}
								
							}
							else {
								int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getBereavementLeave();
								System.out.println("sick"+lop);
								leaveTrack.setBereavementLeave(lop);
								historyDetails.setLopdays(lop);
								leaveTrackRepository.save(leaveTrack);
								}
						}
							
						
						else {
								int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getBereavementLeave();
								historyDetails.setLopdays(lop);
								leaveTrackRepository.save(leaveTrack);
							}
					 }
				 if(historyDetails.getLeaveType().equalsIgnoreCase("privilege")) {
						if(leaveTrackRepo.get().getPrivilegeLeave()!= null && leaveTrackRepo.get().getPrivilegeLeave() > 0) {
							if(historyDetails.getNoofdays()<=leaveTrackRepo.get().getPrivilegeLeave()) {
						    int num=historyDetails.getNoofdays();
						   	int sick= leaveTrackRepo.get().getPrivilegeLeave()-historyDetails.getNoofdays() ;
								if(sick < 1) {
									leaveTrack.setPrivilegeLeave(0);
									historyDetails.setLopdays(num);
									leaveTrackRepository.save(leaveTrack);
								
								}else {
									leaveTrack.setPrivilegeLeave(sick);
									leaveTrackRepository.save(leaveTrack);
								}
								
							}
							else {
								int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getPrivilegeLeave();
								System.out.println("sick"+lop);
								leaveTrack.setPrivilegeLeave(lop);
								historyDetails.setLopdays(lop);
								leaveTrackRepository.save(leaveTrack);
								}
						}
							
						
						else {
								int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getPrivilegeLeave();
								historyDetails.setLopdays(lop);
								leaveTrackRepository.save(leaveTrack);
							}
					 }
				 
				 if(historyDetails.getLeaveType().equalsIgnoreCase("maternity") && 
						 (registerDetailsRepo.get().getGender().equalsIgnoreCase("female") && 
								 registerDetailsRepo.get().getMaritalstatus().equalsIgnoreCase("married"))) {
						if(leaveTrackRepo.get().getMaternityLeave()!= null && leaveTrackRepo.get().getMaternityLeave() > 0) {
							if(historyDetails.getNoofdays()<=leaveTrackRepo.get().getMaternityLeave()) {
						    int num=historyDetails.getNoofdays();
						   	int sick= leaveTrackRepo.get().getMaternityLeave()-historyDetails.getNoofdays() ;
								if(sick < 1) {
									leaveTrack.setMaternityLeave(0);
									historyDetails.setLopdays(num);
									leaveTrackRepository.save(leaveTrack);
								
								}else {
									leaveTrack.setMaternityLeave(sick);
									leaveTrackRepository.save(leaveTrack);
								}
								
							}
							else {
								int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getMaternityLeave();
								System.out.println("sick"+lop);
								leaveTrack.setMaternityLeave(lop);
								historyDetails.setLopdays(lop);
								leaveTrackRepository.save(leaveTrack);
								}
						}
							
						
						else {
								int lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getMaternityLeave();
								historyDetails.setLopdays(lop);
								leaveTrackRepository.save(leaveTrack);
							}
					 }
				
				System.out.println("gadfjsyjaszyfdtsakgfudsgkufsdkugfkuaeywgsfkyagsz");
				
				historyDetails.setMaternityLeave(leaveTrackRepo.get().getMaternityLeave());
				historyDetails.setPrivilegeLeave(leaveTrackRepo.get().getPrivilegeLeave());
				historyDetails.setBereavementLeave(leaveTrackRepo.get().getBereavementLeave());
				historyDetails.setSickLeave(leaveTrackRepo.get().getSickLeave());
				historyDetails.setCasualLeave(leaveTrackRepo.get().getCasualLeave());
				historyDetails.setStatus(status);
				historyDetails.setApprovedBy(historyDetails.getName());
				historyDetails.setApproveddate(LocalDateTime.now());
//				historyRepo.setCasualLeave(leaveTrack.getCasualLeave());
         		historyRepository.save(historyDetails);
			}
//			historyRepository.save(historyDetails)
			
			System.out.println("saved successfully");
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
		
		if (registerDetailsRepo.get().getTotalexperience() == leaveDetailsRepo.get().getExperience()) {
			Integer experience = registerDetailsRepo.get().getTotalexperience();
			return (Optional<LeaveDetails>) leaveDetailsRepository.findByExperience(experience);
		}
		return null;
	}
	public void sendEmailForLeaveApply(String toEmail, String ccEmail, String content) throws URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		URI uri = new URI(awsConfiguration.getSendLeaveApply() + toEmail + "/"+ ccEmail);
		EmailContent emailContent = new EmailContent();
		emailContent.setContentDetails(content);
		RequestEntity<EmailContent> requestEntity = new RequestEntity<>(emailContent, headers, HttpMethod.PUT, uri);
		ParameterizedTypeReference<EmailContent> typeRef = new ParameterizedTypeReference<EmailContent>() {};

		ResponseEntity<EmailContent> responseEntity = restTemplate.exchange(requestEntity, typeRef);
		

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
