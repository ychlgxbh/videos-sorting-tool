/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ychl
 */
public class YouTubeVideoIndexerTest {
    
    public YouTubeVideoIndexerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of index method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testIndex() {
        System.out.println("index");
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        YouTubeVideo t = new YouTubeVideo("TestChannel", "TestDate", "Test/*@#$%^^Title", "Test    Description", 10, "TestId");
        YouTubeVideo t1 = new YouTubeVideo("TestChannel1", "TestDate1", "TestTitle +-*1", "TestDescription because of 1", 11, "TestId1");
        YouTubeVideo t2 = new YouTubeVideo("TestChannel2", "TestDate2", "TestTitle", "TestDescription2", 12, "TestId2");
        YouTubeVideo t3 = new YouTubeVideo("TestChannel3", "TestDate3", "TestTitle in the 3", "TestDescription 3", 13, "TestId3");
        YouTubeVideo t4 = new YouTubeVideo("TestChannel4", "TestDate4", "TestTitle of 4", "TestDescription4", 14, "TestId4");
        l.add(t);
        l.add(t1);
        l.add(t2);
        l.add(t3);
        l.add(t4);
        YouTubeVideoIndexer instance = new YouTubeVideoIndexer(l);
        // test the list of words with the not meaningful words
        instance.index(false);
        assertTrue(instance.containsWord("in"));
        assertTrue(instance.containsWord("because"));
        assertTrue(instance.containsWord("the"));
        assertTrue(instance.containsWord("of"));
        // test the upper and lower case convertion
        assertTrue(instance.getWordCount("test") == 2);
        assertTrue(!instance.containsWord("Description"));
        // test the elimination of puntuations
        assertTrue(instance.getWordCount("test") == 2);
        assertFalse(instance.containsWord("Test/*@#$%^^Title"));
        
        // test the list of words without the not meaningful words
        instance.index(true);
        assertTrue(!instance.containsWord("in"));
        assertTrue(!instance.containsWord("because"));
        assertTrue(!instance.containsWord("the"));
        assertTrue(!instance.containsWord("of"));
        
    }

    /**
     * Test of getSortedYouTubeWordItems method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testGetSortedYouTubeWordItems() {
        System.out.println("getSortedYouTubeWordItems");
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        YouTubeVideo t = new YouTubeVideo("TestChannel", "TestDate", "Test/*@#$%^^Title", "Test    Description", 10, "TestId");
        YouTubeVideo t1 = new YouTubeVideo("TestChannel", "TestDate", "TestTitle +-*1", "TestDescription because of 1", 11, "TestId1");
        YouTubeVideo t2 = new YouTubeVideo("TestChannel", "TestDate", "TestTitle", "TestDescription2", 12, "TestId2");
        YouTubeVideo t3 = new YouTubeVideo("TestChannel", "TestDate3", "TestTitle in the 3", "TestDescription 3", 13, "TestId3");
        YouTubeVideo t4 = new YouTubeVideo("TestChannel", "TestDate4", "TestTitle of 4", "TestDescription4", 14, "TestId4");
        l.add(t);
        l.add(t1);
        l.add(t2);
        l.add(t3);
        l.add(t4);
        YouTubeVideoIndexer instance = new YouTubeVideoIndexer(l);
        instance.index(false);
        List<YouTubeWordItem> sl = new ArrayList<YouTubeWordItem>();
        sl = instance.getSortedYouTubeWordItems();
        for(int i =0; i< sl.size()-1;i++){
            System.out.println(sl.get(i).getWord() + ": " + sl.get(i).getCount());
           assertTrue( sl.get(i+1).getCount() - sl.get(i).getCount() <= 0);
        }
    }

    /**
     * Test of getWordItem method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testGetWordItem() {
        System.out.println("getWordItem");
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        YouTubeVideo t = new YouTubeVideo("TestChannel", "TestDate", "Test/*@#$%^^Title", "Test    Description", 10, "TestId");
        YouTubeVideo t1 = new YouTubeVideo("TestChannel", "TestDate", "TestTitle +-*1", "TestDescription because of 1", 11, "TestId1");
        YouTubeVideo t2 = new YouTubeVideo("TestChannel", "TestDate", "TestTitle", "TestDescription2", 12, "TestId2");
        YouTubeVideo t3 = new YouTubeVideo("TestChannel", "TestDate3", "TestTitle in the 3", "TestDescription 3", 13, "TestId3");
        YouTubeVideo t4 = new YouTubeVideo("TestChannel", "TestDate4", "TestTitle of 4", "TestDescription4", 14, "TestId4");
        l.add(t);
        l.add(t1);
        l.add(t2);
        l.add(t3);
        l.add(t4);
        YouTubeVideoIndexer instance = new YouTubeVideoIndexer(l);
        instance.index(false);
        assertTrue(instance.getWordItem("test").getCount() == 2);
        assertTrue(instance.getWordItem("testtitle").getCount() == 4);
        assertTrue(instance.getWordItem("the").getCount() == 1);
        assertTrue(instance.getWordItem("description").getCount() == 1);
    }

    /**
     * Test of getWordCount method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testGetWordCount() {
        System.out.println("getWordCount");
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        YouTubeVideo t = new YouTubeVideo("TestChannel", "TestDate", "Test/*@#$%^^Title", "Test    Description", 10, "TestId");
        YouTubeVideo t1 = new YouTubeVideo("TestChannel", "TestDate", "TestTitle +-*1", "TestDescription because of 1", 11, "TestId1");
        YouTubeVideo t2 = new YouTubeVideo("TestChannel", "TestDate", "TestTitle", "TestDescription2", 12, "TestId2");
        YouTubeVideo t3 = new YouTubeVideo("TestChannel", "TestDate3", "TestTitle in the 3", "TestDescription 3", 13, "TestId3");
        YouTubeVideo t4 = new YouTubeVideo("TestChannel", "TestDate4", "TestTitle of 4", "TestDescription4", 14, "TestId4");
        l.add(t);
        l.add(t1);
        l.add(t2);
        l.add(t3);
        l.add(t4);
        YouTubeVideoIndexer instance = new YouTubeVideoIndexer(l);
        instance.index(false);
        assertTrue(instance.getWordCount("1") == 2);
        assertTrue(instance.getWordCount("3") == 2);
        assertTrue(instance.getWordCount("in") == 1);
        assertTrue(instance.getWordCount("title") == 1);
    }

    /**
     * Test of getWordVideos method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testGetWordVideos() {
        System.out.println("getWordVideos");
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        YouTubeVideo t = new YouTubeVideo("TestChannel", "TestDate", "Test/*@#$%^^Title", "Test    Description", 10, "TestId");
        YouTubeVideo t1 = new YouTubeVideo("TestChannel", "TestDate", "TestTitle +-*1", "TestDescription because of 1", 11, "TestId1");
        YouTubeVideo t2 = new YouTubeVideo("TestChannel", "TestDate", "TestTitle", "TestDescription2", 12, "TestId2");
        YouTubeVideo t3 = new YouTubeVideo("TestChannel", "TestDate3", "TestTitle in the 3", "TestDescription 3", 13, "TestId3");
        YouTubeVideo t4 = new YouTubeVideo("TestChannel", "TestDate4", "TestTitle of 4", "TestDescription4", 14, "TestId4");
        l.add(t);
        l.add(t1);
        l.add(t2);
        l.add(t3);
        l.add(t4);
        YouTubeVideoIndexer instance = new YouTubeVideoIndexer(l);
        instance.index(false);
        assertTrue(instance.getWordVideos("1").contains(t1));
        assertTrue(instance.getWordVideos("of").contains(t1));
        assertTrue(instance.getWordVideos("of").contains(t4));
        assertTrue(instance.getWordVideos("testtitle").contains(t1));
        assertTrue(instance.getWordVideos("testtitle").contains(t2));
        assertTrue(instance.getWordVideos("testtitle").contains(t3));
        assertTrue(instance.getWordVideos("testtitle").contains(t4));
        assertTrue(instance.getWordVideos("testdescription4").contains(t4));
        
    }


    /**
     * Test of convertToLowerCase method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testConvertToLowerCase() {
        System.out.println("convertToLowerCase");
        String str = "MAKEITtoLoWerCasE";
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        YouTubeVideoIndexer instance = new YouTubeVideoIndexer(l);
        String expResult = "makeittolowercase";
        String result = instance.convertToLowerCase(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminatePuntuations method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testEliminatePuntuations() {
        System.out.println("eliminatePuntuations");
        String str = "elim+in!a@@#$%^&tep/*untua,.tion[}[]s";
        String str2 = "a!p@p#d&e*v-";
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        YouTubeVideoIndexer instance = new YouTubeVideoIndexer(l);
        String expResult = "elim in a       tep  untua  tion    s";
        String result = instance.eliminatePuntuations(str);
        assertEquals(expResult, result);
        String result2 = instance.eliminatePuntuations(str2);
        String expResult2 = "a p p d e v ";
        assertEquals(result2, expResult2);
    }

    /**
     * Test of addNotMeaningfulWords method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testAddNotMeaningfulWords() {
        System.out.println("addNotMeaningfulWords");
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        YouTubeVideoIndexer instance = new YouTubeVideoIndexer(l);
        assertFalse(instance.notMeaningfulWord.contains("over"));
        assertFalse(instance.notMeaningfulWord.contains("good"));
        assertFalse(instance.notMeaningfulWord.contains("name"));
        assertTrue(instance.notMeaningfulWord.contains("in"));
        assertTrue(instance.notMeaningfulWord.contains("on"));
        assertTrue(instance.notMeaningfulWord.contains("that"));
        instance.addNotMeaningfulWords("over");
        assertTrue(instance.notMeaningfulWord.contains("over"));
    }

    /**
     * Test of containsWord method, of class YouTubeVideoIndexer.
     */
    @Test
    public void testContainsWord() {
        System.out.println("containsWord");
        List<YouTubeVideo> l = new ArrayList<YouTubeVideo>();
        YouTubeVideo t = new YouTubeVideo("TestChannel", "TestDate", "Test/*@#$%^^Title", "Test    Description", 10, "TestId");
        YouTubeVideo t1 = new YouTubeVideo("TestChannel", "TestDate", "TestTitle +-*1", "TestDescription because of 1", 11, "TestId1");
        YouTubeVideo t2 = new YouTubeVideo("TestChannel", "TestDate", "TestTitle", "TestDescription2", 12, "TestId2");
        YouTubeVideo t3 = new YouTubeVideo("TestChannel", "TestDate3", "TestTitle in the 3", "TestDescription 3", 13, "TestId3");
        YouTubeVideo t4 = new YouTubeVideo("TestChannel", "TestDate4", "TestTitle of 4", "TestDescription4", 14, "TestId4");
        l.add(t);
        l.add(t1);
        l.add(t2);
        l.add(t3);
        l.add(t4);
        YouTubeVideoIndexer instance = new YouTubeVideoIndexer(l);
        // not meaningful words are removed
        instance.index(true);
        assertTrue(instance.containsWord("test"));
        assertTrue(instance.containsWord("description"));
        assertTrue(instance.containsWord("testtitle"));
        assertFalse(instance.containsWord("Test/*@#$%^^Title"));
        assertFalse(instance.containsWord("TestTitle +-*1"));
        assertFalse(instance.containsWord("of"));
        assertFalse(instance.containsWord("in"));
        assertFalse(instance.containsWord("the"));
        assertFalse(instance.containsWord("because"));
    }
    
}
