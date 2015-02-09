package com.elevenware.nyaaas.model;

import java.util.HashSet;
import java.util.Set;

public class Word {

    private final Set<Tag> tags;
    private TaggedWordBucket bucket;
    private String text;

    public Word(String text) {
        this.tags = new HashSet<>();
        this.text = text;
    }

    public Word(String text, TaggedWordBucket taggedWordBucket) {
        this(text);
        this.bucket = taggedWordBucket;
    }

    public String getText() {
        return text;
    }

    public Word addTag(Tag tag) {
        tags.add(tag);
        bucket.addToTag(tag, this);
        return this;
    }
}
