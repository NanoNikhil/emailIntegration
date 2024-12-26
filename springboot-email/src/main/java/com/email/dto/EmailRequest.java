package com.email.dto;


public class EmailRequest {

    private String toEMail;
    private String subject;
    private String messageBody;
    private String attachment;
    private String[] toEmails;

	/*
	 * private String attachment; private String[] toEmails;
	 */
	public EmailRequest() {
		super();
	}

	
	public EmailRequest(String toEMail, String subject, String messageBody,String attachment,String[] toEmails) {
		super();
		this.toEMail = toEMail;
		this.subject = subject;
		this.messageBody = messageBody;
		this.attachment =attachment;
		this.toEmails =toEmails;
	}


	/*
	 * public EmailRequest(String toEMail, String subject, String messageBody,
	 * String attachment, String[] toEmails) { super(); this.toEMail = toEMail;
	 * this.subject = subject; this.messageBody = messageBody; this.attachment =
	 * attachment; this.toEmails = toEmails; }
	 */
	public String getToEMail() {
		return toEMail;
	}
	public void setToEMail(String toEMail) {
		this.toEMail = toEMail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String[] getToEmails() {
		return toEmails;
	}

	public void setToEmails(String[] toEmails) {
		this.toEmails = toEmails;
	}
    
    
}