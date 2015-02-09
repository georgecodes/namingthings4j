package com.elevenware.nyaaas.visitors;

import com.elevenware.nyaaas.model.Tag;
import com.elevenware.nyaaas.model.TaggedWordBucket;
import com.elevenware.nyaaas.model.Word;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class YamlLoadingVisitor implements BucketVisitor {

    private final InputStream inputStream;
    private final Tag[] tags;

    public YamlLoadingVisitor(InputStream inputStream, Tag...tags) {
        this.inputStream = inputStream;
        this.tags = tags;
    }

    public YamlLoadingVisitor(String resource, Tag...tags) {
        this(YamlLoadingVisitor.class.getResourceAsStream(resource), tags);
    }

    @Override
    public void accept(TaggedWordBucket wordBucket) {
        Yaml yaml = new Yaml();
        Map<String, Object> base = (Map<String, Object>) yaml.load(inputStream);
        Map<String,List<Object>> allWords = (Map<String, List<Object>>) base.get("words");
        for(List<Object> list: allWords.values()) {
            for(Object object: list) {
                String wordText = String.valueOf(object);
                Word word = wordBucket.createWord(wordText);
                for(Tag tag: tags) {
                    word.addTag(tag);
                }
            }
        }
    }

}
