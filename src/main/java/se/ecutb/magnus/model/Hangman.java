package se.ecutb.magnus.model;

public class Hangman {
    private String secretWord;
    private char [] guessedWord;
    private StringBuilder guessedLetters;

    public Hangman(String secretWord, char[] guessedWord, StringBuilder guessedLetters) {
        this.secretWord = secretWord;
        this.guessedWord = guessedWord;
        this.guessedLetters = guessedLetters;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public char[] getGuessedWord() {
        return guessedWord;
    }

    public void setGuessedWord(char[] guessedWord) {
        this.guessedWord = guessedWord;
    }

    public StringBuilder getGuessedLetters() {
        return guessedLetters;
    }

    private void setGuessedLetters(StringBuilder guessedLetters) {
        this.guessedLetters = guessedLetters;
    }

    public void modifyGuessedWord (int i, char guess){
        getGuessedWord();
        guessedWord [i] = guess;
    }

    public void appendGuessedLetters(String guess){
        setGuessedLetters(getGuessedLetters().append(" ").append(guess));
    }

    public boolean checkWord(String guess) {
        return getSecretWord().equalsIgnoreCase(guess);
    }

    public boolean checkHang (){
        return String.copyValueOf(getGuessedWord()).equalsIgnoreCase(getSecretWord());
    }
    public void printGuessedWord(){
        int i;
        System.out.print("\n");
        for (i = 0; i < getGuessedWord().length; i++){
            System.out.print(getGuessedWord()[i]+ " ");
        }
    }
}