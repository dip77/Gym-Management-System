package com.digimation.goldengym.bean;

public class SubscriptionBean extends PackageDetailBean{
private int subscriptionId;
private int memberId;
private String startDate;
private String endDate;
private String email;
private String firstName;
private String lastName;
public int getSubscriptionId() {
	return subscriptionId;
}
public void setSubscriptionId(int subscriptionId) {
	this.subscriptionId = subscriptionId;
}
public int getMemberId() {
	return memberId;
}
public void setMemberId(int memberId) {
	this.memberId = memberId;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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

}
