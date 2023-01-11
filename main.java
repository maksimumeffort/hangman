package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static String art(int i) {
		String[] hangmanStages = {
				"""
				 =========
				""","""
		           +---+
		           |   |
		               |
		               |
		               |
		               |
		         =========
		         """, """
		           +---+
		           |   |
		           O   |
		               |
		               |
		               |
		         =========
		         """, """
		           +---+
		           |   |
		           O   |
		           |   |
		               |
		               |
		         =========
		         """, """
		           +---+
		           |   |
		           O   |
		          /|   |
		               |
		               |
		         =========
		         """, """
		          +---+
		           |   |
		           O   |
		          /|\\  |
		               |
		               |
		         =========		
		         """, """
				  +---+
				  |    |
				  O    |
				 /|\\   |
				 /     |
				       |
				=========
				""", """
				  +---+
				  |    |
				  O    |
				 /|\\   |
				 / \\   |
				       |
				=========
		        """};
		return hangmanStages[i];
		}

	public static String randomWord() {
		
		String[] words = {"useful", "random", "hangman", "console", "application", "represent", "underscore", "example", "reveal"};
		
		Random random = new Random();
		int randIndex = random.nextInt(words.length);
		
		return words[randIndex];
	}
	
	
	public static void main(String[] args) {
		
	 // variables setup
		
	 String rightAnswer = randomWord();
	 Integer amountOfGuesses = 7;
	 Integer amountOfWrongGuesses = 0;
	 
	 ArrayList<String> splitAnswer = new ArrayList<String>(Arrays.asList(rightAnswer.split("")));
	 ArrayList<String> hiddenAnswer = new ArrayList<String>();
	 
	 splitAnswer.forEach(letter -> {hiddenAnswer.add("_");});
	 
	 // game logic

	 
	 while(amountOfWrongGuesses < amountOfGuesses && hiddenAnswer.contains("_")){
		 System.out.println(art(amountOfWrongGuesses));
		 System.out.println(hiddenAnswer);
		 
		 Scanner s = new Scanner(System.in);
		 
		 System.out.println("Guess a letter:");
		 System.out.print("> ");
		 String userGuess = s.next();
		 
		 if(splitAnswer.contains(userGuess)) {
		
			 int indexToSet = splitAnswer.indexOf(userGuess);
			 // loop through the splitanswer array and insert the value into hiddenanswerarry at the index
			 int lastIndex = splitAnswer.lastIndexOf(userGuess);
			 
			 if(indexToSet == lastIndex) {
				 hiddenAnswer.set(indexToSet, userGuess);
			 } else {
				 
				 ArrayList<Integer> indices = new ArrayList<>(); 
				 
				 for (int i = 0; i < splitAnswer.size(); ++i) {
					 if(splitAnswer.get(i).equals(userGuess)) {
						 indices.add(i);
					 }
				 }
				 indices.forEach(index -> {hiddenAnswer.set(index, userGuess);});
			 }

		 } else {
			 amountOfWrongGuesses += 1;
		 }
		 
	 }
	 
	 System.out.println(art(amountOfWrongGuesses));
	 System.out.println(hiddenAnswer);
	 System.out.println(hiddenAnswer.contains("_") ? "Game Over. You Lost" : "Congratulations You Won!");
	 

	}

}
