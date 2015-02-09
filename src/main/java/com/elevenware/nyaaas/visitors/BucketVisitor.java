package com.elevenware.nyaaas.visitors;

import com.elevenware.nyaaas.model.TaggedWordBucket;

public interface BucketVisitor {
    void accept(TaggedWordBucket wordBucket);
}
