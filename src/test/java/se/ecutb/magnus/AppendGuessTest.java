package se.ecutb.magnus;

import org.junit.Test;
import se.ecutb.magnus.model.Hangman;

import static junit.framework.TestCase.assertNotNull;

public class AppendGuessTest {

    @Test
    public void test_Hangman_method_append_guesses(){

        String secretWord = "MAVEN";
        char [] guessedWord = {'_', '_', '_', '_', '_'};
        StringBuilder guessedLetters = new StringBuilder();
        String guess = "Z";

        Hangman testHangman3 = new Hangman(secretWord, guessedWord, guessedLetters);
        testHangman3.appendGuessedLetters(guess);

        assertNotNull(testHangman3.getGuessedWord());
    }
}
