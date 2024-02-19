import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class DictionaryTest {
    // Do not modify this function. All your tests should use newDictionary() to generate the dictionary reference.
    public Dictionary<Integer,String> newDictionary() {
        return new LinkedListDictionary<Integer,String>();
    }
    @Test
    void testSingleInsert(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(1, "one");
        assertEquals("one", dict.find(1));
    }
    @Test
    void testMultiInsert(){
        Dictionary<Integer, String> dict = newDictionary();
        ArrayList<String> numList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
        for(int i = 0; i < 10; i++){
            dict.insert(i+1, numList.get(i));
        }
        for(int i = 0; i < 10; i++){
            assertEquals(numList.get(i), dict.find(i+1), "Cannot find an element: " + (i+1));
        }
    }
    @Test
    void testEmptyFind(){
        Dictionary<Integer,String> dict = newDictionary();
        assertNull(dict.find(3),"Incorrect empty find behavior");
    }
    @Test
    void testSingleFind(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        assertEquals("three",dict.find(3),"Incorrect single element find behavior");
    }
    @Test
    void testFindMany(){
        Dictionary<Integer, String> dict = newDictionary();
        ArrayList<String> numList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
        for(int i = 0; i < 10; i++){
            dict.insert(i+1, numList.get(i));
        }
        assertEquals("one", dict.find(1), "Cannot find an element (1)");
        assertEquals("three", dict.find(3), "Cannot find an element (3)");
        assertEquals("seven", dict.find(7), "Cannot find an element (7)");
        assertEquals("ten", dict.find(10), "Cannot find an element (10)");
        assertNull(dict.find(0), "Should not find an element at key, but found.");
        assertNull(dict.find(11), "Should not find an element at key, but found.");

    }
    @Test
    void testFindAll(){
        Dictionary<Integer, String> dict = newDictionary();
        ArrayList<String> numList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
        for(int i = 0; i < 10; i++){
            dict.insert(i+1, numList.get(i));
        }
        for(int i = 0; i < 10; i++){
            assertEquals(numList.get(i), dict.find(i+1), "Cannot find an element: " + (i+1));
        }
    }
    @Test
    void testEmptyDelete(){
        Dictionary<Integer, String> dict = newDictionary();
        assertFalse(dict.delete(null), "There should not be an element in the dictionary");
    }
    @Test
    void testSingleDelete(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        assertTrue(dict.delete(3));
        assertNull(dict.find(3),"Incorrect single element delete behavior");
    }
    @Test
    void testManyDelete(){
        Dictionary<Integer, String> dict = newDictionary();
        ArrayList<String> numList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
        for(int i = 0; i < 10; i++){
            dict.insert(i+1, numList.get(i));
        }
        assertFalse(dict.delete(0), "There is an unexpected element in your linked list (0)");
        assertTrue(dict.delete(1), "An element is missing in your linked list (1)");
        assertTrue(dict.delete(4),"An element is missing in your linked list (4)");
        assertTrue(dict.delete(8), "An element is missing in your linked list (8)");
        assertFalse(dict.delete(11),"There is an unexpected element in your linked list (11)");
        assertTrue(dict.delete(10), "An element is missing in your linked list (10)");
        assertNull(dict.find(1), "Found a deleted element (1)");
        assertNull(dict.find(4), "Found a deleted element (4)");
        assertNull(dict.find(8), "Found a deleted element (8)");
        assertNull(dict.find(10), "Found a deleted element (10)");
    }
    @Test
    void testAllDelete(){
        Dictionary<Integer, String> dict = newDictionary();
        ArrayList<String> numList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
        for(int i = 0; i < 10; i++){
            dict.insert((i+1), numList.get(i));
        }
        for(int i = 0; i < 10; i++){
            assertTrue(dict.delete((i+1)), "There is an unexpected element in your linked list: " + (i+1));
        }
        for(int i = 0; i < 10; i++){
            assertNull(dict.find((i+1)), "Found a deleted element: " + (i+1));
        }
    }
    @Test
    void testDeleteFromBack(){
        Dictionary<Integer, String> dict = newDictionary();
        ArrayList<String> numList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
        for(int i = 0; i < 10; i++){
            dict.insert((i+1), numList.get(i));
        }
        assertTrue(dict.delete(10), "An element is missing in your linked list (1)");
        assertTrue(dict.delete(9),"An element is missing in your linked list (4)");
        assertTrue(dict.delete(8), "An element is missing in your linked list (8)");
        assertTrue(dict.delete(7), "An element is missing in your linked list (10)");
        assertNull(dict.find(10), "Found a deleted element (10)");
        assertNull(dict.find(7), "Found a deleted element (7)");
        assertNull(dict.find(8), "Found a deleted element (8)");
        assertNull(dict.find(9), "Found a deleted element (9)");

    }
    @Test
    void testDeleteAllFromBack(){
        Dictionary<Integer, String> dict = newDictionary();
        ArrayList<String> numList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
        for(int i = 0; i < 10; i++){
            dict.insert((i+1), numList.get(i));
        }
        for(int i = 9; i >= 0; i--){
            assertTrue(dict.delete((i+1)), "There is an unexpected element in your linked list: " + (i+1));
        }
        for(int i = 0; i < 10; i++){
            assertNull(dict.find((i+1)), "Found a deleted element: " + (i+1));
        }
    }
    @Test
    void testIteratorEmpty(){
        Dictionary<Integer,String> dict = newDictionary();
        Iterator<Integer> iter = dict.iterator();
        assertFalse(iter.hasNext(), "Incorrect null element hasNext Iterator behavior");
    }
    @Test
    void testIteratorSingle(){
        Dictionary<Integer,String> dict = newDictionary();
        dict.insert(3,"three");
        Iterator<Integer> iter = dict.iterator();
        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(3,iter.next(), "Incorrect single element iterator behavior");
        assertFalse(iter.hasNext(), "Incorrect emptied hasNext Iterator behavior");
    }
    @Test
    void testIteratorMany(){
        Dictionary<Integer,String> dict = newDictionary();
        ArrayList<String> numList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
        for(int i = 0; i < 10; i++){
            dict.insert((i+1), numList.get(i));
        }
        Iterator<Integer> iter = dict.iterator();
        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(1,iter.next(), "Incorrect single element iterator behavior");
        assertEquals(2,iter.next(), "Incorrect single element iterator behavior");
        assertEquals(3,iter.next(), "Incorrect single element iterator behavior");
        assertEquals(4,iter.next(), "Incorrect single element iterator behavior");
        assertEquals(5,iter.next(), "Incorrect single element iterator behavior");
        assertEquals(6,iter.next(), "Incorrect single element iterator behavior");
        assertEquals(7,iter.next(), "Incorrect single element iterator behavior");
        assertEquals(8,iter.next(), "Incorrect single element iterator behavior");
        assertEquals(9,iter.next(), "Incorrect single element iterator behavior");
        assertEquals(10,iter.next(), "Incorrect single element iterator behavior");
        assertFalse(iter.hasNext(), "Incorrect emptied hasNext Iterator behavior");
    }
    @Test
    void testSizeNone(){
        Dictionary<Integer, String> dict = newDictionary();
        assertEquals(0, dict.getSize());
    }
    @Test
    void testSizeOne(){
        Dictionary<Integer, String> dict = newDictionary();
        dict.insert(1, "one");
        assertEquals(1, dict.getSize());
    }
    @Test
    void testSizeMany(){
        Dictionary<Integer, String> dict = newDictionary();
        ArrayList<String> numList = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));
        for(int i = 0; i < 10; i++){
            dict.insert(i+1, numList.get(i));
        }
        assertEquals(10, dict.getSize(), "Wrong size should be 10.");
    }
}

