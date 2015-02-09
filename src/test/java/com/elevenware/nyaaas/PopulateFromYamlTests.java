package com.elevenware.nyaaas;

import com.elevenware.nyaaas.model.Tag;
import com.elevenware.nyaaas.model.TaggedWordBucket;
import com.elevenware.nyaaas.model.Word;
import com.elevenware.nyaaas.visitors.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class PopulateFromYamlTests {

    private static TaggedWordBucket bucket;
    private static Tag noun;
    private static Tag rude;
    private static Tag adjective;

    @Test
    public void loadsAndTagsFromYaml() {

        FilteringBucketVisitor visitor = new AllByTagBucketVisitor(noun);
        bucket.visit(visitor);

        Set<Word> nouns = visitor.words();

        assertEquals(2382, nouns.size());

    }

    @Test
    public void findByLetterAndTag() {

        FilteringBucketVisitor visitor = new ByLetterAndTagsBucketVisitor("x", noun);

        bucket.visit(visitor);

        Set<Word> nouns = visitor.words();

        assertEquals(16, nouns.size());

    }

    @Test
    public void findWordsByTag() {

        FilteringBucketVisitor allByTag = new AllByTagBucketVisitor(noun);
        bucket.visit(allByTag);
        Set<Word> nouns = allByTag.words();

        assertNotNull(nouns);
        assertEquals(2382, nouns.size());

    }

    @Test
    public void findWordsByMultipleTags() {

        FilteringBucketVisitor allByTags = new AllByTagBucketVisitor(noun, adjective);

        bucket.visit(allByTags);
        Set<Word> nouns = allByTags.words();

        assertNotNull(nouns);
        assertEquals(3535, nouns.size());

    }

    @Test
    public void findWordsWhichHaveMultipleTags() {

        FilteringBucketVisitor allByAll = new HasAllTagsBucketVisitor(noun, rude);

        bucket.visit(allByAll);
        Set<Word> nouns = allByAll.words();

        assertNotNull(nouns);
        assertEquals(39, nouns.size());

    }

    @BeforeClass
    public static void setup() {
        bucket = new TaggedWordBucket();
        noun = bucket.createTag("noun");
        rude = bucket.createTag("rude");
        adjective = bucket.createTag("adjective");
        bucket.visit(new YamlLoadingVisitor("/wordlists/nouns.yaml", noun));
        bucket.visit(new YamlLoadingVisitor("/wordlists/adjectives.yaml", adjective));
        bucket.visit(new YamlLoadingVisitor("/wordlists/rudenouns.yaml", noun, rude));
        bucket.visit(new YamlLoadingVisitor("/wordlists/rudeadjectives.yaml", adjective, rude));
    }

}
