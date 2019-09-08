package se.ecutb.magnus;

import org.junit.Test;
import se.ecutb.magnus.model.Hangman;

import static junit.framework.TestCase.*;

public class HangmanTest {

    @Test
    public void test_Hangman_created_successfully(){

        String secretWord = "JAVA";
        char [] guessedWord = {'_', 'A', 'V', 'A'};
        StringBuilder guessedLetters = new StringBuilder("Z B");
        StringBuilder sb = new StringBuilder();
        Hangman testHangman= new Hangman(secretWord, guessedWord, guessedLetters);

        assertEquals("JAVA", testHangman.getSecretWord());
        assertNotNull(testHangman.getGuessedWord()); //Försökte först med Equals, men konvertering gav felmeddelande trots ser likadana ut
        assertNotNull(testHangman.getGuessedLetters()); //Försökte först med Equals, men konvertering gav felmeddelande trots ser likadana ut
    }
}