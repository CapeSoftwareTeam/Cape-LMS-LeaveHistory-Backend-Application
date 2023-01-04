package com.capeelectric.serviceImpl;


import com.capeelectric.config.AWSConfig;
import com.capeelectric.model.EmailContent;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capeelectric.model.History;
import com.capeelectric.model.LeaveDetails;
import com.capeelectric.model.LeaveTrack;
import com.capeelectric.model.RegisterDetails;
import com.capeelectric.repository.HistoryRepository;
import com.capeelectric.repository.LeaveDetailsRepository;
import com.capeelectric.repository.LeaveTrackRepository;
import com.capeelectric.repository.RegisterRepository;
import com.capeelectric.service.HistoryService;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


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
    	// Post leave in history table (Add leave) and (Mail triggering code)
	@Override
	public void addHistoryDetails(History history) throws Exception {	
//		history.setCreatedby(history.getName());

		history.setCreateddate(LocalDateTime.now());
		historyRepository.save(history);	
//		sendEmailForLeaveApply(history.getManageremail(),"sangeetha@capeindia.net","subject: Need in response to the leave applied from the"+history.getEmpid()+"-"+history.getName()+"\\r\\n"
//				
//				                +"\\r\\n"
//				                +"This is to inform you that"+history.getEmpid()+"-"+history.getName()+"has applied for the leave"+ history.getLeaveType()+"on"+history.getTodate()+"-"+history.getTodate()+"\\r\\n"
//				                +"\\r\\n"
//				                +"Do login to LMS application to know the details.\\r\\n"
//				                +"\\r\\n"
//				                +"Regards,\\r\\n"
//				                +"Leave Management System.\\r\\n"
//				                +history.getEmpid()+"-"+history.getName()
//				);
//	}
	}

	
	
	
	
	// if leave gets approved this code will help you
	@Override
	public LeaveTrack getLeavedetails(String empid) {

		Optional<RegisterDetails> registerDetailsRepo = registerDetailsRepository.findByEmpid(empid);
		Optional<LeaveDetails> leaveDetailsRepo = leaveDetailsRepository.findByExperience(registerDetailsRepo.get().getTotalexperience());

		Optional<LeaveTrack> leaveTrackRepo = leaveTrackRepository.findByEmpid(empid);

		float i = leaveDetailsRepo.get().getCasualLeave();
		i= i / 12;
	

		if (leaveTrackRepo.isPresent() && null != leaveTrackRepo.get()) {
			if(leaveTrackRepo.get().getYear().equals(LocalDate.now().getYear())) {
		
			
//			if(leaveTrackRepo.isPresent() != leaveTrackRepo.get().getYear().equals(LocalDate.now().getYear()){
//			LeaveTrack leaveTrack = new LeaveTrack();
//			leaveTrack.setYear(LocalDate.now().getYear());
//			leaveTrack.setCasualLeave(leaveDetailsRepo.get().getCasualLeave());
//			leaveTrack.setBereavementLeave(leaveDetailsRepo.get().getBereavementLeave());
//			leaveTrack.setMaternityLeave(leaveDetailsRepo.get().getMaternityLeave());
//			leaveTrack.setPrivilegeLeave(leaveDetailsRepo.get().getPrivilegeLeave());
//			leaveTrack.setSickLeave(leaveDetailsRepo.get().getSickLeave());
//			leaveTrack.setCarryForwardLeave(i);
//		}
			
			System.out.println("issssssssssssssssssssssssssssssssssss");
			Float availableLeave = 0.0f;

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
}
			else {
            leaveTrackRepository.deleteById(leaveTrackRepo.get().getLeaveTrackId());

            LeaveTrack leaveTrack = new LeaveTrack();

            leaveTrack.setCasualLeave(leaveDetailsRepo.get().getCasualLeave());
            leaveTrack.setBereavementLeave(leaveDetailsRepo.get().getBereavementLeave());
            leaveTrack.setMaternityLeave(leaveDetailsRepo.get().getMaternityLeave());
            leaveTrack.setPrivilegeLeave(leaveDetailsRepo.get().getPrivilegeLeave());
            leaveTrack.setSickLeave(leaveDetailsRepo.get().getSickLeave());
            leaveTrack.setCarryForwardLeave(i);
            leaveTrack.setYear(LocalDate.now().getYear());
            leaveTrack.setEmpid(empid);
            return leaveTrackRepository.save(leaveTrack);
        }
		}
		else {
		

		    
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
	public void updateApprove(Integer historyId,String empid, String status ) {
		
		Optional<RegisterDetails> registerDetailsRepo = registerDetailsRepository.findByEmpid(empid);
		Optional<History> historyRepo = historyRepository.findById(historyId);
		String Empid=historyRepo.get().getEmpid();
		Optional<LeaveTrack> leaveTrackRepo = leaveTrackRepository.findByEmpid(Empid);
		Optional<LeaveDetails> leaveDetailsRepo = leaveDetailsRepository.findByExperience(registerDetailsRepo.get().getTotalexperience());
	
		System.out.println("from date year"+historyRepo.get().getCreateddate().getYear());

		if(historyRepo.isPresent() && LocalDate.now().getYear()!=leaveTrackRepo.get().getYear()) {
			System.out.println("year mismatch came inside");
			float i = leaveDetailsRepo.get().getCasualLeave();
			i= i / 12;
			LeaveTrack leaveTrack = leaveTrackRepo.get();
			leaveTrack.setCasualLeave(leaveDetailsRepo.get().getCasualLeave());
			leaveTrack.setBereavementLeave(leaveDetailsRepo.get().getBereavementLeave());
			leaveTrack.setMaternityLeave(leaveDetailsRepo.get().getMaternityLeave());
			leaveTrack.setPrivilegeLeave(leaveDetailsRepo.get().getPrivilegeLeave());
			leaveTrack.setSickLeave(leaveDetailsRepo.get().getSickLeave());
			leaveTrack.setCarryForwardLeave(i);
			leaveTrack.setYear(historyRepo.get().getCreateddate().getYear());
			leaveTrackRepository.save(leaveTrack);
			
	          History historyDetails = historyRepo.get();
			
//			LeaveTrack leaveTrack = leaveTrackRepo.get();
//			System.out.println(empid);
//			System.out.println(historyId);
//			System.out.println(status);
	     calculation(historyId,empid,status);
			
			
			}
	
	else
		if (historyRepo.isPresent()  && LocalDate.now().getYear() ==leaveTrackRepo.get().getYear()) {
			History historyDetails = historyRepo.get();
			
			LeaveTrack leaveTrack = leaveTrackRepo.get();

			 calculation(historyId,empid,status);
			}
//			historyRepository.save(historyDetails)
//		if(status.equalsIgnoreCase("Approved")) {
//			History historyDetails = historyRepo.get();
			
//			sendEmailForLeaveApply(historyDetails.getManageremail(),"sangeetha@capeindia.net","subject: My leave request's response\\r\\n"
//			
//			                +"\\r\\n"
//			                +"With reference to the your leave request received on "+historyDetails.getCreatedby()+ "seeking permission for a leave from "+	historyDetails.getFromdate() + " to "+historyDetails.getTodate()+"\\r\\n"
//			                +"\\r\\n"
//			                +"we would like to inform you that your leave request has been approved for"+historyDetails.getNoofdays()+"\\r\\n"
//			                + "\\r\\n"
//			                +"\\r\\n"
//			                +"Regards,\\r\\n"
//			                +"Leave Management System.\\r\\n"
//			               
//			);	
//		}
			
		}
	
	// this code is for delete history
	@Override
	public void deleteHistoryDetails(Integer historyId) {
		historyRepository.deleteById(historyId);
	
	
//		historyRepository.deleteAll();
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
	
//	public void sendEmailForLeaveApply(String toEmail, String ccEmail, String content) throws URISyntaxException {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		URI uri = new URI(awsConfiguration.getSendLeaveApply() + toEmail + "/"+ ccEmail);
//		EmailContent emailContent = new EmailContent();
//		emailContent.setContentDetails(content);
//		RequestEntity<EmailContent> requestEntity = new RequestEntity<>(emailContent, headers, HttpMethod.PUT, uri);
//		ParameterizedTypeReference<EmailContent> typeRef = new ParameterizedTypeReference<EmailContent>() {};

//	@Override
//	public void updateHistoryDetails(History history) {
//		
//			
//		}



//	//get userdetails
//	 public History postdetails(String empid){
//		 
// 

//
//		ResponseEntity<EmailContent> responseEntity = restTemplate.exchange(requestEntity, typeRef);
//		
//
//	}

	@Override

	public List<History> empStatusDetails(String empid) {

		return historyRepository.findByEmpid(empid);
	}

	@Override
	public List<History> StatusDetails(String empid) {
		return historyRepository.findByEmpid(empid);
	}
	@Override
	public void mystatusdelete(Integer historyId) {
		// TODO Auto-generated method stub
		historyRepository.deleteById(historyId);
	}
	@Override
	public Optional<LeaveTrack> LeaveTrackPopUpdetails(String empid) {
		// TODO Auto-generated method stub
		return leaveTrackRepository.findByEmpid(empid);
	}
	@Override
	public void revertcalculation(Integer historyId,String status,String empid ) {
		
		Optional<History> historyRepo = historyRepository.findById(historyId);
		History historyDetails = historyRepo.get();
		Optional<LeaveTrack> leaveTrackRepo = leaveTrackRepository.findByEmpid(empid);
		LeaveTrack leaveTrack= new LeaveTrack();
		
		System.out.println(status);

		if(status.equalsIgnoreCase("cancelled")) {
			System.out.println("status is cancelled");
			if(historyRepo.get().getLeaveType().equalsIgnoreCase("casual") &&leaveTrackRepo.isPresent()) {
				
			
			if(historyRepo.get().getLopdays()>0) {
				  float setcarryforward = historyRepo.get().getNoofdays()-historyRepo.get().getLopdays();
				    System.out.println(setcarryforward);
					float carry=leaveTrackRepo.get().getCarryForwardLeave()+setcarryforward;
					leaveTrackRepo.get().setCarryForwardLeave(carry);
					System.out.println(carry);
					historyDetails.setCasualLeave(historyDetails.getCasualLeave()+carry);
					historyDetails.setLopdays(0.0f);
					leaveTrackRepository.save(leaveTrackRepo.get());
					historyRepository.save(historyDetails);
			}else {
				
						historyDetails.setLopdays(0.0f);
				historyDetails.setCasualLeave(historyDetails.getCasualLeave()+historyRepo.get().getNoofdays());
				leaveTrackRepo.get().setCasualLeave(historyRepo.get().getCasualLeave());
				leaveTrackRepo.get().setCarryForwardLeave(historyRepo.get().getNoofdays()+leaveTrackRepo.get().getCarryForwardLeave());
				historyDetails.setNoofdays(0.0f);
				leaveTrackRepository.save(leaveTrackRepo.get());
				historyRepository.save(historyDetails);
			
			 }	
			}	
			if(historyRepo.get().getLeaveType().equalsIgnoreCase("sick")) {
				System.out.println("sick is trigerred");
				if(historyRepo.get().getLopdays()>0) {
					System.out.println("condition satisfied");
					   System.out.println(historyRepo.get().getLopdays());
			    float setcarryforward = historyRepo.get().getNoofdays()-historyRepo.get().getLopdays();		
				historyDetails.setSickLeave(historyDetails.getSickLeave()+setcarryforward);
				historyDetails.setLopdays(0.0f);
				historyRepository.save(historyDetails);
				leaveTrackRepo.get().setSickLeave(historyRepo.get().getSickLeave());
				leaveTrackRepository.save(leaveTrackRepo.get());
			}else {
				System.out.println("condition satisfied");
				historyDetails.setSickLeave(historyDetails.getSickLeave()+historyRepo.get().getNoofdays());
				historyRepository.save(historyDetails);
				leaveTrackRepo.get().setSickLeave(historyRepo.get().getSickLeave());
				leaveTrackRepository.save(leaveTrackRepo.get());
			}
			}
			if(historyRepo.get().getLeaveType().equalsIgnoreCase("bereavement")) {
				System.out.println("sick is trigerred");
				if(historyRepo.get().getLopdays()>0) {
					System.out.println("condition satisfied");
					   System.out.println(historyRepo.get().getLopdays());
			    float setcarryforward = historyRepo.get().getNoofdays()-historyRepo.get().getLopdays();		
			    historyDetails.setBereavementLeave(historyDetails.getBereavementLeave()+setcarryforward);
				historyDetails.setLopdays(0.0f);
				historyRepository.save(historyDetails);
				leaveTrackRepo.get().setBereavementLeave(historyRepo.get().getBereavementLeave());
				leaveTrackRepository.save(leaveTrackRepo.get());
			}else {
				System.out.println("condition satisfied");
				historyDetails.setBereavementLeave(historyDetails.getBereavementLeave()+historyRepo.get().getNoofdays());
				historyRepository.save(historyDetails);
				leaveTrackRepo.get().setBereavementLeave(historyRepo.get().getBereavementLeave());
				leaveTrackRepository.save(leaveTrackRepo.get());
			}
			}
			if(historyRepo.get().getLeaveType().equalsIgnoreCase("privilege")) {
				System.out.println("sick is trigerred");
				if(historyRepo.get().getLopdays()>0) {
					System.out.println("condition satisfied");
					   System.out.println(historyRepo.get().getLopdays());
			    float setcarryforward = historyRepo.get().getNoofdays()-historyRepo.get().getLopdays();		
			    historyDetails.setPrivilegeLeave(historyDetails.getPrivilegeLeave()+setcarryforward);
				historyDetails.setLopdays(0.0f);
				historyRepository.save(historyDetails);
				leaveTrackRepo.get().setPrivilegeLeave(historyRepo.get().getPrivilegeLeave());
				leaveTrackRepository.save(leaveTrackRepo.get());
			}else {
				System.out.println("condition satisfied");
				historyDetails.setPrivilegeLeave(historyDetails.getPrivilegeLeave()+historyRepo.get().getNoofdays());
				historyRepository.save(historyDetails);
				leaveTrackRepo.get().setPrivilegeLeave(historyRepo.get().getPrivilegeLeave());
				leaveTrackRepository.save(leaveTrackRepo.get());
			}
			
			}
			if(historyRepo.get().getLeaveType().equalsIgnoreCase("maternity")) {
				System.out.println("sick is trigerred");
				if(historyRepo.get().getLopdays()>0) {
					System.out.println("condition satisfied");
					   System.out.println(historyRepo.get().getLopdays());
					   float setcarryforward = historyRepo.get().getNoofdays()-historyRepo.get().getLopdays();	
					   historyDetails.setMaternityLeave(historyDetails.getMaternityLeave()+setcarryforward);
				historyDetails.setLopdays(0.0f);
				historyRepository.save(historyDetails);
				leaveTrackRepo.get().setMaternityLeave(historyRepo.get().getMaternityLeave());
				leaveTrackRepository.save(leaveTrackRepo.get());
			}else {
				System.out.println("condition satisfied");
				historyDetails.setMaternityLeave(historyDetails.getMaternityLeave()+historyRepo.get().getNoofdays());
				historyRepository.save(historyDetails);
				leaveTrackRepo.get().setMaternityLeave(historyRepo.get().getMaternityLeave());
				leaveTrackRepository.save(leaveTrackRepo.get());
			}
			}
			
		}
		historyDetails.setStatus(status);
		historyRepository.save(historyDetails);
	}
	

	@Override
	public void updateFileHistory(Integer historyId, Integer fileId) {
		// TODO Auto-generated method stub
		Optional<History> historyRepo = historyRepository.findById(historyId);
		History historyDetails = historyRepo.get();
		if(historyRepo.isPresent()) {
			historyDetails.setFileid(fileId);
			historyRepository.save(historyDetails);
		}
		
		
	}

	@Override
	public Optional<History> getHistoryFile(Integer historyId) {
		// TODO Auto-generated method stub
		return historyRepository.findById(historyId);
	}
	
	@Override
	public void downloadHistory(List<History> history ) throws Exception {

		Document document = new Document(PageSize.A4, 28, 28, 62, 68);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("hi.pdf"));
		document.open();
		Font font = new Font(BaseFont.createFont(), 9, Font.BOLD | Font.BOLD, BaseColor.BLACK);
		Font font1 = new Font(BaseFont.createFont(), 9, Font.NORMAL | Font.NORMAL, BaseColor.BLACK);
		Paragraph paragraphOne = new Paragraph("HISTORY DETAILS ", font);
		paragraphOne.setAlignment(Element.ALIGN_CENTER);
		//Create Table object, Here 4 specify the no. of columns
		float[] pointColumnWidths = { 100F, 140F ,140F, 130F ,120F, 80F ,130F ,150F };
        PdfPTable pdfPTable = new PdfPTable(pointColumnWidths);
        pdfPTable.setWidthPercentage(100); // Width 100%
        pdfPTable.setSpacingBefore(30f); // Space before table
        pdfPTable.getDefaultCell();
        
        Font font2 = new Font(BaseFont.createFont(), 13, Font.BOLD | Font.BOLD, BaseColor.BLACK);
		Paragraph paragraphtwo = new Paragraph("Employee's Leave Data ", font2);
		paragraphtwo.setAlignment(Element.ALIGN_CENTER);
	
        //Create cells
            //Add cells to table
            PdfPCell cell = new PdfPCell();
    
    		cell.setPadding(10);
    		cell.setPhrase(new Phrase("EmpId", font));
    		cell.setGrayFill(0.92f);
    		pdfPTable.addCell(cell);
    		cell.setPhrase(new Phrase("Name", font));
    		cell.setGrayFill(0.92f);
    		pdfPTable.addCell(cell);
   	   		cell.setPhrase(new Phrase("Department", font));
    		cell.setGrayFill(0.92f);
    		pdfPTable.addCell(cell);
    		cell.setPhrase(new Phrase("FromDate", font));
    		cell.setGrayFill(0.92f);
    		pdfPTable.addCell(cell);
    		cell.setPhrase(new Phrase("ToDate", font));
    		cell.setGrayFill(0.92f);
    		pdfPTable.addCell(cell);
    		cell.setPhrase(new Phrase("NoOfDays", font));
    		cell.setGrayFill(0.92f);
    		pdfPTable.addCell(cell);
    		cell.setPhrase(new Phrase("LeaveType", font));
    		cell.setGrayFill(0.92f);
    		pdfPTable.addCell(cell);
    		cell.setPhrase(new Phrase("Location", font));
    		cell.setGrayFill(0.92f);
    		pdfPTable.addCell(cell);
		
			for (History historydata : history) {
				cell.setPhrase(new Phrase(historydata.getEmpid(), font1));
				pdfPTable.addCell(cell);
				cell.setPhrase(new Phrase(historydata.getName(), font1));

				pdfPTable.addCell(cell);
				cell.setPhrase(new Phrase(historydata.getDepartment(), font1));

				pdfPTable.addCell(cell);
				cell.setPhrase(new Phrase(historydata.getFromDate(), font1));

				pdfPTable.addCell(cell);
				cell.setPhrase(new Phrase(historydata.getToDate(), font1));

				pdfPTable.addCell(cell);
				if (historydata.getLopdays() == null) {
					cell.setPhrase(new Phrase("0", font1));

				} else {
					cell.setPhrase(new Phrase(historydata.getLopdays().toString(), font1));
				}
				pdfPTable.addCell(cell);

				if (historydata.getLeaveType().equalsIgnoreCase("casual")) {
					cell.setPhrase(new Phrase("CL", font1));
				}

				else if (historydata.getLeaveType().equalsIgnoreCase("sick")) {
					cell.setPhrase(new Phrase("SL", font1));
				} else if (historydata.getLeaveType().equalsIgnoreCase("bereavement")) {
					cell.setPhrase(new Phrase("BL", font1));
				} else if (historydata.getLeaveType().equalsIgnoreCase("privilege")) {
					cell.setPhrase(new Phrase("PL", font1));
				} else if (historydata.getLeaveType().equalsIgnoreCase("maternity")) {
					cell.setPhrase(new Phrase("ML", font1));
				} else {
					cell.setPhrase(new Phrase("SL", font1));

				}
				pdfPTable.addCell(cell);
				cell.setPhrase(new Phrase(historydata.getLocation(), font1));
				pdfPTable.addCell(cell);

			}
		
		Font font5 = new Font(BaseFont.createFont(), 10, Font.NORMAL | Font.BOLD, BaseColor.BLACK);
		PdfPTable table2 = new PdfPTable(1);
		table2.setWidthPercentage(100); // Width 100%
		table2.setSpacingBefore(10f); // Space before table
		table2.getDefaultCell().setBorder(0);

		PdfPCell cell25 = new PdfPCell(new Paragraph(15, "LeaveType ", font5));
		//cell25.setBorder(PdfPCell.NO_BORDER);
		cell25.setBackgroundColor(BaseColor.LIGHT_GRAY);
		table2.addCell(cell25);
		


		Paragraph paragraph1 = new Paragraph("CL => Casual Leave"); 
		Paragraph paragraph2 = new Paragraph ("BL => Bereavement Leave"); 
		Paragraph paragraph3 = new Paragraph("PL => Privilege Leave"); 
		Paragraph paragraph4 = new Paragraph("ML => Maternity Leave");
				

		document.add(paragraphtwo);
		document.add(pdfPTable);
		document.add(table2);
		document.add(paragraph1);
		document.add(paragraph2);
		document.add(paragraph3);
		document.add(paragraph4);
		document.close();
		
//		return null;
		
 
	}

	@Override
	public void delete(List<History> listOfHistory) {
		historyRepository.deleteAll(listOfHistory);
	}
public void calculation(Integer historyId,String empid, String status) {
	Optional<RegisterDetails> registerDetailsRepo = registerDetailsRepository.findByEmpid(empid);
	Optional<History> historyRepo = historyRepository.findById(historyId);
	String Empid=historyRepo.get().getEmpid();
	Optional<LeaveTrack> leaveTrackRepo = leaveTrackRepository.findByEmpid(Empid);
	Optional<LeaveDetails> leaveDetailsRepo = leaveDetailsRepository.findByExperience(registerDetailsRepo.get().getTotalexperience());
	
History historyDetails = historyRepo.get();
LeaveTrack leaveTrack = leaveTrackRepo.get();

	if(historyDetails.getLeaveType().equalsIgnoreCase("casual") && status.equalsIgnoreCase("Approved")) {
		if(leaveTrackRepo.get().getCarryForwardLeave()!=0.0f && leaveTrackRepo.get().getCarryForwardLeave()>0) {
			if(historyDetails.getNoofdays()<=(leaveTrackRepo.get().getCarryForwardLeave())) {
				System.out.println("segment 1");
				float carry=leaveTrackRepo.get().getCarryForwardLeave()-historyDetails.getNoofdays();//1
				float casual=leaveTrackRepo.get().getCasualLeave()-historyDetails.getNoofdays();	
				System.out.println(casual);
				historyDetails.setCasualLeave(casual);
				historyDetails.setLopdays(0.0f);
				historyRepository.save(historyDetails);
				leaveTrack.setCasualLeave(casual);
				leaveTrack.setCarryForwardLeave(carry);
				leaveTrackRepository.save(leaveTrack);

			}
			else {
				System.out.println("segment 2");
				float casualForless=leaveTrackRepo.get().getCasualLeave()-leaveTrackRepo.get().getCarryForwardLeave();
				float lop=historyDetails.getNoofdays()-leaveTrackRepo.get().getCarryForwardLeave();
				leaveTrack.setCasualLeave(casualForless);
				System.out.println("find your casual" +casualForless+" find your leavetrack casual"+leaveTrackRepo.get().getCasualLeave()+"find your carryforward"+leaveTrackRepo.get().getCarryForwardLeave());
				leaveTrack.setCarryForwardLeave(0.0f);
				leaveTrackRepository.save(leaveTrack);
				historyDetails.setLopdays(lop);
			}leaveTrackRepository.save(leaveTrack);
			}
	
	else {
		float casualForless=leaveTrackRepo.get().getCasualLeave()-leaveTrackRepo.get().getCarryForwardLeave();
		leaveTrack.setCasualLeave(casualForless);
		float lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getCarryForwardLeave();
		historyDetails.setLopdays(lop);
		leaveTrackRepository.save(leaveTrack);
	}
		}
	 if(historyDetails.getLeaveType().equalsIgnoreCase("sick") && status.equalsIgnoreCase("Approved")) {
			if(leaveTrackRepo.get().getSickLeave()!= 0.0f && leaveTrackRepo.get().getSickLeave() > 0) {
				if(historyDetails.getNoofdays()==leaveTrackRepo.get().getSickLeave()) {
					 System.out.println("it is equal");
						leaveTrack.setSickLeave(0.0f);
						historyDetails.setLopdays(0.0f);
						historyRepository.save(historyDetails);
						leaveTrackRepository.save(leaveTrack);
					}
				 else if(historyDetails.getNoofdays()<leaveTrackRepo.get().getSickLeave()) {
					float num=historyDetails.getNoofdays();
					float sick= leaveTrackRepo.get().getSickLeave()-historyDetails.getNoofdays() ;
					if(sick < 0.5) {
						leaveTrack.setSickLeave(0.0f);
						historyDetails.setLopdays(num);
						leaveTrackRepository.save(leaveTrack);
						historyRepository.save(historyDetails);
					}else {
						leaveTrack.setSickLeave(sick);
						historyDetails.setLopdays(0.0f);
						historyRepository.save(historyDetails);
						leaveTrackRepository.save(leaveTrack);
					}
					
				}
				else {
					float lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getSickLeave();
					leaveTrack.setSickLeave(0.0f);
					historyDetails.setLopdays(lop);
					leaveTrackRepository.save(leaveTrack);
					}
			}
				
			
			else {
				float lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getSickLeave();
					historyDetails.setLopdays(lop);
					leaveTrackRepository.save(leaveTrack);
				}
		 }
//		
	 if(historyDetails.getLeaveType().equalsIgnoreCase("bereavement") && status.equalsIgnoreCase("Approved")) {
		 
			if(leaveTrackRepo.get().getBereavementLeave()!= 0.0f && leaveTrackRepo.get().getBereavementLeave() > 0) {
				 System.out.println(leaveTrackRepo.get().getBereavementLeave());
				 System.out.println(historyDetails.getNoofdays());
				 if(historyDetails.getNoofdays()==leaveTrackRepo.get().getBereavementLeave()) {
					 System.out.println("it is equal");
						leaveTrack.setBereavementLeave(0.0f);
						historyDetails.setLopdays(0.0f);
						historyRepository.save(historyDetails);
						leaveTrackRepository.save(leaveTrack);
					}
				 else if(historyDetails.getNoofdays()<leaveTrackRepo.get().getBereavementLeave()) {
					float num=historyDetails.getNoofdays();
					float sick= leaveTrackRepo.get().getBereavementLeave()-historyDetails.getNoofdays();
				     if(sick < 0.5) {
						leaveTrack.setBereavementLeave(0.0f);
						historyDetails.setLopdays(num);
						leaveTrackRepository.save(leaveTrack);
					}
					else {
					
						leaveTrack.setBereavementLeave(sick);
						historyDetails.setLopdays(0.0f);
						historyRepository.save(historyDetails);
						leaveTrackRepository.save(leaveTrack);
					}
				}
				else {
					float lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getBereavementLeave();
					leaveTrack.setBereavementLeave(lop);
					historyDetails.setLopdays(lop);
					leaveTrackRepository.save(leaveTrack);
					}
			}
				
			
			else {
				float lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getBereavementLeave();
					historyDetails.setLopdays(lop);
					leaveTrackRepository.save(leaveTrack);
				}
		 }
		 if(historyDetails.getLeaveType().equalsIgnoreCase("privilege") && status.equalsIgnoreCase("Approved")) {
				if(leaveTrackRepo.get().getPrivilegeLeave()!= 0.0f && leaveTrackRepo.get().getPrivilegeLeave() > 0) {
					if(historyDetails.getNoofdays()==leaveTrackRepo.get().getPrivilegeLeave()) {
						 System.out.println("it is equal");
							leaveTrack.setPrivilegeLeave(0.0f);
							historyDetails.setLopdays(0.0f);
							historyRepository.save(historyDetails);
							leaveTrackRepository.save(leaveTrack);
						}
					 else if(historyDetails.getNoofdays()<leaveTrackRepo.get().getPrivilegeLeave()) {
						float num=historyDetails.getNoofdays();
						float sick= leaveTrackRepo.get().getPrivilegeLeave()-historyDetails.getNoofdays() ;
						if(sick < 0.5) {
							leaveTrack.setPrivilegeLeave(0.0f);
							historyDetails.setLopdays(num);
							historyRepository.save(historyDetails);
							leaveTrackRepository.save(leaveTrack);
						
						}else {
							leaveTrack.setPrivilegeLeave(sick);
							historyDetails.setLopdays(0.0f);historyRepository.save(historyDetails);
							leaveTrackRepository.save(leaveTrack);
						}
						
					}
					else {
						float lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getPrivilegeLeave();
						leaveTrack.setPrivilegeLeave(0.0f);
						historyDetails.setLopdays(lop);
						leaveTrackRepository.save(leaveTrack);
						}
				}
					
				
				else {
					float lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getPrivilegeLeave();
						historyDetails.setLopdays(lop);
						leaveTrackRepository.save(leaveTrack);
					}
			 }
		 
		 if(historyDetails.getLeaveType().equalsIgnoreCase("maternity") && 
				 (registerDetailsRepo.get().getGender().equalsIgnoreCase("female") && 
						 registerDetailsRepo.get().getMaritalstatus().equalsIgnoreCase("married")
						 && status.equalsIgnoreCase("Approved"))) {	
				if(leaveTrackRepo.get().getMaternityLeave()!=0.0f  && leaveTrackRepo.get().getMaternityLeave() > 0) {
					if(historyDetails.getNoofdays()==leaveTrackRepo.get().getMaternityLeave()) {
						 System.out.println("it is equal");
							leaveTrack.setMaternityLeave(0.0f);
							historyDetails.setLopdays(0.0f);
							historyRepository.save(historyDetails);
							leaveTrackRepository.save(leaveTrack);
						}
					 else
					if(historyDetails.getNoofdays()<leaveTrackRepo.get().getMaternityLeave()) {
						float num=historyDetails.getNoofdays();
						float sick= leaveTrackRepo.get().getMaternityLeave()-historyDetails.getNoofdays() ;
						if(sick < 0.5) {
							leaveTrack.setMaternityLeave(0.0f);
							historyDetails.setLopdays(num);
						historyRepository.save(historyDetails);
							leaveTrackRepository.save(leaveTrack);
						
						}else {
							leaveTrack.setMaternityLeave(sick);
							historyDetails.setLopdays(0.0f);historyRepository.save(historyDetails);
							leaveTrackRepository.save(leaveTrack);
						}
						
					}
					else {
						float lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getMaternityLeave();
						leaveTrack.setMaternityLeave(lop);
						historyDetails.setLopdays(lop);
						leaveTrackRepository.save(leaveTrack);
						}
				}
					
				
				else {
					float lop= historyDetails.getNoofdays()-leaveTrackRepo.get().getMaternityLeave();
						historyDetails.setLopdays(lop);
						leaveTrackRepository.save(leaveTrack);
					}
			 }
		
		historyDetails.setMaternityLeave(leaveTrackRepo.get().getMaternityLeave());
		historyDetails.setPrivilegeLeave(leaveTrackRepo.get().getPrivilegeLeave());
		historyDetails.setBereavementLeave(leaveTrackRepo.get().getBereavementLeave());
		historyDetails.setSickLeave(leaveTrackRepo.get().getSickLeave());
		historyDetails.setCasualLeave(leaveTrackRepo.get().getCasualLeave());
		historyDetails.setStatus(status);
		if(historyDetails.getDesignation()!="Manager") {
			historyDetails.setApprovedBy(historyDetails.getManagername());
		}
		else {
			historyDetails.setApprovedBy(historyDetails.getName());
		}
		
	
		historyDetails.setApproveddate(LocalDateTime.now());
//		historyRepo.setCasualLeave(leaveTrack.getCasualLeave());
 		historyRepository.save(historyDetails);
 		
	}
}

	







