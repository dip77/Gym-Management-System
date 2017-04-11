package com.digimation.goldengym.bean;

public class TrainerSchedule extends ScheduleBean {
	private Integer trainerScheduleId;
	private Integer trainerId;
	public Integer getMemberScheduleId() {
		return trainerScheduleId;
	}
	public void setMemberScheduleId(Integer trainerScheduleId) {
		this.trainerScheduleId = trainerScheduleId;
	}
	public Integer getMemberId() {
		return trainerId;
	}
	public void setMemberId(Integer trainerId) {
		this.trainerId = trainerId;
	}
	
}
