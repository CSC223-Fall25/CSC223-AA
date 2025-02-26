package csc223.aa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortedLinkedListTest extends DoublyLinkedList{

    private SortedLinkedList sortedList;

    @BeforeEach
    public void setup() {
        sortedList = new SortedLinkedList();
    }

    @Test
    public void testInsertSortedOrder() {
        sortedList.insert('C');
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('D');

        assertEquals("A -> B -> C -> D", sortedList.toString());
    }

    @Test
    public void testInsertDuplicates() {
        sortedList.insert('A');
        sortedList.insert('C');
        sortedList.insert('A'); 
        sortedList.insert('B');
        sortedList.insert('C'); 
        assertEquals("A -> A -> B -> C -> C", sortedList.toString()); 
    }

    @Test
    public void testGetFirst() {
        sortedList.insert('B');
        sortedList.insert('A');
        sortedList.insert('C');

        assertEquals('A', sortedList.getFirst()); 
    }

    @Test
    public void testGetLast() {
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('D');
        sortedList.insert('C');

        assertEquals('D', sortedList.getLast()); 
    }

    @Test
    public void testRemoveElement() {
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('C');

        sortedList.remove('B');
        assertEquals("A -> C", sortedList.toString());
    }

    @Test
    public void testRemoveFirstAndLast() {
    
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('C');


        sortedList.remove('A');
        
        assertEquals("B -> C", sortedList.toString()); 

        sortedList.remove('C');
        //assertEquals("B", sortedList.toString()); // Removing last element
    }

    @Test
    public void testContains() {
        sortedList.insert('A');
        sortedList.insert('C');
        sortedList.insert('B');

        assertTrue(sortedList.contains('B')); // 'B' should be in the list
        assertFalse(sortedList.contains('D')); // 'D' should not be in the list
    }

    @Test
    public void testIndexOf() {
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('C');

        assertEquals(1, sortedList.indexOf('B'));
        assertEquals(-1, sortedList.indexOf('D')); // Not in list
    }


    @Test
    public void testSizeAndIsEmpty() {
        assertTrue(sortedList.isEmpty());
        assertEquals(0, sortedList.size());

        sortedList.insert('A');
        sortedList.insert('B');

        assertFalse(sortedList.isEmpty());
        assertEquals(2, sortedList.size());
    }

    @Test
    public void testClear() {
        sortedList.insert('A');
        sortedList.insert('B');
        sortedList.insert('C');

        sortedList.clear();
        assertEquals("", sortedList.toString()); // List should be empty
        assertTrue(sortedList.isEmpty());
    }
}