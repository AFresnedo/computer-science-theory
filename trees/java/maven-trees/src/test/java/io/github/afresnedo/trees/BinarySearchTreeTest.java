package io.github.afresnedo.trees;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.LinkedList;

/**
 * Unit test for BST.
 */
public class BinarySearchTreeTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BinarySearchTreeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BinarySearchTreeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testBinarySearchTree()
    {

        // Instantiate tree
        BinarySearchTree<Integer> testOne =
            new BinarySearchTree<Integer>(x -> x);

        testOne.insert(35);
        testOne.insert(999);

        // 35 should be in the tree
        assertTrue(testOne.contains(35));
        // 999 should be in the tree
        assertTrue(testOne.contains(999));
        // 1 should not be found
        assertFalse(testOne.contains(1));


        // // Build test list
        // LinkedList<Integer> list = new LinkedList<Integer>();
        // list.addLast(35);
        // list.addLast(15);
        // list.addLast(45);
        // list.addLast(5);
        // list.addLast(25);
        // list.addLast(1);
        // list.addLast(10);
        // list.addLast(20);
        // list.addLast(30);
        // list.addLast(29);
        // list.addLast(32);
        // list.addLast(31);
        // list.addLast(45);
        // list.addLast(50);
        // list.addLast(40);

        // // Build test tree original state
        // BinarySearchTree<Integer> original =
            // new BinarySearchTree<Integer>(x -> x);
        // original.insertBulk(list);

    }
}
