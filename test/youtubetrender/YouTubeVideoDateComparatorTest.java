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
public class YouTubeVideoDateComparatorTest {
    
    public YouTubeVideoDateComparatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of compare method, of class YouTubeVideoDateComparator.
     * Use the file youtubedata_15_50.json
     */
    @Test
    public void testCompare() throws YouTubeDataParserException {
        YouTubeVideoDateComparator instance = new YouTubeVideoDateComparator();
        YouTubeDataParser ytp = new YouTubeDataParser();
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        String fileName = "data/youtubedata_15_50.json";
        l = ytp.parse(fileName);
        l.sort(instance);
        for(int i = 0; i < l.size()-1; i++){
            System.out.println(l.get(i).getDate());
            assertTrue((l.get(i+1).getDate().toLowerCase().compareTo(l.get(i).getDate().toLowerCase())) >= 0);
        }
        System.out.println(l.get(l.size()-1).getDate());
        System.out.println("==================================");
    }
    
        /**
     * Test of compare method, of class YouTubeVideoDateComparator.
     * Use the file youtubedata_15_50.json
     */
    @Test
    public void testCompare_V2() throws YouTubeDataParserException {
        YouTubeVideoDateComparator instance = new YouTubeVideoDateComparator();
        YouTubeDataParser ytp = new YouTubeDataParser();
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        String fileName = "data/youtubedata_loremipsum.json";
        l = ytp.parse(fileName);
        l.sort(instance);
        for(int i = 0; i < l.size()-1; i++){
            System.out.println(l.get(i).getDate());
            assertTrue((l.get(i+1).getDate().toLowerCase().compareTo(l.get(i).getDate().toLowerCase())) >= 0);
        }
        System.out.println(l.get(l.size()-1).getDate());
        System.out.println("==================================");
    }
    
}
