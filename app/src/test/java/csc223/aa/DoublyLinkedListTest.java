package csc223.aa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {
    
    private DoublyLinkedList testlist;

    @BeforeEach
    public void setup() {
        testlist = new DoublyLinkedList();
    }

    @Test
    public void testInsert() {
        this.testlist.insert('A');
        this.testlist.insert('B');
        this.testlist.insert('C');

        assertEquals('A', this.testlist.head.next.data);        
        assertEquals('B', this.testlist.head.next.next.data);   
        assertEquals('C', this.testlist.head.next.next.next.data); 

        assertEquals(3, this.testlist.size()); 
    }

    @Test
    public void testRemove() {
        this.testlist.insert('A');
        this.testlist.insert('B');
        this.testlist.insert('C');

        this.testlist.remove('C'); 
        assertEquals(2, this.testlist.size()); 

        
        assertEquals('A', this.testlist.head.next.data); 
        assertEquals('B', this.testlist.head.next.next.data); 
    }

    @Test
    public void testgetfirst(){
        this.testlist.insert('A');
        
        assertEquals('A', this.testlist.getFirst()); 
    }

    @Test
    public void testgetlast(){
        this.testlist.insert('A');
        this.testlist.insert('B');
        this.testlist.insert('C');
        assertEquals('C', this.testlist.getLast()); 
    }

    @Test
    public void testget(){
        this.testlist.insert('A');
        this.testlist.insert('B');
        this.testlist.insert('C');

        assertEquals('A', this.testlist.get(1)); 
        assertEquals('B', this.testlist.get(2)); 
        assertEquals('C', this.testlist.get(3)); 
    }

    @Test
    public void testisempty(){
        this.testclear();
        assertTrue(this.testlist.isEmpty());
        this.testlist.insert('A');
        assertFalse(this.testlist.isEmpty());
    }

    @Test
    public void testclear(){
        
        this.testlist.insert('A');
        assertFalse(this.testlist.isEmpty());
        this.testlist.clear();
        assertTrue(this.testlist.isEmpty());
        assertEquals(0, this.testlist.size()); 
    }

    @Test
    public void testcontains(){
        this.testlist.insert('A');
        this.testlist.insert('B');
        this.testlist.insert('C');

        assertTrue(this.testlist.contains('C'));
        assertTrue(this.testlist.contains('B'));
        assertTrue(this.testlist.contains('A'));
    }

    @Test
    public void testindexof(){
        this.testlist.insert('A');
        this.testlist.insert('B');
        this.testlist.insert('C');

        assertEquals(2, this.testlist.indexOf('C')); 
        assertEquals(1, this.testlist.indexOf('B')); 
        assertEquals(0, this.testlist.indexOf('A')); 
    }

    @Test
    public void testlastindexof(){
        this.testlist.insert('A');
        this.testlist.insert('B');
        this.testlist.insert('A');
        this.testlist.insert('B');
        
        assertEquals(2, this.testlist.lastIndexOf('A')); 
        assertEquals(3, this.testlist.lastIndexOf('B')); 
    }

    @Test
    public void testReverseMultipleNodes(){
        testlist.insert('A');
        testlist.insert('B');
        testlist.insert('C');
        assertEquals("A -> B -> C", testlist.toString());
       
        testlist.reverse();
        
        assertEquals("C -> B -> A", testlist.toString());  
        assertEquals('C', testlist.head.next.data);  
        assertEquals('B', testlist.head.next.next.data);  
        assertEquals('A', testlist.head.next.next.next.data); 
         
    }

    @Test
    public void testToString() {

        testlist.insert('A');
        testlist.insert('B');
        testlist.insert('C');
    
        assertEquals("A -> B -> C", testlist.toString());  
    }
    

}