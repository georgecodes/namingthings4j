package com.elevenware.nyaaas;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordListTests {

    @Test
    public void findFirstWordWithSpecificLetter() {

        WordList wordList = new WordList("adjectives.yaml");
        Word word = wordList.getFirstWordStartingWith("a");

        assertNotNull(word);
        assertEquals("aback", word.getText());

    }

    @Test
    public void findRandomWordWithSpecificLetter() {

        RandomNumber.seed(8387L);

        WordList wordList = new WordList("adjectives.yaml");
        Word word = wordList.getRandomWordStartingWith("a");

        assertNotNull(word);
        assertEquals("animated", word.getText());

    }

    @Test
    public void generateRandomWord() {

        RandomNumber.seed(2272L);

        WordList wordList = new WordList("adjectives.yaml");
        Word word = wordList.randomWord();

        assertNotNull(word);
        assertEquals("sordid", word.getText());

    }

}
