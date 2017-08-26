package com.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;





public class QuestionContainer {
	
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private Double answer;
	
	public QuestionContainer()
	{
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public Double getAnswer() {
		return answer;
	}

	public void setAnswer(Double answer) {
		this.answer = answer;
	}
	
	
	

}
