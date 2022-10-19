package com.capeelectric.model;

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
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@Column(name="CREATED_DATE")
	private Date createddate;
	
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
	private Date createdby;
	
	@Column(name="APPROVED_DATE")
	private Date approveddate ;

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

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
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

	public Date getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Date createdby) {
		this.createdby = createdby;
	}

	public Date getApproveddate() {
		return approveddate;
	}

	public void setApproveddate(Date approveddate) {
		this.approveddate = approveddate;
	}


}
