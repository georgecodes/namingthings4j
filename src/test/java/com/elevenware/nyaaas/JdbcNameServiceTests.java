package com.elevenware.nyaaas;

import com.elevenware.nyaaas.model.Tag;
import com.elevenware.nyaaas.model.Word;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

public class JdbcNameServiceTests {

    @Test
    public void findAllNouns() {

//        NameService nameService = new JdbcNameService("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
//
//        Yaml yaml = new Yaml();
//
//        Map<String, Object> base = (Map<String, Object>) yaml.load(getClass().getResourceAsStream("/wordlists/nouns.yaml"));
//        Map<String,List<Object>> allWords = (Map<String, List<Object>>) base.get("words");
//        for(List<Object> list: allWords.values()) {
//            for(Object object: list) {
//                String wordText = String.valueOf(object);
//                Word word = wordBucket.createWord(wordText);
//                for(Tag tag: tags) {
//                    word.addTag(tag);
//                }
//            }
//        }

    }

}
