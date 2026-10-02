package com.example;
/*
 * فئة فرعية لتمثل اختبار العلوم 
 * يرث من الكلاس الاساسي Quiz
 */
public class ScienceQuiz extends Quiz {
	public ScienceQuiz() {
		super("Science");
		
//add science questions
		addQuestion(new Question("what plant is known as the red planet?", new String[]{"Earth", "Mars", "Venus", "Jupiter"}, 2));
		addQuestion(new Question("water freezes at what temperature?", new String[]{"0C", "50C", "100C", "25C"}, 3));
	}
}
