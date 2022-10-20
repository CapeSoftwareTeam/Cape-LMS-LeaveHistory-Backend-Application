package com.capeelectric.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="history_table")
public class History {
	
	@Id
	@Column(name="HISTORY_ID")
	private Integer historyid;
	
	@Column(name="REGISTER_ID")
	private Integer registerid;
	
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
	private String leavetype;
	
	@Column(name="REASON_FOR_APPLY")
	private String reasonforapply;
	
	@Column(name="FROM_DATE")
	private Date fromdate;
	
	@Column(name="TO_DATE")
	private Date todate;
	
	@Column(name="NO_OF_DAYS")
	private Integer noofdays;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="LOP_DAYS")
	private Integer lopdays;
	
	@Column(name="CREATED_BY")
	private String createdby;
	
	@Column(name="APPROVED_DATE")
	private LocalDateTime approveddate ;
	
	@Column(name="CASUAL_LEAVE")
    private Integer casualLeave;
	
	@Column(name="SICK_LEAVE")
	private Integer sickLeave;
	
	@Column(name="APPROVED_BY")
	private String approvedBy;
	
	
	@Column(name="PRIVILEGE_LEAVE")
	private Integer privilegeLeave;
	
	@Column(name="BEREAVEMENT_LEAVE")
	private Integer bereavementLeave;
	
	@Column(name="MATERNITY_LEAVE")
	private Integer maternityLeave;

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

	public Integer getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(Integer noofdays) {
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

	public Integer getLopdays() {
		return lopdays;
	}

	public void setLopdays(Integer lopdays) {
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

	public void setApproveddate(LocalDateTime localDateTime) {
		this.approveddate = localDateTime;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getCasualLeave() {
		return casualLeave;
	}

	public void setCasualLeave(Integer casualLeave) {
		this.casualLeave = casualLeave;
	}

	public Integer getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(Integer sickLeave) {
		this.sickLeave = sickLeave;
	}

	public Integer getPrivilegeLeave() {
		return privilegeLeave;
	}

	public void setPrivilegeLeave(Integer privilegeLeave) {
		this.privilegeLeave = privilegeLeave;
	}

	public Integer getBereavementLeave() {
		return bereavementLeave;
	}

	public void setBereavementLeave(Integer bereavementLeave) {
		this.bereavementLeave = bereavementLeave;
	}

	public Integer getMaternityLeave() {
		return maternityLeave;
	}

	public void setMaternityLeave(Integer maternityLeave) {
		this.maternityLeave = maternityLeave;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	


}
