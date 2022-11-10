package com.capeelectric.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leavetrack_table")
public class LeaveTrack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="LEAVETRACK_ID")
	private Integer leaveTrackId;
	
	@Column(name="EMPID")
	private String empid;
	
	@Column(name="YEAR")
	private Integer year;
	
	@Column(name="CASUAL_LEAVE")
	private Integer casualLeave;
	
	@Column(name="CARRYFORWARD_LEAVE")
	private Integer carryForwardLeave;
	
	@Column(name="SICK_LEAVE")
	private Integer sickLeave;
	
	@Column(name="PRIVILEGE_LEAVE")
	private Integer privilegeLeave;
	
	@Column(name="BEREAVEMENT_LEAVE")
	private Integer bereavementLeave;
	
	@Column(name="MATERNITY_LEAVE")
	private Integer maternityLeave;

	public Integer getLeaveTrackId() {
		return leaveTrackId;
	}

	public void setLeaveTrackId(Integer leaveTrackId) {
		this.leaveTrackId = leaveTrackId;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getCasualLeave() {
		return casualLeave;
	}

	public void setCasualLeave(Integer casualLeave) {
		this.casualLeave = casualLeave;
	}

	public Integer getCarryForwardLeave() {
		return carryForwardLeave;
	}

	public void setCarryForwardLeave(Integer carryForwardLeave) {
		this.carryForwardLeave = carryForwardLeave;
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

}
