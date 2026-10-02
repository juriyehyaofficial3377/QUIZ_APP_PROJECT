package com.example;

import java.util.*;

/*
 * to run the Quiz Program
 * shows polymorphism by using the class Quiz
 * run the Quiz and shows leader board
 */
public class QuizApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Quiz App!");
		System.out.println("Choose a quiz category: ");
		System.out.println("1. Math");
		System.out.println("2. Science");
		
	
		int choice = scanner.nextInt();
		Quiz quiz;
		
//Quiz تعدد الاشكال : نفس الكود لاي نوع  
		if (choice == 1) {
			quiz = new MathQuiz();
		} else {
			quiz = new ScienceQuiz();
		}
		quiz.startQuiz();
		quiz.showLeaderboard();
		scanner.close();
	}
}
