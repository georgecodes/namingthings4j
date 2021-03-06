package com.elevenware.nyaaas;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WordList {

    private final Map<String, Object> base;
    private final RandomNumber random = new RandomNumber();


    public WordList(String root) {

        Yaml yaml = new Yaml();
        InputStream inputStream = getClass().getResourceAsStream(String.format("/wordlists/%s", root));
        this.base = (Map<String, Object>) yaml.load(inputStream);
    }

    public Word getFirstWordStartingWith(String letter) {
        letter = letter.toUpperCase();
        Map<String, Object> letterList = (Map<String, Object>) base.get("words");
        List<String> wordList = (List<String>) letterList.get(letter);
        return new Word(wordList.get(0));
    }

    public Word getRandomWordStartingWith(String letter) {
        letter = letter.toUpperCase();
        Map<String, Object> letterList = (Map<String, Object>) base.get("words");
        List<String> wordList = (List<String>) letterList.get(letter);
        int range = wordList.size() -1;
        int index = range > 0 ? random.nextInt(range) : 0;
        return new Word(wordList.get(index));
    }

    public Word randomWord() {
        char c = (char)(random.nextInt(26) + 'a');
        String letter = String.valueOf(c);
        return getRandomWordStartingWith(letter);
    }
}
