/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.json.Json;
import javax.json.JsonReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ychl
 */
public class YouTubeDataParserExceptionTest {

    JsonReader jsonReader = null;

    public YouTubeDataParserExceptionTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test the YouTubeDataParserException Invalid fileName
     *
     */
    @Test
    public void testExceptions() {
        System.out.println("Test invalid fileName");
        YouTubeDataParser ytp = new YouTubeDataParser();
        String fileName = "NoSuchFile";
        try {
            ytp.parse(fileName);
            fail("the test should throw a YouTubeDataParserException");
        } catch (YouTubeDataParserException y) {
            assertTrue(y.getMessage().compareTo("File not found: "+fileName) ==0);
        }
    }
/**
     * Test the YouTubeDataParserException 
     * Valid fileName with incorrect path
     *
     */
    @Test
    public void testExceptions_V2() {
        System.out.println("Test valid fileName with incorrect path");
        YouTubeDataParser ytp = new YouTubeDataParser();
        String fileName = "beta/youtubedata.json";
        try {
            ytp.parse(fileName);
            fail("the test should throw a YouTubeDataParserException");
        } catch (YouTubeDataParserException y) {
            assertTrue(y.getMessage().compareTo("File not found: "+fileName) ==0);
        }
    }
    /**
     * Test the YouTubeDataParserException malformed file
     */
    @Test
    public void testExceptions_V3() {
        System.out.println("Test malformed file");
        YouTubeDataParser ytp = new YouTubeDataParser();
        String fileName = "data/youtubedata_malformed.json";
        try {
            ytp.parse(fileName);
            fail("the test should throw a YouTubeDataParserException");
        } catch (YouTubeDataParserException y) {
            assertTrue(y.getMessage().compareTo("Parsing exception: Invalid token=COLON at (line no=15, column no=18, offset=394). Expected tokens are: [COMMA]") == 0);
        }
    }

}
