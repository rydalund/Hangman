package se.ecutb.magnus;

import org.junit.Test;
import se.ecutb.magnus.model.Hangman;

import static junit.framework.TestCase.assertTrue;

public class CheckWorldTest {

    @Test
    public void test_Hangman_method_checkworld(){

        String secretWord = "IPHONE";
        char [] guessedWord = {'I', 'P', 'H', '_', 'N', 'E'};
        StringBuilder guessedLetters = new StringBuilder();
        String guess = "IPHONE";

        Hangman testHangman4 = new Hangman(secretWord, guessedWord, guessedLetters);
        assertTrue(testHangman4.checkWord(guess));
    }
}
