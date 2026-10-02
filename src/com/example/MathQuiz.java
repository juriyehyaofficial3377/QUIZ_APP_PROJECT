package com.example;
/*
 * فئة فرعية لتمثيل اختبار الرياضيات
 * يرث من الكلاس الاساسي Quiz
 */
public class MathQuiz extends Quiz {
	public MathQuiz() {
		super("Math");
			
//add math questions	
		addQuestion(new Question("5 + 3 = ?", new String[]{"6", "7", "8", "9"}, 3));
		addQuestion(new Question("10 - 4 = ?",new String[]{"5", "6", "7", "8"},2));
		addQuestion(new Question("2 * 6 = ?", new String[]{"10", "11", "12", "13"}, 3));
	}
}
