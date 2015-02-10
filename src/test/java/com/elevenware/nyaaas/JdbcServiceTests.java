package com.elevenware.nyaaas;

import com.elevenware.nyaaas.database.JdbcService;
import org.junit.Test;

public class JdbcServiceTests {

    @Test
    public void saveWord() {

        JdbcService service = new JdbcService("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");

    }

}
