package com.capeelectric.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	public void addHistoryDetails(History history) {
		
		
		history.setCreatedby(history.getName());
		history.setCreateddate(LocalDateTime.now());
		historyRepository.save(history);

	}
	
	@Override
	public LeaveTrack getLeavedetails(String empid) {
		
		Optional<RegisterDetails> registerDetailsRepo = registerDetailsRepository.findByEmpid(empid);
		Optional<LeaveDetails> leaveDetailsRepo = leaveDetailsRepository.findByExperience(registerDetailsRepo.get().getTotalexperience());
		
		Optional<LeaveTrack> leaveTrackRepo = leaveTrackRepository.findByEmpid(empid);
		
		int i = leaveDetailsRepo.get().getCasualLeave();
		i = i/12;
		
		if (leaveTrackRepo.isPresent() && null != leaveTrackRepo.get() &&  leaveTrackRepo.get().getYear().equals(LocalDate.now().getYear())) {
			Integer availableLeave = 0;
			int monthValue = LocalDate.now().getMonthValue();  //march
			
			switch (monthValue) {
			case 1:			
				availableLeave = i*monthValue;
				break;
			case 2:
				availableLeave = i*monthValue;
				break;
			case 3:
				availableLeave = i*monthValue;
				break;
			case 4:
				availableLeave = i*monthValue;
				break;
			case 5:
				availableLeave = i*monthValue;
				break;
			case 6:
				availableLeave = i*monthValue;
				break;
			case 7:
				availableLeave = i*monthValue;
				break;
			case 8:
				availableLeave = i*monthValue;
				break;
			case 9:
				availableLeave = i*monthValue;
				break;
			case 10:
				availableLeave = i*monthValue;
				break;
			case 11:
				availableLeave = i*monthValue;
				break;
			case 12:
				availableLeave = i*monthValue;
				break;
	
			}
			
			leaveTrackRepo.get().setCarryForwardLeave(availableLeave - leaveTrackRepo.get().getCasualLeave());
			
			return leaveTrackRepo.get();
			
		}
		else {
	
			LeaveTrack leaveTrack = new LeaveTrack();
			leaveTrack.setCasualLeave(0);
			leaveTrack.setBereavementLeave(leaveDetailsRepo.get().getBereavementLeave());
			leaveTrack.setMaternityLeave(leaveDetailsRepo.get().getMaternityLeave());
			leaveTrack.setPrivilegeLeave(leaveDetailsRepo.get().getPrivilegeLeave());
			leaveTrack.setSickLeave(leaveDetailsRepo.get().getSickLeave());
			leaveTrack.setCarryForwardLeave(i);
			leaveTrack.setEmpid(empid);
			leaveTrack.setYear(LocalDate.now().getYear());
			return leaveTrackRepository.save(leaveTrack);
		}
		
		
		//return null;
	}
	
//	@Override
//	public void updateHistoryDetails(History history) {
//		
//			
//		}
	
	
	@Override
	public void deleteHistoryDetails(List<History> history) {
		// TODO Auto-generated method stub	
	}

	
	
//	//get userdetails
//	 public History postdetails(String empid){
//		 
// 
//
//		Optional<RegisterDetails> registerDetails = registerDetailsRepository.findByEmpid(empid);
//		System.out.println(registerDetails.get().getTotalexperience());
//		Optional<LeaveDetails> leaveDetails = leaveDetailsRepository
//				.findByExperience(registerDetails.get().getTotalexperience());
//		
//		int casualLeave = leaveDetails.get().getCasualLeave();
//		casualLeave = casualLeave / 12;
//		
//		History history = new History();
//		
//		
////		history.setCasualLeave(leaveDetails.get().getCasualLeave());
////		history.setSickLeave(leaveDetails.get().getSickLeave());
////		history.setBereavementLeave(leaveDetails.get().getBereavementLeave());
////		history.setPrivilegeLeave(leaveDetails.get().getPrivilegeLeave());
////		history.setMaternityLeave(leaveDetails.get().getMaternityLeave());
////        history.setRegisterid(registerDetails.get().getRegisterid());
//        history.setEmpid(registerDetails.get().getEmpid());
//        history.setName(registerDetails.get().getName());
//        history.setExperience(registerDetails.get().getTotalexperience());
//        history.setDepartment(registerDetails.get().getDepartment());
//        
//        //9080404022
//        
//		List<History> history1 = historyRepository.findByEmpid(empid);
////		LocalDate currentDate= LocalDate.parse(date);
////        Month month = currentDate.getMonth();
////        int year = currentDate.getYear();
////		  LocalDateTime date=history.getApproveddate();
//	//	Integer casualLeave = calculateCasualLeave(registerDetails.get().getTotalexperience(),leaveDetails.get().getCasualLeave());
//		for (History historyRepo : history1) {
//			
//			if (historyRepo.getStatus().equalsIgnoreCase("approved")) {
//				
//			}
//			
//		}
//		if (history1.size() == 0 && registerDetails.isPresent()&&leaveDetails.isPresent()) {
//			
//			int monthCalculation=12-registerDetails.get().getCreateddate().getMonthValue();
////			history.setCasualLeave(leaveDetails.get().getCasualLeave()*monthCalculation);
////			history.setSickLeave(leaveDetails.get().getSickLeave());
////			history.setBereavementLeave(leaveDetails.get().getBereavementLeave());
////			history.setPrivilegeLeave(leaveDetails.get().getPrivilegeLeave());
////			history.setMaternityLeave(leaveDetails.get().getMaternityLeave());
//			history.setStatus("Pending");
//
//		}
//		else {
//			
//			 if(history1.size()!=0) {
//				   
//			   for(History details:history1) 
//			   if(details.getStatus().equalsIgnoreCase("approved")) {
//				   
////			history.setCasualLeave(details.getCasualLeave());
////			history.setSickLeave(details.getSickLeave());
////			history.setBereavementLeave(details.getBereavementLeave());
////			history.setPrivilegeLeave(details.getPrivilegeLeave());
////			history.setMaternityLeave(details.getMaternityLeave());
//			history.setStatus("pending");
//		}
//			   }
//	}
//		return history;
//	}
//
//	private Integer calculateCasualLeave(Integer totalexperience, Integer casualLeave) {
//		int getcasual=leaveDetails.get().getCasualLeave();
//		Integer carryForwardLeave = getcasual/12;
//		int avail;
//		int carryForward;
//		switch (key) {
//		
//		case 'January':			
//			avail=getcasual-0;
//			if(approved) {
//			carryForward= avail-getcasual;
//			int lop=noofdays-carryForwardLeave+carryForward;
//			int setcasual=getcasual-carryForwardLeave
//			setcasualLeave(setcasual)
//			break;
//		case 'february':
//			avail=getcasual-carryForwardLeave;
//			if(approved) {
//				carryForward= avail-getcasual;
//				int lop=noofdays-carryForwardLeave+carryForward;
//				int setcasual=getcasual-carryForwardLeave
//				setcasualLeave(setcasual)
//			break;
//
//		case 'march':
//			avail=10;
//			break;
//
//		case 'april':
//			avail=9;
//			break;
//
//		case 'may':
//			avail=8;
//			break;
//
//		case 'june':
//			avail=7;
//			
//			break;
//
//		case 'July':
//			avail=6;
//
//			break;
//
//		case 'august':
//			avail=5;
//			break;
//
//		case 'september':
//			avail=4;
//			break;
//
//		case 'october':
//			avail=3;
//			break;
//
//		case 'november':
//			avail=2;
//			break;
//
//		case 'december':
//			avail=1;
//
//			break;
//
//			
//		default:
//			break;
//		}
//		return null;
//	}
//
	@Override
	public void updateApprove(Integer historyId,String status) {
		
			Optional<History> historyRepo = historyRepository.findById(historyId);  

		// historyRepository.save(histroy.get());
//		 history.setApprovedby(history.getName());
//			history.setApproveddate(LocalDateTime.now());
			//Optional<History> historyRepo = historyRepository.findById(history.getHistoryid());  
			if (historyRepo.isPresent()) {
				History historyDetails  = historyRepo.get();   
	       
	        System.out.println("object created");
	        historyDetails.setStatus(status);
	        historyDetails.setApprovedBy(historyDetails.getName());
//	        historyDetails.setApproveddate(LocalDateTime.now());    
	       // historyRepository.save(historyDetails);
	        System.out.println("saved successfully");
	        if(historyRepo.get().getLeaveType().equalsIgnoreCase("casual")) {
//	        int getccl= historyRepo.get().getCasualLeave();
         	
             
//             historyDetails.setCasualLeave(historyDetails.getCasualLeave()-casual);
//	        LocalDateTime monthName = historyDetails.getApproveddate();
//	      int month= monthName.lastModified().getMonthValue();
//	        LocalDateTime NameMon= historyDetails.setApproveddate(LocalDateTime.now());
//	    		int Month= NameMon.getMonthValue();
//	        if(month==(Month)) {
//	            int casual=0;
//	        	int lop=casual-historyRepo.get().getNoofdays();
//	        	 System.out.println(lop);  
//	        }else {
//	        	int casual=getccl/12;
//	        	int lop=casual-historyRepo.get().getNoofdays();
//	        	 System.out.println(lop);  
//	        }
//	        }
//    
//	        if(historyRepo.get().getLeaveType().equalsIgnoreCase("casual") && historyRepo.get().getStatus().equalsIgnoreCase("approved")) {
//	        	 System.out.println("calculation start - - --");
//	        	
//	     
//	                  
//				if(lop>=1) {
////					historyDetails.setCasualLeave(lop);
//					historyDetails.setLopdays(lop);
//					historyRepository.save(historyDetails);	
//					 System.out.println(lop);
//				}
//				else if(lop<0) {
////					historyDetails.setCasualLeave(0);
//					historyDetails.setLopdays(lop);
//				historyRepository.save(historyDetails);
//				 System.out.println(lop);
//				}
//			}	
	        
//	         if(historyRepo.get().getLeaveType().equalsIgnoreCase("sick leave")&&historyRepo.get().getStatus().equalsIgnoreCase("approved")) {	
//	        	 System.out.println("calculation start - - --");
//	            int lop=historyRepo.get().getSickLeave()-historyRepo.get().getNoofdays();
//	            System.out.println(lop);
//			if(lop>=1) {
//				historyDetails.setSickLeave(lop);
//				historyRepository.save(historyDetails);
//				 System.out.println(lop);
//			}else if(lop<0){
//				historyDetails.setSickLeave(0);
//				historyDetails.setLopdays(lop);
//			historyRepository.save(historyDetails);
//			 System.out.println(lop);
//			}
//		}
//	        
//	        if(historyRepo.get().getStatus().equalsIgnoreCase("approved") && historyRepo.get().getLeaveType().equalsIgnoreCase("Bereavement leave")) {
//	        	 System.out.println("calculation start - - --");
//			  int lop=historyRepo.get().getBereavementLeave()-historyRepo.get().getNoofdays();		
//			if(lop>=1) {
//				historyDetails.setBereavementLeave(lop);
//				historyRepository.save(historyDetails);
//			}else if(lop<0) {
//				historyDetails.setLopdays(lop);
//			historyRepository.save(historyDetails);
//			}
//		}else if(historyRepo.get().getLeaveType().equalsIgnoreCase("bereavementLeave")&&historyRepo.get().getStatus().equalsIgnoreCase("cancel")) {
//		    int lop=historyRepo.get().getNoofdays()+historyRepo.get().getLopdays();
//		    historyDetails.setBereavementLeave(lop);
//		    historyRepository.save(historyDetails);
//		    
//		}
//		if(historyRepo.get().getStatus().equalsIgnoreCase("approved") && historyRepo.get().getLeaveType().equalsIgnoreCase("privilege leave")) {
//			 System.out.println("calculation start - - --");
//			int lop= historyRepo.get().getPrivilegeLeave()-historyRepo.get().getNoofdays();
//			System.out.println(lop);
//			if(lop>=1) {
//				historyDetails.setPrivilegeLeave(lop);
//				historyRepository.save(historyDetails);
//			}else if(lop<0){
//				historyDetails.setLopdays(lop);
//			historyRepository.save(historyDetails);
//			}
//		}
//		if(historyRepo.get().getStatus().equalsIgnoreCase("approved") && historyRepo.get().getLeaveType().equalsIgnoreCase("maternity leave")){
//			 System.out.println("calculation start - - --");
//			int lop= historyRepo.get().getMaternityLeave()-historyRepo.get().getNoofdays();
//			
//			if(lop>=1) {
//				historyDetails.setMaternityLeave(lop);
//				historyRepository.save(historyDetails);
//			}else if(lop<0) {
//				historyDetails.setLopdays(lop);
//			historyRepository.save(historyDetails);
//			}
//		}
//		if(historyRepo.get().getStatus().equalsIgnoreCase("cancel")&&historyRepo.get().getLeaveType().equalsIgnoreCase("casual leave")) {
////			int retrieve=  historyRepo.get().getCasualLeave()+historyRepo.get().getNoofdays();
//			int cl;
//			cl=historyRepo.get().getNoofdays()+historyRepo.get().getLopdays();
//			historyDetails.setCasualLeave(cl);
//			
//			historyDetails.setLopdays(0);
//			  historyRepository.save(historyDetails);
//		    }}
	        }}}

@Override
public List<History> getHistoryDetails() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<History> getHistoryDetails(String empid) {
	// TODO Auto-generated method stub
	return (List<History>) historyRepository.findAll() ;
}

@Override
public List<History> setHistoryDetails(String empid) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public History postdetails(String empid) {
	// TODO Auto-generated method stub
	return null;
}}


	
//	//
//	public History getEmployeeLeaveDetails(String empId) {
//	
//		Optional<RegisterDetails> registerDetails = registerDetailsRepository.findByEmpid(empId);
//		Optional<LeaveDetails> leaveDetails= leaveDetailsRepository.findByExperience(registerDetails.get().getTotalexperience());
//		
//		History history = new History();
//		history.setCasualLeave(leaveDetails.get().getCasualLeave());
//		history.setSickLeave(leaveDetails.get().getSickLeave());
//		history.setBereavementLeave(leaveDetails.get().getBereavementLeave());
//		history.setPrivilegeLeave(leaveDetails.get().getPrivilegeLeave());
//		history.setMaternityLeave(leaveDetails.get().getMaternityLeave());
//		
//		Integer approvedMonth = 0;
//		
//		List<History> historyDetailsRepo = historyRepository.findByEmpid(empId);
//		if (historyDetailsRepo.size() != 0) {
//			for (History historyItr : historyDetailsRepo) {
//
//				if (historyItr.getStatus().equalsIgnoreCase("approved")) {
//					approvedMonth = historyItr.getApproveddate().getMonthValue();
//
//					if (history.getLeaveType().equalsIgnoreCase("casual leave")) {
//						history.setCasualLeave(historyItr.getCasualLeave()); 0
//
//					}
//					if (history.getLeaveType().equalsIgnoreCase("sick leave")) {
//						history.setSickLeave(historyItr.getSickLeave());
//
//					}
//					if (history.getLeaveType().equalsIgnoreCase("Bereavement leave")) {
//						history.setBereavementLeave(historyItr.getBereavementLeave());
//
//					}
//					if (history.getLeaveType().equalsIgnoreCase("privilege leave")) {
//						history.setPrivilegeLeave(historyItr.getPrivilegeLeave());
//
//					}
//					if (history.getLeaveType().equalsIgnoreCase("maternity leave")) {
//						history.setMaternityLeave(historyItr.getMaternityLeave());
//
//					}	
//				}
//			}
//		} 
//		else if(historyDetailsRepo.size() == 0) {
//			history.setCasualLeave(leaveDetails.get().getCasualLeave());
//			history.setSickLeave(leaveDetails.get().getSickLeave());
//			history.setBereavementLeave(leaveDetails.get().getBereavementLeave());
//			history.setPrivilegeLeave(leaveDetails.get().getPrivilegeLeave());
//			history.setMaternityLeave(leaveDetails.get().getMaternityLeave());
//		}
//		
//	   Integer avCL = LocalDateTime.now().getDayOfMonth()- approvedMonth;
//	  
//		
//		history.setDepartment(registerDetails.get().getDepartment());
//		history.setLocation(registerDetails.get().getOfficelocation());
//		return null;
//
//	}

//	public History getDays(String empId) {
//		Optional<RegisterDetails> registerDetails = registerDetailsRepository.findByEmpid(empId);
//		Optional<LeaveDetails> leaveDetails = leaveDetailsRepository
//				.findByExperience(registerDetails.get().getTotalexperience());
//		History history = new History();
//
//		List<History> history1 = historyRepository.findByEmpid(empId);
//		
//		if (history1.size() == 0 && registerDetails.isPresent()&&leaveDetails.isPresent()) {
//			
//			int monthCalculation=12-registerDetails.get().getCreateddate().getMonth();
//			history.setCasualLeave(leaveDetails.get().getCasualLeave()*monthCalculation);
//			history.setSickLeave(leaveDetails.get().getSickLeave());
//			history.setBereavementLeave(leaveDetails.get().getBereavementLeave());
//			history.setPrivilegeLeave(leaveDetails.get().getPrivilegeLeave());
//			history.setMaternityLeave(leaveDetails.get().getMaternityLeave());
//			
//
//		}
//		else {
//			
//			 if(history1.size()!=0) {
//				   
//			   for(History dhana1:history1) 
//			   if(dhana1.getStatus().equalsIgnoreCase("approved")) {
//				   System.out.println("dhananananana................");
//			history.setCasualLeave(dhana1.getCasualLeave());
//			history.setSickLeave(dhana1.getSickLeave());
//			history.setBereavementLeave(dhana1.getBereavementLeave());
//			history.setPrivilegeLeave(dhana1.getPrivilegeLeave());
//			history.setMaternityLeave(dhana1.getMaternityLeave());
//		}
//			 }}
//		
//		return history;
//	}
//
//	@Override
//	public List<History> getHistoryDetails() {
//		
//		return null;
//	} 
	//}
//}
