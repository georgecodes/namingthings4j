package com.elevenware.nyaaas.visitors;

import com.elevenware.nyaaas.model.Word;

import java.util.Set;

public interface FilteringBucketVisitor extends BucketVisitor {

    Set<Word> words();

}
