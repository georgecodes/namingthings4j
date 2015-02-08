package com.elevenware.nyaaas;

import java.util.HashSet;
import java.util.Set;

public class ByLetterAndTagsBucketVisitor implements BucketVisitor {

    private final String letter;
    private final Tag[] tags;
    private Set<Word> words;

    public ByLetterAndTagsBucketVisitor(String letter, Tag... tags) {
        this.letter = letter.toLowerCase();
        this.tags = tags;
        words = new HashSet<>();
    }

    @Override
    public void accept(TaggedWordBucket wordBucket) {
        for(Tag tag: tags) {
            for(Word word: wordBucket.getBucket().get(tag)) {
                if(word.getText().startsWith(letter)) {
                    words.add(word);
                }
            }
        }
    }

    @Override
    public Set<Word> words() {
        return words;
    }
}
