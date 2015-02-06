package com.elevenware.nyaaas;

import java.util.Random;

public class SimpleNameService implements NameService {

    private final WordList adjectiveList;
    private final WordList nounList;
    private RandomNumber random = new RandomNumber();

    public SimpleNameService() {
        adjectiveList = new WordList("adjectives.yaml");
        nounList = new WordList("nouns.yaml");
    }

    @Override
    public String getAdjectiveNounPair() {
       return getAdjectiveNounPair(false);
    }

    @Override
    public String getAdjectiveNounPair(boolean suffixNumber) {
        Word adjective = adjectiveList.randomWord();
        Word noun = nounList.randomWord();
        if(suffixNumber) {
            return String.format("%s-%s-%04d", adjective.getText(), noun.getText(), random.nextInt(9999));
        }
        return String.format("%s-%s", adjective.getText(), noun.getText());
    }

    @Override
    public String alliterateOn(String letter) {
        return alliterateOn(letter, false);
    }

    @Override
    public String alliterateOn(String letter, boolean suffixNumber) {
        Word adjective = adjectiveList.getRandomWordStartingWith(letter);
        Word noun = nounList.getRandomWordStartingWith(letter);
        if(suffixNumber) {
            return String.format("%s-%s-%04d", adjective.getText(), noun.getText(), random.nextInt(9999));
        }
        return String.format("%s-%s", adjective.getText(), noun.getText());
    }

}
