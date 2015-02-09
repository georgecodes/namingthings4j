package com.elevenware.nyaaas.visitors;

import com.elevenware.nyaaas.model.Tag;
import com.elevenware.nyaaas.model.TaggedWordBucket;
import com.elevenware.nyaaas.model.Word;

import java.util.HashSet;
import java.util.Set;

public class AllByTagBucketVisitor implements FilteringBucketVisitor {
    private final Tag[] tags;
    private Set<Word> words;

    public AllByTagBucketVisitor(Tag... tags) {
        this.tags = tags;
    }

    @Override
    public void accept(TaggedWordBucket wordBucket) {
        this.words = new HashSet<>();
        for(Tag tag: tags) {
            words.addAll(wordBucket.getBucket().get(tag));
        }
    }

    @Override
    public Set<Word> words() {
        return words;
    }
}
