package com.example;
//basic class represents a single question
public class Question { 
	private String questionText;
	private String[] options;
	private int correctAnswer;
	
	public Question(String questionText, String[] options, int correctAnswer) {
		this.questionText = questionText;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}
	public String questionText() {
		return questionText;
	}
	public String[] getOptions() {
		return options;
	}
	public int getCorrectAnswer() {
		return correctAnswer;
	}
}

