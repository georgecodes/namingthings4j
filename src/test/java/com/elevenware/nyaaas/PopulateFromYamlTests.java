package com.elevenware.nyaaas;

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

        BucketVisitor visitor = new AllByTagBucketVisitor(noun);
        bucket.visit(visitor);

        Set<Word> nouns = visitor.words();

        assertEquals(2382, nouns.size());

    }

    @Test
    public void findByLetterAndTag() {

        BucketVisitor visitor = new ByLetterAndTagsBucketVisitor("x", noun);

        bucket.visit(visitor);

        Set<Word> nouns = visitor.words();

        assertEquals(16, nouns.size());

    }

    @Test
    public void findWordsByTag() {

        BucketVisitor allByTag = new AllByTagBucketVisitor(noun);
        bucket.visit(allByTag);
        Set<Word> nouns = allByTag.words();

        assertNotNull(nouns);
        assertEquals(2382, nouns.size());

    }

    @Test
    public void findWordsByMultipleTags() {

        BucketVisitor allByTags = new AllByTagBucketVisitor(noun, adjective);

        bucket.visit(allByTags);
        Set<Word> nouns = allByTags.words();

        assertNotNull(nouns);
        assertEquals(3535, nouns.size());

    }

    @Test
    public void findWordsWhichHaveMultipleTags() {

        BucketVisitor allByAll = new HasAllTagsBucketVisitor(noun, rude);

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
        YamlLoader.loadYamlFromClasspath("/wordlists/nouns.yaml", bucket, noun);
        YamlLoader.loadYamlFromClasspath("/wordlists/adjectives.yaml", bucket, adjective);
        YamlLoader.loadYamlFromClasspath("/wordlists/rudenouns.yaml", bucket, noun, rude);
        YamlLoader.loadYamlFromClasspath("/wordlists/rudeadjectives.yaml", bucket, adjective, rude);
    }

}
