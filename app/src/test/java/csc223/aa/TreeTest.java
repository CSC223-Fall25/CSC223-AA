package csc223.aa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeTest {

    private Treeclass tree;

    @BeforeEach
    public void setUp(){
        tree = new Treeclass();
    }

    @Test
    public void testInsert(){
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        
        // Test size after inserting three nodes
        assertEquals(3, tree.size());
    }

    @Test
    public void testLevelOrder(){
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');

        // Level order traversal should be "ABCDE"
        assertEquals("ABCDE", tree.levelorder());
    }

    @Test
    public void testPreorder(){
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');

        // Preorder traversal should be "ABDEC"
        assertEquals("ABDEC", tree.preorder());
    }

    @Test
    public void testInorder(){
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');

        // Inorder traversal should be "DBEAC"
        assertEquals("DBEAC", tree.inorder());
    }

    @Test
    public void testPostorder(){
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');

        // Postorder traversal should be "DEBCA"
        assertEquals("DEBCA", tree.postorder());
    }

    @Test
    public void testSearch(){
        tree.insert('A');
        tree.insert('B');
        tree.insert('C');

        // Test searching for an existing node
        assertTrue(tree.search('B'));
        assertTrue(tree.search('C'));

        // Test searching for a non-existing node
        assertFalse(tree.search('D'));
    }

    @Test
    public void testSize(){
        // Test size for an empty tree
        assertEquals(0, tree.size());

        tree.insert('A');
        tree.insert('B');
        
        // Test size after inserting two nodes
        assertEquals(2, tree.size());
    }

    @Test
    public void testIsEmpty(){
        // Test for an empty tree
        assertTrue(tree.isEmpty());

        tree.insert('A');
        
        // Test for a non-empty tree
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testHeight(){
        tree.insert('A');
        tree.insert('A');
        tree.insert('A');
        tree.insert('A');
        tree.insert('A');

        //       A
        //     /   \
        //    A     A
        //   / \
        //  A   A

        assertEquals(3, tree.height());
    }

    @Test
    public void testEmptyTree(){
        // Test methods on an empty tree
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.height());
    }
}