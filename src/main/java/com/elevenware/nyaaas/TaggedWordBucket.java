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

    public Set<Word> getAllBy(Tag... tags) {
        Set<Word> retVal = new HashSet<>();
        for(Tag tag: tags) {
            retVal.addAll(bucket.get(tag));
        }
        return retVal;
    }


    public void addToTag(Tag tag, Word word) {
        bucket.get(tag).add(word);
    }

    public Set<Word> getAllByAll(Tag... tags) {
        Set<Set<Word>> sets = new HashSet<>();
        for(Tag tag: tags) {
            sets.add(bucket.get(tag));
        }
        Iterator<Set<Word>> iter = sets.iterator();
        Set<Word> retVal = iter.next();
        while(iter.hasNext()) {
            retVal.retainAll(iter.next());
        }
        return retVal;
    }

    public void visit(BucketVisitor visitor) {
        visitor.accept(this);
    }
}
