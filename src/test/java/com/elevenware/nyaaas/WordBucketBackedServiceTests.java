package com.elevenware.nyaaas;

import com.elevenware.nyaaas.model.Tag;
import com.elevenware.nyaaas.model.TaggedWordBucket;
import com.elevenware.nyaaas.util.RandomNumber;
import com.elevenware.nyaaas.visitors.YamlLoadingVisitor;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordBucketBackedServiceTests {

    private static TaggedWordBucket bucket;
    private static Tag noun;
    private static Tag rude;
    private static Tag adjective;
    private static NameService nameService;

    @Test
    public void generateAdjectiveNounPair() {

        RandomNumber.seed(2034L);

        String randomName = nameService.getAdjectiveNounPair();

        assertEquals("knotty-custard", randomName);

    }

    @Test
    public void generateAdjectiveNounPairWithNumber() {

        RandomNumber.seed(3941L);

        String randomName = nameService.getAdjectiveNounPair(true);

        assertEquals("gentle-wednesday-7028", randomName);

    }

    @Test
    public void alliterateOnLetter() {

        RandomNumber.seed(87284L);

        String randomName = nameService.alliterateOn("s");

        assertEquals("steep-saw", randomName);

    }

    @Test
    public void alliterateWithNumber() {

        RandomNumber.seed(57333L);

        String randomName = nameService.alliterateOn("s", true);

        assertEquals("spiffy-shoulder-6323", randomName);

    }

    @BeforeClass
    public static void setup() {
        bucket = new TaggedWordBucket();
        nameService = new BucketBackedNameService(bucket);
        noun = bucket.createTag("noun");
        rude = bucket.createTag("rude");
        adjective = bucket.createTag("adjective");
        bucket.visit(new YamlLoadingVisitor("/wordlists/nouns.yaml", noun));
        bucket.visit(new YamlLoadingVisitor("/wordlists/adjectives.yaml", adjective));
        bucket.visit(new YamlLoadingVisitor("/wordlists/rudenouns.yaml", noun, rude));
        bucket.visit(new YamlLoadingVisitor("/wordlists/rudeadjectives.yaml", adjective, rude));
    }


}
