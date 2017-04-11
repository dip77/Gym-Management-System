package com.digimation.goldengym.bean;

public class ProgressDetailBean extends ProgressBean {
private int progressDetailId;
private double chest;
private double bodyfat;
private double height;
private double weight;
private double forearms;
private double thigh;
private double biceps;
private double wrist;
private String date;

public ProgressDetailBean() {
chest=0.0;
bodyfat=0.0;
biceps=0.0;
forearms=0.0;
wrist=0.0;
thigh=0.0;

}
public int getProgressDetailId() {
	return progressDetailId;
}
public void setProgressDetailId(int progressDetailId) {
	this.progressDetailId = progressDetailId;
}
public double getChest() {
	return chest;
}
public void setChest(double chest) {
	this.chest = chest;
}
public double getBodyfat() {
	return bodyfat;
}
public void setBodyfat(double bodyfat) {
	this.bodyfat = bodyfat;
}
public double getHeight() {
	return height;
}
public void setHeight(double height) {
	this.height = height;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
public double getForearms() {
	return forearms;
}
public void setForearms(double forearms) {
	this.forearms = forearms;
}
public double getThigh() {
	return thigh;
}
public void setThigh(double thigh) {
	this.thigh = thigh;
}
public double getBiceps() {
	return biceps;
}
public void setBiceps(double biceps) {
	this.biceps = biceps;
}
public double getWrist() {
	return wrist;
}
public void setWrist(double wrist) {
	this.wrist = wrist;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}
