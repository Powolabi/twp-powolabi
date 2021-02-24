package edu.bsu.cs22;

import edu.bsu.cs222.WikiParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.InputStream;

public class WikiParserTest {
    @Test
    public void editorParseTest() throws IOException {
        WikiParser parser = new WikiParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("wikiTestData");
        String username = parser.editorParser(testDataStream).get(0).toString();
        Assertions.assertEquals("Valereee", username);
        System.out.println(username);
    }
    @Test
    public void TimestampParserTest() throws IOException {
        WikiParser parser = new WikiParser();
        InputStream testTimestampStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("WikiTestData");
        String timestamp = WikiParser.timeStampParser(testTimestampStream).get(0).toString();
        Assertions.assertEquals("2021-02-08T18:12:21Z", timestamp);
        System.out.println(timestamp);

        }
    @Test
    public void redirectParserTest() throws IOException {
        WikiParser parser = new WikiParser();
        InputStream testredirectStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("WikiTestData");
        String redirect = parser.redirectParser(testredirectStream).get(0).toString();
        Assertions.assertEquals("WikiTestData", redirect);
        System.out.println(redirect);
    }
}



