package com.elevenware.nyaaas;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class YamlLoader {

    public static void loadYaml(InputStream inputStream, TaggedWordBucket wordBucket, Tag...tags) {

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

    public static void loadYamlFromClasspath(String resource, TaggedWordBucket wordBucket, Tag...tags) {
        InputStream inputStream = YamlLoader.class.getResourceAsStream(resource);
        loadYaml(inputStream, wordBucket, tags);
    }
}
