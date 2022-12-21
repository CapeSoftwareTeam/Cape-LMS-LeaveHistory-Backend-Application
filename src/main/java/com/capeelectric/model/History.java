package com.capeelectric.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="history_table")
public class History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="HISTORY_ID")
	private Integer historyid;
	
	@Column(name="REGISTER_ID")
	private Integer registerid;
	
	@Column(name="file_id")
	private Integer fileid;
	
	@Column(name="EMP_ID")
	private String empid;
	
	@Column(name="EXPERIENCE")
	private Integer experience;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@Column(name="CREATED_DATE")
	private LocalDateTime createddate;
	
	@Column(name="LEAVE_TYPE")
	private String leaveType;
	
	@Column(name="REASON_FOR_APPLY")
	private String reasonforapply;
	
	@Column(name="FROM_DATE")
	private Date fromdate;
	
	@Column(name="TO_DATE")
	private Date todate;
	
	@Column(name="N0_OF_DAYS")
	private Float noofdays;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="LOP_DAYS")
	private Float lopdays;
	
	@Column(name="CREATED_BY")
	private String createdby;
	
	@Column(name="APPROVED_DATE")
	private LocalDateTime approveddate ;
	
	@Column(name="CASUAL_LEAVE")
    private Float casualLeave;
	
	@Column(name="SICK_LEAVE")
	private Float sickLeave;
	
	@Column(name="APPROVED_BY")
	private String approvedBy;

	@Column(name="PRIVILEGE_LEAVE")
	private Float privilegeLeave;
	
	@Column(name="BEREAVEMENT_LEAVE")
	private Float bereavementLeave;
	
	@Column(name="MATERNITY_LEAVE")
	private Float maternityLeave;

	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="MANAGER_NAME")
	private String managername;
	

	@Column(name="MANAGER_EMAIL")
	private String manageremail;

	@Transient
	private LeaveTrack leaveTrack;

	public Integer getHistoryid() {
		return historyid;
	}

	public void setHistoryid(Integer historyid) {
		this.historyid = historyid;
	}

	public Integer getRegisterid() {
		return registerid;
	}

	public void setRegisterid(Integer registerid) {
		this.registerid = registerid;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDateTime getCreateddate() {
		return createddate;
	}

	public void setCreateddate(LocalDateTime createddate) {
		this.createddate = createddate;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getReasonforapply() {
		return reasonforapply;
	}

	public void setReasonforapply(String reasonforapply) {
		this.reasonforapply = reasonforapply;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public Float getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(Float noofdays) {
		this.noofdays = noofdays;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getLopdays() {
		return lopdays;
	}

	public void setLopdays(Float lopdays) {
		this.lopdays = lopdays;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public LocalDateTime getApproveddate() {
		return approveddate;
	}

	public void setApproveddate(LocalDateTime approveddate) {
		this.approveddate = approveddate;
	}

	public Float getCasualLeave() {
		return casualLeave;
	}

	public void setCasualLeave(Float casualLeave) {
		this.casualLeave = casualLeave;
	}

	public Float getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(Float sickLeave) {
		this.sickLeave = sickLeave;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Float getPrivilegeLeave() {
		return privilegeLeave;
	}

	public void setPrivilegeLeave(Float privilegeLeave) {
		this.privilegeLeave = privilegeLeave;
	}

	public Float getBereavementLeave() {
		return bereavementLeave;
	}

	public void setBereavementLeave(Float bereavementLeave) {
		this.bereavementLeave = bereavementLeave;
	}

	public Float getMaternityLeave() {
		return maternityLeave;
	}

	public void setMaternityLeave(Float maternityLeave) {
		this.maternityLeave = maternityLeave;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getManageremail() {
		return manageremail;
	}

	public void setManageremail(String manageremail) {
		this.manageremail = manageremail;
	}

	public LeaveTrack getLeaveTrack() {
		return leaveTrack;
	}

	public void setLeaveTrack(LeaveTrack leaveTrack) {
		this.leaveTrack = leaveTrack;
	}
	
	public Integer getFileid() {
		return fileid;
	}

	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}
	
	
}
	