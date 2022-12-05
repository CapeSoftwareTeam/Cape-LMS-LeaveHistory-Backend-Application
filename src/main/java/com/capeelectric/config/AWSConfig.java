package com.capeelectric.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AWSConfig {
	@Value("${aws.email.send.pdf}")
	private String sendEmailWithPDF;
	
	@Value("${aws.email.send}")
	private String sendEmail;

	
//	leaveApplyEmail
	@Value("${aws.email.send.comment}")
	private String sendLeaveApply;
	
	@Value("${aws.email.send.admin}") 
	private String sendEmailToAdmin;
	
	@Value("${aws.email.send.approval}")
	private String sendEmailForApproval;
	
	@Value("${aws.email.send.lmsemail}")
	private String sendLmsEmail;

	/**
	 * @return the sendEmailWithPDF
	 */
	public String getSendEmailWithPDF() {
		return sendEmailWithPDF;
	}

	/**
	 * @param sendEmailWithPDF the sendEmailWithPDF to set
	 */
	public void setSendEmailWithPDF(String sendEmailWithPDF) {
		this.sendEmailWithPDF = sendEmailWithPDF;
	}

	/**
	 * @return the sendEmail
	 */
	public String getSendEmail() {
		return sendEmail;
	}

	/**
	 * @param sendEmail the sendEmail to set
	 */
	public void setSendEmail(String sendEmail) {
		this.sendEmail = sendEmail;
	}

	
	/**
	 * @return the sentEmailLeaveApply
	 */
	public String getSendLeaveApply() {
		return sendLeaveApply;
	}

	/**
	 * @param sentEmailLeaveApply the sentEmailLeaveApply to set
	 */
	public void setSendLeaveApply(String sendLeaveApply) {
		this.sendLeaveApply = sendLeaveApply;
	}

	/**
	 * @return the sendEmailToAdmin
	 */
	public String getSendEmailToAdmin() {
		return sendEmailToAdmin;
	}

	/**
	 * @param sendEmailToAdmin the sendEmailToAdmin to set
	 */
	public void setSendEmailToAdmin(String sendEmailToAdmin) {
		this.sendEmailToAdmin = sendEmailToAdmin;
	}

	/**
	 * @return the sendEmailForApproval
	 */
	public String getSendEmailForApproval() {
		return sendEmailForApproval;
	}

	/**
	 * @param sendEmailForApproval the sendEmailForApproval to set
	 */
	public void setSendEmailForApproval(String sendEmailForApproval) {
		this.sendEmailForApproval = sendEmailForApproval;
	}

	public String getSendLmsEmail() {
		return sendLmsEmail;
	}

	public void setSendLmsEmail(String sendLmsEmail) {
		this.sendLmsEmail = sendLmsEmail;
	}
		
}