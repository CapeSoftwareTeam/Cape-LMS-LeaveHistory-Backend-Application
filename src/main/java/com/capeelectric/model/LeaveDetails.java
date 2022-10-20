package com.capeelectric.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leave_details")
public class LeaveDetails {
	
	@Id
	@Column(name="L_ID")
	private Integer l_Id;
	
	@Column(name="EXPERIENCE")
	private Integer experience;
	
	@Column(name="CASUAL_LEAVE")
    private Integer casualLeave;
	
	@Column(name="SICK_LEAVE")
	private Integer sickLeave;
	
	@Column(name="PRIVILAGE_LEAVE")
	private Integer privilegeLeave;
	
	@Column(name="BEREAVEMENT_LEAVE")
	private Integer bereavementLeave;
	
	@Column(name="MATERNITY_LEAVE")
	private Integer maternityLeave;
	
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

	public Integer getL_Id() {
		return l_Id;
	}

	public void setL_Id(Integer l_Id) {
		this.l_Id = l_Id;
	}

	

	
}
