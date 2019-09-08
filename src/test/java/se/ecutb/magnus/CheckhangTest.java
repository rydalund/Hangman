package se.ecutb.magnus;

import org.junit.Test;
import se.ecutb.magnus.model.Hangman;

import static junit.framework.TestCase.assertTrue;

public class CheckhangTest {

    @Test
    public void test_Hangman_method_checkHang(){

        String secretWord = "LENOVO";
        char [] guessedWord = {'L', 'E', 'N', 'O', 'V', 'O'};
        StringBuilder guessedLetters = new StringBuilder();

        Hangman testHangman5 = new Hangman(secretWord, guessedWord, guessedLetters);
        assertTrue(testHangman5.checkHang());
    }
}