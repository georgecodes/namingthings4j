package com.elevenware.nyaaas;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HasAllTagsBucketVisitor implements BucketVisitor {

    private final Tag[] tags;
    private Set<Word> words;

    public HasAllTagsBucketVisitor(Tag...tags) {
        this.tags = tags;
    }

    @Override
    public void accept(TaggedWordBucket wordBucket) {
        Set<Set<Word>> sets = new HashSet<>();
        for(Tag tag: tags) {
            sets.add(new HashSet<>(wordBucket.getBucket().get(tag)));
        }
        Iterator<Set<Word>> iter = sets.iterator();
        words = iter.next();
        while(iter.hasNext()) {
            words.retainAll(iter.next());
        }

    }

    @Override
    public Set<Word> words() {
        return words;
    }
}
