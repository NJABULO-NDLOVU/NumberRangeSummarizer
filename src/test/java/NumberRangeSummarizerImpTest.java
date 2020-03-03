/* 
    Java – primary language for coding
    VS Code – IDE for coding
    Maven – dependency management tool and also to generate reports for our test cases.
    JUnit 4.12 – testing framework
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import numberrangesummarizer.NumberRangeSummarizerImpl;

@RunWith(JUnit4.class)
public class NumberRangeSummarizerImpTest {

    NumberRangeSummarizerImpl numSummerizer;

    @Before
    public void setUp() {
        numSummerizer = new NumberRangeSummarizerImpl();
    }

    @After
    public void tearDown() {
        numSummerizer = null;
    }

    @Test
    public void testCollectEmptyString(){

        // if input is empty string return
        Collection<Integer> expected = null;
        Collection<Integer> actual = numSummerizer.collect("");

        assertEquals(expected,actual);

    }

    @Test
    public void testCollectSpecialChars(){

        // Testing for illegal characters
        Collection<Integer> expected = null;
        Collection<Integer> actual = numSummerizer.collect("1,3&,12");

        assertEquals(expected,actual);

    }

    @Test
    public void testCollectLetters(){

        // Testing for illegal characters
        Collection<Integer> expected = null;
        Collection<Integer> actual = numSummerizer.collect("1,3,l,12");

        assertEquals(expected,actual);

    }

    @Test
    public void testCollectLettersandSpecialChars(){

        // Testing for illegal characters
        Collection<Integer> expected = null;
        Collection<Integer> actual = numSummerizer.collect("1,3,l,12,@");

        assertEquals(expected,actual);

    }

    @Test
    public void testCollectCommaDelimitedInteger(){

        // return sorted Arraylist
        Integer[] numArray = {1,6,7,8,12,13,14,15};
        Collection<Integer> expected = new ArrayList<Integer>();

        Collections.addAll(expected, numArray);
        Collection<Integer> actual = numSummerizer.collect("1,7,12,15,6,8,13,14");

        assertEquals(expected,actual);

    }

    @Test
    public void testSummarizeCollectionNullInput(){

        // Assuming the collect method failed(return a null) should return Error
        Collection<Integer> input = null;
        String expected = "Error";
        String actual = numSummerizer.summarizeCollection(input);

        assertEquals(expected,actual);

    }


    @Test
    public void testSummarizeCollectionSampleInput(){

        // Test with sample case
        Integer[] numArray = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        Collection<Integer> input = new ArrayList<Integer>();
        Collections.addAll(input, numArray);

        String actual = numSummerizer.summarizeCollection(input);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";

        assertEquals(expected,actual);
    }
  
}