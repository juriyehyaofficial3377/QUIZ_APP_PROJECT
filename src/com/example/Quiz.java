package com.example;
import java.util.*;
/**
* class اساسي يمثل أي Quiz
* هذا الكلاس abstract لانه يعطي الاساس لاي Quiz (رياضيات , علوم , الخ)
* و يطبق ال QuizRules interface لتحديد الوظائف الاساسية
*/
public abstract class Quiz implements QuizRules {
//Quiz type
	protected String category;
	
//list of question in this Quiz
	protected List<Question> questions = new ArrayList<>();
	
//record points for each user
	protected Map<String, Integer> leaderboard = new HashMap<>();
	
/*
* Constructor to specify the name/type of quiz
* @param category Quiz name
*/
	public Quiz(String category) {
		this.category = category;
	}
/*
 * add a question to the Quiz
 * @param a Question object
 */
	public void addQuestion(Question q) {
		questions.add(q);
	}

	
/*
 * the Quiz starts and points are calculated
 * display each question and its options
 * (Thread Timer)gives 10 seconds for each question
 * compares the user's answer with the correct answer
 * calculates points and adds to the Leader board
 */
	public void startQuiz() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		int score = 0;
	
		
		for (Question q : questions) {
			System.out.println(" " + q.questionText());//display question
			
			String[] options = q.getOptions();
			for (int i = 0; i < options.length; i++) {
				System.out.println((i + 1) + ". " + options[i]);//display options
			}
			
//timer 
			boolean[] timeUp = {false};
			
		Thread timer = new Thread(() -> {
			try {
				Thread.sleep(10000);//waiting time
				timeUp[0] = true;//Time's up
				System.out.println("Time is over! go to the next question.");
			} catch (InterruptedException e) {
				
			}
		});
		timer.start();
		System.out.println("Your answer: ");
		String userAnswer = scanner.nextLine();
		
		if (!timeUp[0]) {
			timer.interrupt();//if the user answers before the time is up, the timer stops
			try {
				int answer = Integer.parseInt(userAnswer);
				if (answer == q.getCorrectAnswer()) {
					System.out.println("Correct!");
					score++;
				} else {
					System.out.println("Wrong!    The Correct answer is :"  + options[q.getCorrectAnswer() - 1]);
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Moving on.");
			  }
			}   
		}
		System.out.println("You got " + score + " out of " + questions.size());
		leaderboard.put(name, score);//record the result
	}

/*
 * display the leader board
 * shows names/points
 */
	public void showLeaderboard() {
		System.out.println(" a cup Leaderboard for" + category + "Quiz: ");
		for (Map.Entry<String, Integer> entry : leaderboard.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue() + " points");
		}
	}
}

