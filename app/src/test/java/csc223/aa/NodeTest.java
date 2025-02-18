package csc223.aa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NodeTest {

    
    private SinglyLinkedList testlist1;

    @BeforeEach
    public void setup() {
        this.testlist1 = new SinglyLinkedList();
        testlist1.insert('A');
        testlist1.insert('B');
        testlist1.insert('C');
    }

    @Test
    public void testInsert() {

        assertEquals('A', testlist1.head.next.data);         
        assertEquals('B', testlist1.head.next.next.data);   
        assertEquals('C', testlist1.head.next.next.next.data); 
    }

        
}
