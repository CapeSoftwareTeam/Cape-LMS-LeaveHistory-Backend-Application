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
	private Integer lId;
	
	@Column(name="EXPERIENCE")
	private Integer experience;
	
	@Column(name="CASUAL_LEAVE")
    private Float casualLeave;
	
	@Column(name="SICK_LEAVE")
	private Float sickLeave;
	
	@Column(name="PRIVILAGE_LEAVE")
	private Float privilegeLeave;
	
	@Column(name="BEREAVEMENT_LEAVE")
	private Float bereavementLeave;
	
	@Column(name="MATERNITY_LEAVE")
	private Float maternityLeave;

	public Integer getlId() {
		return lId;
	}

	public void setlId(Integer lId) {
		this.lId = lId;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
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
