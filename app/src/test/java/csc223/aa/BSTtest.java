package csc223.aa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BSTtest {
    
    private  BST testtree;
    @BeforeEach
    public void setup() {
        testtree = new BST();
        testtree.insert(5);
        testtree.insert(4);
        testtree.insert(6);
        testtree.insert(3);
        testtree.insert(7);
        //      5
        //    4   6
        //  3       7
        
    }

    @Test
    public void testInsert(){
        assertEquals(testtree.root.right.right.data, 7);
        assertEquals(testtree.root.right.data, 6);
        assertEquals(testtree.root.data, 5);
        assertEquals(testtree.root.left.data, 4);
        assertEquals(testtree.root.left.left.data, 3);

    }
    
    @Test
    public void testdelete(){
        //del leaf node
        testtree.delete(7);
        //del single child node
        testtree.delete(4);
        //del root node
        testtree.delete(5);
        
    }

    @Test
    public void testsearch(){
        assertTrue(testtree.search(5));
        assertTrue(testtree.search(4));
        assertTrue(testtree.search(6));
        assertTrue(testtree.search(3));
        assertTrue(testtree.search(7));
        assertFalse(testtree.search(0));
        
    }

    @Test
    public void testUpdate() {
        testtree.update(4, 8);
        assertFalse(testtree.search(4));  // Old value should be gone
        assertTrue(testtree.search(8));   // New value should be present

        testtree.update(100, 50);  // Value not in BST, should do nothing
        assertFalse(testtree.search(50));
    }

    @Test
    public void testInOrder() {
        assertEquals("3 4 5 6 7", testtree.inOrder());

        testtree.insert(2);
        assertEquals("2 3 4 5 6 7", testtree.inOrder());

        testtree.delete(5);
        assertEquals("2 3 4 6 7", testtree.inOrder());
    }

    @Test
    public void testSortedArrayToBST() {
        int[] values = {1, 2, 3, 4, 5, 6, 7};
        BSTNode root = testtree.sortedArrayToBST(values);

        assertNotNull(root);
        assertEquals(4, root.data); // Middle element should be root
        assertEquals(2, root.left.data);
        assertEquals(6, root.right.data);
        assertEquals(1, root.left.left.data);
        assertEquals(3, root.left.right.data);
        assertEquals(5, root.right.left.data);
        assertEquals(7, root.right.right.data);
    }
    
}
