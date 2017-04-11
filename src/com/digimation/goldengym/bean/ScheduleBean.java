package com.digimation.goldengym.bean;

public class ScheduleBean extends ActivityBean {
private Integer Day;
private Integer scheduleId;
private String startTime;
private String endTime;
private Integer scheduleTimeId;



public Integer getDay() {
	return Day;
}
public void setDay(Integer day) {
	Day = day;
}
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public Integer getScheduleTimeId() {
	return scheduleTimeId;
}
public void setScheduleTimeId(Integer scheduleTimeId) {
	this.scheduleTimeId = scheduleTimeId;
}
public Integer getScheduleId() {
	return scheduleId;
}
public void setScheduleId(Integer scheduleId) {
	this.scheduleId = scheduleId;
}

}
