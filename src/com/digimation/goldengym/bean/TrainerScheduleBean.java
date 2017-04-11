package com.digimation.goldengym.bean;

public class TrainerScheduleBean extends ScheduleBean {
	private Integer trainerScheduleId;
	private Integer trainerId;
	private String firstName;
	private String email;
	private String lastName;
	
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
	public Integer getTrainerScheduleId() {
		return trainerScheduleId;
	}
	public void setTrainerScheduleId(Integer trainerScheduleId) {
		this.trainerScheduleId = trainerScheduleId;
	}
	public Integer getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}
	
}
