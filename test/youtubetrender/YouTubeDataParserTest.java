/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author trent
 */
public class YouTubeDataParserTest {
    
    public YouTubeDataParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of parse method, of class YouTubeDataParser.
     * Check the the total number of YouTubeVideo objects and variables in it(Id, Channel, Title, Date, Description, ViewCount)
     */
    @Test
    public void testParse() throws Exception {
        System.out.println("parse youtubedata");
        String fileName = "data/youtubedata.json";
        YouTubeDataParser instance = new YouTubeDataParser();
        int expNumberOfVideo = 1;
        String expId = "UCehf4850q1L3ng7s7L54ATA";
        String expChannel = "Joe Bloggs";
        String expTitle = "This should have a really useful title";
        String expDate = "2016-04-20T23:15:17.000Z";
        String expDescription ="This should have a really useful description.  However lots of youtubers put links and other promotional material.";
        int expViewCount=14180950;
        List<YouTubeVideo> result = instance.parse(fileName);
        assertTrue(result.size() == expNumberOfVideo);
        assertTrue(result.get(0).getId().compareTo(expId) == 0);
        assertTrue(result.get(0).getChannel().compareTo(expChannel) == 0);
        assertTrue(result.get(0).getTitle().compareTo(expTitle) == 0);
        assertTrue(result.get(0).getDate().compareTo(expDate) == 0);
        assertTrue(result.get(0).getDescription().compareTo(expDescription) == 0);
        assertTrue(result.get(0).getViewCount()==expViewCount);
    }
   
        /**
     * Test of parse method, of class YouTubeDataParser.
     * Check the the total number of YouTubeVideo objects 
     * Check the Id of the first object, Channel of the 10th object, Title of the 20th object,
     * Date of the 30th object, Description of the 40th object, ViewCount of the 50th object
     */
    @Test
    public void testParse_V2() throws Exception {
        System.out.println("parse youtubedata_15_50");
        String fileName = "data/youtubedata_15_50.json";
        YouTubeDataParser instance = new YouTubeDataParser();
        int expNumberOfVideo = 50;
        String expId = "UCehf4850q1L3ng7s7L54ATA";
        String expChannel = "Kids Show Lyrics";
        String expTitle = "06 19 15   Hummingbird Tormenting Rex";
        String expDate = "2016-04-23T19:00:01.000Z";
        String expDescription ="No holds barred and hard-hitting talk to trash-talking senator.";
        int expViewCount=66523;
        List<YouTubeVideo> result = instance.parse(fileName);
        assertTrue(result.size() == expNumberOfVideo);
        assertTrue(result.get(0).getId().compareTo(expId) == 0);
        assertTrue(result.get(9).getChannel().compareTo(expChannel) == 0);
        assertTrue(result.get(19).getTitle().compareTo(expTitle) == 0);
        assertTrue(result.get(29).getDate().compareTo(expDate) == 0);
        assertTrue(result.get(39).getDescription().compareTo(expDescription) == 0);
        assertTrue(result.get(49).getViewCount()==expViewCount);
        
    }
}
