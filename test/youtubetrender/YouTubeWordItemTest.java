/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youtubetrender;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
public class YouTubeWordItemTest {

    public YouTubeWordItemTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of add method, of class YouTubeWordItem.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        YouTubeVideo t = new YouTubeVideo("TestChannel", "TestDate", "TestTitle", "TestDescription", 10, "TestId");
        YouTubeWordItem instance = new YouTubeWordItem("test");
        instance.add(t);
        assertTrue(instance.getVideos().size() == 1);
        assertFalse(instance.getVideos().isEmpty());
        assertTrue(instance.getVideos().contains(t));
    }

    /**
     * Test of getCount method, of class YouTubeWordItem.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        // Check the defaul value of count
        YouTubeWordItem instance = new YouTubeWordItem("test");
        int expResult = 0;
        int result = instance.getCount();
        assertEquals(expResult, result);

        //Check count after adding 4 YouTubeVideo objects
        YouTubeVideo t = new YouTubeVideo("TestChannel", "TestDate", "TestTitle", "TestDescription", 10, "TestId");
        YouTubeVideo t1 = new YouTubeVideo("TestChannel1", "TestDate1", "TestTitle1", "TestDescription1", 11, "TestId1");
        YouTubeVideo t2 = new YouTubeVideo("TestChannel2", "TestDate2", "TestTitle2", "TestDescription2", 12, "TestId2");
        YouTubeVideo t3 = new YouTubeVideo("TestChannel3", "TestDate3", "TestTitle3", "TestDescription3", 13, "TestId3");
        YouTubeVideo t4 = new YouTubeVideo("TestChannel4", "TestDate4", "TestTitle4", "TestDescription4", 14, "TestId4");
        instance.add(t1);
        instance.add(t2);
        instance.add(t3);
        instance.add(t4);
        expResult = 4;
        result = instance.getCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVideos method, of class YouTubeWordItem.
     */
    @Test
    public void testGetVideos() {
        //Check default size of the list of videos
        System.out.println("getVideos");
        YouTubeWordItem instance = new YouTubeWordItem("test");
        Set<YouTubeVideo> result = instance.getVideos();
        assertTrue(result.size() == 0);

        //Check the size of the list after adding 3 video objects
        YouTubeVideo t1 = new YouTubeVideo("TestChannel1", "TestDate1", "TestTitle1", "TestDescription1", 11, "TestId1");
        YouTubeVideo t2 = new YouTubeVideo("TestChannel2", "TestDate2", "TestTitle2", "TestDescription2", 12, "TestId2");
        YouTubeVideo t3 = new YouTubeVideo("TestChannel3", "TestDate3", "TestTitle3", "TestDescription3", 13, "TestId3");
        instance.add(t1);
        instance.add(t2);
        instance.add(t3);
        assertTrue(result.size() == 3);
        assertTrue(result.contains(t1));
        assertTrue(result.contains(t2));
        assertTrue(result.contains(t3));
    }

    /**
     * Test of getWord method, of class YouTubeWordItem.
     */
    @Test
    public void testGetWord() {
        System.out.println("getWord");
        String expResult = "test";
        YouTubeWordItem instance = new YouTubeWordItem(expResult);
        String result = instance.getWord();
        assertTrue(result.compareTo(expResult) == 0);

    }

    /**
     * Test of toString method, of class YouTubeWordItem.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        YouTubeWordItem instance = new YouTubeWordItem("test");
        // Test an object without adding videos
        assertTrue(instance.toString().compareTo("test[0]") == 0);

        YouTubeVideo t1 = new YouTubeVideo("TestChannel1", "TestDate1", "TestTitle1", "TestDescription1", 11, "TestId1");
        YouTubeVideo t2 = new YouTubeVideo("TestChannel2", "TestDate2", "TestTitle2", "TestDescription2", 12, "TestId2");
        YouTubeVideo t3 = new YouTubeVideo("TestChannel3", "TestDate3", "TestTitle3", "TestDescription3", 13, "TestId3");
        instance.add(t1);
        instance.add(t2);
        instance.add(t3);
        // Test an object after adding 3 videos
        System.out.println("====");
        System.out.println(instance.toString());
        assertTrue(instance.toString().compareTo("test[3]") == 0);
    }

    /**
     * Test of compareTo method, of class YouTubeWordItem.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        YouTubeWordItem instance1 = new YouTubeWordItem("test1");
        YouTubeWordItem instance2 = new YouTubeWordItem("test2");
        YouTubeWordItem instance3 = new YouTubeWordItem("test3");
        YouTubeWordItem instance4 = new YouTubeWordItem("test4");
        YouTubeVideo t1 = new YouTubeVideo("TestChannel1", "TestDate1", "TestTitle1", "TestDescription1", 11, "TestId1");
        YouTubeVideo t2 = new YouTubeVideo("TestChannel2", "TestDate2", "TestTitle2", "TestDescription2", 12, "TestId2");
        YouTubeVideo t3 = new YouTubeVideo("TestChannel3", "TestDate3", "TestTitle3", "TestDescription3", 13, "TestId3");
        YouTubeVideo t4 = new YouTubeVideo("TestChannel4", "TestDate4", "TestTitle4", "TestDescription4", 14, "TestId4");
        // Four words with different count
        instance1.add(t4);
        instance1.add(t2);
        instance2.add(t1);
        instance3.add(t1);
        instance3.add(t3);
        instance3.add(t4);
        List<YouTubeWordItem> l = new ArrayList<YouTubeWordItem>();
        l.add(instance1);
        l.add(instance2);
        l.add(instance3);
        l.add(instance4);
        Collections.sort(l);
        for (int i = 0; i < 3; i++) {
            System.out.println(l.get(i));
            assertTrue((l.get(i + 1).getCount() - l.get(i).getCount()) <= 0);
        }
        System.out.println(l.get(3));
        // Four words ,two of them have the same count
        YouTubeWordItem instance5 = new YouTubeWordItem("test5");
        YouTubeWordItem instance6 = new YouTubeWordItem("test6");
        YouTubeWordItem instance7 = new YouTubeWordItem("test7");
        YouTubeWordItem instance8 = new YouTubeWordItem("test8");
        instance5.add(t1);
        instance6.add(t3);
        instance6.add(t4);
        instance7.add(t1);
        instance7.add(t2);
        instance8.add(t4);
        instance8.add(t3);
        instance8.add(t2);
        instance8.add(t1);
        l.clear();
        l.add(instance8);
        l.add(instance6);
        l.add(instance7);
        l.add(instance5);
        for (int i = 0; i < 3; i++) {
            System.out.println(l.get(i));
            assertTrue((l.get(i + 1).getCount() - l.get(i).getCount()) <= 0);
        }
        System.out.println(l.get(3));
    }

}
