package com.elevenware.nyaaas;

import org.junit.Test;
import static org.junit.Assert.*;

public class NameServiceTests {

    @Test
    public void generateAdjectiveNounPair() {

        System.setProperty("random.seed", "3823");

        NameService nameService = new SimpleNameService();
        String randomName = nameService.getAdjectiveNounPair();

        assertEquals("xylophagic-honey", randomName);

    }

}
