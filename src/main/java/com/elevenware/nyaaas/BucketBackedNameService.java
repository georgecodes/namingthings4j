package com.elevenware.nyaaas;

import com.elevenware.nyaaas.model.TaggedWordBucket;
import com.elevenware.nyaaas.model.Word;

public class BucketBackedNameService implements NameService {
    private final TaggedWordBucket bucket;

    public BucketBackedNameService(TaggedWordBucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public String getAdjectiveNounPair() {
        return null;
    }

    @Override
    public String getAdjectiveNounPair(boolean suffixNumber) {
//        Word adjective = bucket.randomWord
//        Word noun = nounList.randomWord();
//        if(suffixNumber) {
//            return String.format("%s-%s-%04d", adjective.getText(), noun.getText(), random.nextInt(9999));
//        }
//        return String.format("%s-%s", adjective.getText(), noun.getText());
        return "";
    }

    @Override
    public String alliterateOn(String s) {
        return null;
    }

    @Override
    public String alliterateOn(String s, boolean suffixNumber) {
        return null;
    }
}
