package com.elevenware.nyaaas;

public class SimpleNameService implements NameService {

    private final WordList adjectiveList;
    private final WordList nounList;

    public SimpleNameService() {
        adjectiveList = new WordList("adjectives.yaml");
        nounList = new WordList("nouns.yaml");
    }

    @Override
    public String getAdjectiveNounPair() {
        Word adjective = adjectiveList.randomWord();
        Word noun = nounList.randomWord();
        return String.format("%s-%s", adjective.getText(), noun.getText());
    }
}
