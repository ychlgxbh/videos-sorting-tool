/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ychl
 */
public class YouTubeVideoDescriptionComparatorTest {

    public YouTubeVideoDescriptionComparatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of compare method, of class YouTubeVideoDescriptionComparator. Use
     * the file youtubedata_15_50.json
     */
    @Test
    public void testCompare() throws YouTubeDataParserException {
        YouTubeVideoDescriptionComparator instance = new YouTubeVideoDescriptionComparator();
        YouTubeDataParser ytp = new YouTubeDataParser();
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        String fileName = "data/youtubedata_15_50.json";
        l = ytp.parse(fileName);
        l.sort(instance);
        for (int i = 0; i < l.size() - 1; i++) {
            System.out.println(l.get(i).getDescription().length());
            assertTrue(l.get(i + 1).getDescription().length() - l.get(i).getDescription().length() >= 0);
        }
        System.out.println(l.get(l.size() - 1).getDescription().length());
        System.out.println("==================================");
    }

    /**
     * Test of compare method, of class YouTubeVideoDescriptionComparator. Use
     * the file youtubedata_15_50.json
     */
    @Test
    public void testCompare_V2() throws YouTubeDataParserException {
        YouTubeVideoDescriptionComparator instance = new YouTubeVideoDescriptionComparator();
        YouTubeDataParser ytp = new YouTubeDataParser();
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        String fileName = "data/youtubedata_loremipsum.json";
        l = ytp.parse(fileName);
        l.sort(instance);
        for (int i = 0; i < l.size() - 1; i++) {
            System.out.println(l.get(i).getDescription().length());
            assertTrue(l.get(i + 1).getDescription().length() - l.get(i).getDescription().length() >= 0);
        }
        System.out.println(l.get(l.size() - 1).getDescription().length());
        System.out.println("==================================");
    }

}
