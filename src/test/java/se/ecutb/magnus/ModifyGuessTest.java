package se.ecutb.magnus;

import org.junit.Test;
import se.ecutb.magnus.model.Hangman;

import static junit.framework.TestCase.assertEquals;

public class ModifyGuessTest {

    @Test
    public void test_Hangman_method_modify_guessed_owrd(){

        String secretWord = "TEST";
        char [] guessedWord = {'T', '_', 'S', 'T'};
        StringBuilder guessedLetters = new StringBuilder("P B");
        int i = 1;
        char guess = 'E';

        Hangman testHangman2 = new Hangman(secretWord, guessedWord, guessedLetters);
        testHangman2.modifyGuessedWord(i,guess);

        assertEquals(testHangman2.getGuessedWord()[i], 'E' );
    }
}
