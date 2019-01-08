package com.cg.bean;

public class QuestionBean {
	private String businessSegment;
	 private String question;
	 private String answer;
	 private int weightage;
	 private int premium;
	 private String username;
	public String getBusinessSegment() {
		return businessSegment;
	}
	public void setBusinessSegment(String businessSegment) {
		this.businessSegment = businessSegment;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getWeightage() {
		return weightage;
	}
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	public int getPremium() {
		return premium;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
