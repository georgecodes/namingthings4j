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

        System.setProperty("random.seed", "2904");

        WordList wordList = new WordList("adjectives.yaml");
        Word word = wordList.getRandomWordStartingWith("a");

        assertNotNull(word);
        assertEquals("annoying", word.getText());

    }

    @Test
    public void generateRandomWord() {

        System.setProperty("random.seed", "83764");

        WordList wordList = new WordList("adjectives.yaml");
        Word word = wordList.randomWord();

        assertNotNull(word);
        assertEquals("maddening", word.getText());

    }

}
