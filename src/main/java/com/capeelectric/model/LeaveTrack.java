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
	private Float casualLeave;
	
	@Column(name="CARRYFORWARD_LEAVE")
	private Float carryForwardLeave;
	
	@Column(name="SICK_LEAVE")
	private Float sickLeave;
	
	@Column(name="PRIVILEGE_LEAVE")
	private Float privilegeLeave;
	
	@Column(name="BEREAVEMENT_LEAVE")
	private Float bereavementLeave;
	
	@Column(name="MATERNITY_LEAVE")
	private Float maternityLeave;

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

	public Float getCasualLeave() {
		return casualLeave;
	}

	public void setCasualLeave(Float casualLeave) {
		this.casualLeave = casualLeave;
	}

	public Float getCarryForwardLeave() {
		return carryForwardLeave;
	}

	public void setCarryForwardLeave(Float carryForwardLeave) {
		this.carryForwardLeave = carryForwardLeave;
	}

	public Float getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(Float sickLeave) {
		this.sickLeave = sickLeave;
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

}
