package com.elevenware.nyaaas;

import java.util.*;

public class TaggedWordBucket {

    private Set<Tag> tags;
    private Map<Tag, Set<Word>> bucket;

    public TaggedWordBucket() {
        tags = new HashSet<>();
        bucket = new HashMap<>();
    }

    public Tag createTag(String tagName) {
        Tag tag = new Tag(tagName);
        tags.add(tag);
        bucket.put(tag, new HashSet<Word>());
        return tag;
    }

    public Word createWord(String text) {
        Word word = new Word(text, this);
        return word;
    }

    public void addToTag(Tag tag, Word word) {
        bucket.get(tag).add(word);
    }

    public void visit(BucketVisitor visitor) {
        visitor.accept(this);
    }

    public Map<Tag, Set<Word>> getBucket() {
        return bucket;
    }
}
