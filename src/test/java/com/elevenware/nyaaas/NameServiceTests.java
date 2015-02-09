package com.elevenware.nyaaas;

import com.elevenware.nyaaas.util.RandomNumber;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameServiceTests {

    @Test
    public void generateAdjectiveNounPair() {

        RandomNumber.seed(2034L);

        NameService nameService = new SimpleNameService();
        String randomName = nameService.getAdjectiveNounPair();

        assertEquals("knotty-custard", randomName);

    }

    @Test
    public void generateAdjectiveNounPairWithNumber() {

        RandomNumber.seed(3941L);

        NameService nameService = new SimpleNameService();
        String randomName = nameService.getAdjectiveNounPair(true);

        assertEquals("gentle-wednesday-7028", randomName);

    }

    @Test
    public void alliterateOnLetter() {

      RandomNumber.seed(87284L);

       NameService nameService = new SimpleNameService();
       String randomName = nameService.alliterateOn("s");

       assertEquals("steep-saw", randomName);

    }

    @Test
    public void alliterateWithNumber() {

        RandomNumber.seed(57333L);

        NameService nameService = new SimpleNameService();
        String randomName = nameService.alliterateOn("s", true);

        assertEquals("spiffy-shoulder-6323", randomName);

    }

}
