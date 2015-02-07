package com.elevenware.nyaaas;

public interface WordList {
    Word getFirstWordStartingWith(String letter);

    Word getRandomWordStartingWith(String letter);

    Word randomWord();
}
