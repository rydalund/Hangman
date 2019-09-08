package se.ecutb.magnus;

import se.ecutb.magnus.model.Hangman;

import java.util.Scanner;

public class App {
    public static void main(String[] args) { //Hade tänkt snygga till och separera main, för att kunna testa delar, men tiden räckte inte till
        Scanner scanner = new Scanner(System.in);
        String [] words = {"CONSTRUCTOR", "PARAMETER", "VARIABLE", "PRIMITIVE", "MAVEN"};
        String guess;
        StringBuilder guessedLetters = new StringBuilder();
        int guessesRemaining = 8;
        boolean wordGuessed = false;
        String secretWord = words[(int) (Math.random()*words.length)];
        char [] guessedWord = secretWord.replaceAll("[A-Z]", "_").toCharArray();
        Hangman hangman = new Hangman(secretWord,guessedWord,guessedLetters);

        while (!wordGuessed && guessesRemaining > 0 && String.valueOf(hangman.getGuessedWord()).contains("_")) {
            hangman.printGuessedWord(); //Ville testa med att lägga in metoder
            System.out.println("\nYou have " + guessesRemaining + " guesses remaining");
            System.out.println("Your incorrect guesses: " + hangman.getGuessedLetters());
            System.out.println("Guess a letter or word: ");
            guess = scanner.next().trim().toUpperCase();

            if (guess.length() == secretWord.length()){
                 if (hangman.checkWord(guess)){ //Försöker minska på main
                     wordGuessed = true;
                     hangman.setGuessedWord(guess.toCharArray());
                }else{
                     guessesRemaining--;
                     hangman.appendGuessedLetters(guess);
                 }
            }
            else if (guess.length() == 1){

                if (hangman.getGuessedLetters().toString().contains(guess)){
                    System.out.println("You have already guessed: " + guess);
                    hangman.appendGuessedLetters(guess);

                }else if (!(hangman.getGuessedLetters().toString().contains(guess)) && ((hangman.getSecretWord().contains(guess)))){ //Nödlösning
                    System.out.println("Nice guess: ' " + guess + " ' is present");
                    for (int i= 0; i < hangman.getSecretWord().length(); i++) {
                        if (hangman.getSecretWord().charAt(i) == guess.charAt(0)) {
                            hangman.modifyGuessedWord(i,guess.charAt(0)); //Hade säker gått att lösa enklare
                        }
                    }
                }else{
                    System.out.println("Sorry '" + guess + "' is not present");
                    guessesRemaining--;
                    hangman.appendGuessedLetters(guess); //I uppgiften står att alla gissningar ska läggas här, men man brukar väl bara redovisa bosktäver som inte finns här?
                }
            }else{
                System.out.println("You can only enter single character or entire word, please try again: "); //Säger till om man matar in kortare än ord, längre än tecken
            }
        }

        if (hangman.checkHang()){
            System.out.print("You live :)\nThe word was: " + hangman.getSecretWord());

        } else {
            System.out.println("You die :(\nThe secret word was: " + hangman.getSecretWord());
        }
    }
}