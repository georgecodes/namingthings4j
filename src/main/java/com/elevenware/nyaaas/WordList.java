package com.elevenware.nyaaas;

import com.elevenware.nyaaas.model.Word;

public interface WordList {
    Word getFirstWordStartingWith(String letter);

    Word getRandomWordStartingWith(String letter);

    Word randomWord();
}
