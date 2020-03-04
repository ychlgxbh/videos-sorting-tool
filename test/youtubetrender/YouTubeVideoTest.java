/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ychl
 */
public class YouTubeVideoTest {

    YouTubeVideo y = new YouTubeVideo("TestChannel", "TestDate", "TestTitle", "TestDescription", 10, "TestId");

    public YouTubeVideoTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getChannel method, of class YouTubeVideo.
     */
    @Test
    public void testGetChannel() {
        System.out.println("getChannel");
        String expResult = "TestChannel";
        String result = y.getChannel();
        assertTrue(result.compareTo(expResult) == 0);

    }

    /**
     * Test of setChannel method, of class YouTubeVideo.
     */
    @Test
    public void testSetChannel() {
        System.out.println("setChannel");
        y.setChannel("ModifiedChannel");
        String expResult = "ModifiedChannel";
        String result = y.getChannel();
        assertTrue(result.compareTo(expResult) == 0);
        assertFalse(result.compareTo("TestChannel") == 0);
    }

    /**
     * Test of getDate method, of class YouTubeVideo.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        String expResult = "TestDate";
        String result = y.getDate();
        assertTrue(result.compareTo(expResult) == 0);
    }

    /**
     * Test of setDate method, of class YouTubeVideo.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        y.setDate("ModifiedDate");
        String expResult = "ModifiedDate";
        String result = y.getDate();
        assertTrue(result.compareTo(expResult) == 0);
        assertFalse(result.compareTo("TestDate") == 0);
    }

    /**
     * Test of getTitle method, of class YouTubeVideo.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "TestTitle";
        String result = y.getTitle();
        assertTrue(result.compareTo(expResult) == 0);
    }

    /**
     * Test of setTitle method, of class YouTubeVideo.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        y.setTitle("ModifiedTitle");
        String expResult = "ModifiedTitle";
        String result = y.getTitle();
        assertTrue(result.compareTo(expResult) == 0);
        assertFalse(result.compareTo("TestTitle") == 0);
    }

    /**
     * Test of getDescription method, of class YouTubeVideo.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "TestDescription";
        String result = y.getDescription();
        assertTrue(result.compareTo(expResult) == 0);
    }

    /**
     * Test of setDescription method, of class YouTubeVideo.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        y.setDescription("ModifiedDescription");
        String expResult = "ModifiedDescription";
        String result = y.getDescription();
        assertTrue(result.compareTo(expResult) == 0);
        assertFalse(result.compareTo("TestDescription") == 0);
    }

    /**
     * Test of getViewCount method, of class YouTubeVideo.
     */
    @Test
    public void testGetViewCount() {
        System.out.println("getViewCount");
        int expResult = 10;
        int result = y.getViewCount();
        assertTrue(result == expResult);
    }

    /**
     * Test of setViewCount method, of class YouTubeVideo.
     */
    @Test
    public void testSetViewCount() {
        System.out.println("setViewCount");
        y.setViewCount(20);
        int expResult = 20;
        int result = y.getViewCount();
        assertTrue(result == expResult);
        assertFalse(result == 10);
    }

    /**
     * Test of getID method, of class YouTubeVideo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String expResult = "TestId";
        String result = y.getId();
        assertTrue(result.compareTo(expResult) == 0);
    }
    
    /**
     * Test of setDate method, of class YouTubeVideo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        y.setId("ModifiedId");
        String expResult = "ModifiedId";
        String result = y.getId();
        assertTrue(result.compareTo(expResult) == 0);
        assertFalse(result.compareTo("TestDate") == 0);
    }
    

    /**
     * Test of toString method, of class YouTubeVideo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "TestChannel: TestTitle";
        String result = y.getChannel() + ": " + y.getTitle();
        assertTrue(result.compareTo(expResult) == 0);
    }
    
    /**
     * Test of toString method, of class YouTubeVideo. 
     */
    @Test
    public void testToString_V2() {
        System.out.println("toString_V2");
        YouTubeVideo y = new YouTubeVideo("", "TestDate", "TestTitle", "TestDescription", 10, "TestId");
        String expResult = ": TestTitle";
        String result = y.getChannel() + ": " + y.getTitle();
        assertTrue(result.compareTo(expResult) == 0);
    }

        @Test
    public void testToString_V3() {
        System.out.println("toString_V3");
        YouTubeVideo y = new YouTubeVideo("TestChannel", "TestDate", "", "TestDescription", 10, "TestId");
        String expResult = "TestChannel: ";
        String result = y.getChannel() + ": " + y.getTitle();
        assertTrue(result.compareTo(expResult) == 0);
    }
}
