package com.digimation.goldengym.bean;

public class MemberScheduleBean extends ScheduleBean {
	private Integer memberScheduleId;
	private Integer memberId;
	private String firstName;
	private String email;
	private String lastName;
	private Integer trainerId;
	private String trainerName;
	private String trainerEmail;
	
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getTrainerEmail() {
		return trainerEmail;
	}
	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}
	public Integer getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getMemberScheduleId() {
		return memberScheduleId;
	}
	public void setMemberScheduleId(Integer memberScheduleId) {
		this.memberScheduleId = memberScheduleId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	
}
