package com.digimation.goldengym.bean;

public class PackageDetailBean extends PackageBean {
private int packageDetailId;
private int activityId;
private Integer amount;
private int memberTypeId;
private String activity;
private String memberType;
public int getPackageDetailId() {
	return packageDetailId;
}
public void setPackageDetailId(int packageDetailId) {
	this.packageDetailId = packageDetailId;
}
public int getActivityId() {
	return activityId;
}
public void setActivityId(int activityId) {
	this.activityId = activityId;
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}
public int getMemberTypeId() {
	return memberTypeId;
}
public void setMemberTypeId(int memberTypeId) {
	this.memberTypeId = memberTypeId;
}
public String getActivity() {
	return activity;
}
public void setActivity(String activity) {
	this.activity = activity;
}
public String getMemberType() {
	return memberType;
}
public void setMemberType(String memberType) {
	this.memberType = memberType;
}

}
