package hangman;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.StringBuilder;

import static generic.CommandLine.*;

public class Hangman {
	private StringBuilder hangman = new StringBuilder("""
                ___________
                |  /   ccc
                | /     c
                |/      c
                |      ccc
                |\\     c c
                | \\
                ============
				""");
	private ArrayList<Character> theMan = new ArrayList<>(Arrays.asList(
		'\\', '|', '/',
		      '|',
		      'o',
		 '/', '0', '\\',
		 '/',      '\\'		
	));
	private final int TOTAL_GUESSES;
	
	public Hangman(){
		TOTAL_GUESSES = theMan.size();
	}
	
	private char askLetter(String prompt){
		do{
			String input = askForString(prompt).toUpperCase().trim();
			char letter = input.charAt(0);
			if(input.length() == 1 && Character.isLetter(letter)){
				return input.charAt(0);
			}
			System.out.println("Please enter a single letter");
		}while(true);
	}
	
	private String askTheWord(String prompt){
		do{
			String word = askForString(prompt).trim().toUpperCase();
			if(word.contains(" ")){
				System.out.println("Please enter a single word");
			}
			else if(!word.chars().allMatch(Character::isLetter)){
				System.out.println("Please use only letters");
			}else return word;
			
		}while(true);
	}
	
	public void play(){
		String word = askTheWord("user 1 please enter the word: ").trim();
		System.out.println("\n".repeat(50));
		
        ArrayList<String> guessedWord = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            guessedWord.add("_");
        }
		
		ArrayList<Character> guessed = new ArrayList<>();
		do{
            char letter = askLetter("Guess a letter: ");
            System.out.println();
            if (guessed.contains(letter)) {
                System.out.println("You already tried this!");
                continue;
            } else {
                guessed.add(letter);
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) == letter) {
                        guessedWord.set(j, "" + letter);
                    }
                }
            }
            System.out.println(guessedWord);
            if (String.join("", guessedWord).equals(word)) {
                System.out.println("You guessed it!");
                return;
            }
			hangman.setCharAt(hangman.indexOf("c"), theMan.removeFirst());
			System.out.println(hangman.toString().replace("c", " "));
        }while(guessed.size() != TOTAL_GUESSES);
		
		System.out.println("You didn't find the word within 10 guesses");
		System.out.println("the word was: " + word);
	}
	
    public static void main(String[] args) {
		Hangman game = new Hangman();
		game.play();
    }
}
/*
Make a Hangman game
user 1 should enter a word
user 2 should see only underscores for each letter in the word, and should
guess a letter
if a letter is correct, the underscore in the displayed word is replaced by the
correct letter
if the word has been filled in completely, display the message that the user
has won
if the word has not been filled in completely after a number of turns (say 10),
display that the user has lost,
and show the word.
___________
|  /  \|/
| /    |
|/     o
|     /0\
|\    / \
| \
============
 */