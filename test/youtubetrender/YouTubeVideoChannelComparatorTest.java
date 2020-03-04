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
public class YouTubeVideoChannelComparatorTest {
    
    public YouTubeVideoChannelComparatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of compare method, of class YouTubeVideoChannelComparator.
     * Use the file youtubedata_15_50.json
     */
    @Test
    public void testCompare() throws YouTubeDataParserException {
        YouTubeVideoChannelComparator instance = new YouTubeVideoChannelComparator();
        YouTubeDataParser ytp = new YouTubeDataParser();
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        String fileName = "data/youtubedata_15_50.json";
        l = ytp.parse(fileName);
        l.sort(instance);
        for(int i = 0; i < l.size()-1; i++){
            System.out.println(l.get(i).getChannel());
            assertTrue((l.get(i+1).getChannel().toLowerCase().compareTo(l.get(i).getChannel().toLowerCase())) >= 0);
        }
        System.out.println(l.get(l.size()-1).getChannel());
        System.out.println("==================================");
    }
    
        /**
     * Test of compare method, of class YouTubeVideoChannelComparator.
     * Use the file youtubedata_15_50.json
     */
    @Test
    public void testCompare_V2() throws YouTubeDataParserException {
        YouTubeVideoChannelComparator instance = new YouTubeVideoChannelComparator();
        YouTubeDataParser ytp = new YouTubeDataParser();
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        String fileName = "data/youtubedata_loremipsum.json";
        l = ytp.parse(fileName);
        l.sort(instance);
        for(int i = 0; i < l.size()-1; i++){
            System.out.println(l.get(i).getChannel());
            assertTrue((l.get(i+1).getChannel().toLowerCase().compareTo(l.get(i).getChannel().toLowerCase())) >= 0);
        }
        System.out.println(l.get(l.size()-1).getChannel());
        System.out.println("==================================");
    }
    
}
