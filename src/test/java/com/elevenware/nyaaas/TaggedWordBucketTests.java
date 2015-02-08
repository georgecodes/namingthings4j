package com.elevenware.nyaaas;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class TaggedWordBucketTests {
    
    private TaggedWordBucket bucket;
    private Tag nounTag;
    private Tag adjective;
    private Tag rude;

    @Test
    public void findWordsByTag() {

        BucketVisitor allByTag = new AllByTagBucketVisitor(nounTag);
        bucket.visit(allByTag);
        Set<Word> nouns = allByTag.words();

                assertNotNull(nouns);
        assertEquals(4, nouns.size());

    }

    @Test
    public void findWordsByMultipleTags() {

        Set<Word> nouns = bucket.getAllBy(nounTag, rude);

        assertNotNull(nouns);
        assertEquals(4, nouns.size());

    }

    @Test
    public void findWordsWhichHaveMultipleTags() {

        Set<Word> nouns = bucket.getAllByAll(nounTag, rude);

        assertNotNull(nouns);
        assertEquals(1, nouns.size());

        assertEquals("table", nouns.iterator().next().getText());

    }
    
    @Before
    public void setup() {
        bucket = new TaggedWordBucket();
        nounTag = bucket.createTag("noun");
        adjective = bucket.createTag("adjective");
        rude = bucket.createTag("rude");
        Word table = bucket.createWord("table");
        table.addTag(nounTag);
        table.addTag(rude);
        Word competitor = bucket.createWord("competitor");
        competitor.addTag(nounTag);
        Word gazelle = bucket.createWord("gazelle");
        gazelle.addTag(nounTag);
        Word octopus = bucket.createWord("octopus");
        octopus.addTag(nounTag);
        Word exotic = bucket.createWord("exotic");
        exotic.addTag(adjective);
        Word secretive = bucket.createWord("secretive");
        secretive.addTag(adjective);
    }

}
