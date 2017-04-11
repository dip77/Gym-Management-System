package com.digimation.goldengym.bean;

public class UserInquiryBean {

	private int userInquiryId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String message;
	private String date;
	private String isRead;

	public int getUserInquiry() {
		return userInquiryId;
	}

	public void setUserInquiry(int userInquiry) {
		this.userInquiryId = userInquiry;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

}
