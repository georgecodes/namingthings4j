package com.elevenware.nyaaas;

import java.util.Set;

public interface BucketVisitor {
    void accept(TaggedWordBucket wordBucket);

    Set<Word> words();
}
