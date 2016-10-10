package com.github.citizenkahn.sunlight;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Test for Legislator access object
 * Created by pkahn on 10/9/2016.
 */
public class legislatorParseTest extends TestBase {
    @Test
    public void happyPathParseTest() throws IOException {
        File jsonFile = getTestFile("legislator.senate.json");
        Legislator legislator = Legislator.createFromFile(jsonFile);

        assertEquals("Elizabeth", legislator.getFirstName());
        assertTrue(legislator.isInOffice());
    }
}
