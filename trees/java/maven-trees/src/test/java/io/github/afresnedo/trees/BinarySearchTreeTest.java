package io.github.afresnedo.trees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import java.util.LinkedList;

@DisplayName("Binary Search Tree Unit Test")
class BinarySearchTreeTest {

    // Randomly generated ints will never be higher than 1000
    final static int RANDOM_INT_CEILING = 1000;
    // Randomly generated ints will never be lower than -100
    final static int RANDOM_INT_FLOOR = -100;

    // Data structures instantiated by BeforeEach and available to all tests
    LinkedList<Integer> listInts;
    BinarySearchTree<Integer> intsTree;
    BinarySearchTree<String> strTree;

    @BeforeEach
    void buildRandomIntegerTree() {
        // Create a list of 20 random integers (100 to 1000) to insert to tree
        listInts = new LinkedList<Integer>();
        Random rand = new Random();
        rand.ints(20, RANDOM_INT_FLOOR, RANDOM_INT_CEILING)
            .forEach(num -> listInts.add(num));
        // Build tree
        intsTree = new BinarySearchTree<Integer>(x -> x);
        intsTree.insertBulk(listInts);
    }

    @BeforeEach
    void buildStandardStringTree() {
        strTree = new BinarySearchTree<String>(x -> x);
    }

    @Test
    @DisplayName("Constructor creates a tree with lambda deep copy")
    // Design decision: uses "contains" method, instead of utilizing reflection
    void testConstructor() {

        // Integer data type
        BinarySearchTree<Integer> ints =
            new BinarySearchTree<Integer>(5, x -> x);
        assertTrue(ints.contains(5));
        assertFalse(ints.contains(1));

        // String data type
        BinarySearchTree<String> strs =
            new BinarySearchTree<String>("hello", x -> x);
        assertTrue(strs.contains("hello"));
        assertFalse(strs.contains("goodbye"));

        // Deep copier that turns all ints given to 0
        BinarySearchTree<Integer> zeroNodes =
            new BinarySearchTree<Integer>(5, x -> 0);
        assertTrue(zeroNodes.contains(0));
        assertFalse(zeroNodes.contains(5));
    }

    @Test
    @DisplayName("Contains returns true iff ele is in tree")
    void testContains() {
        // If int is in list, then it must be in tree
        listInts.forEach(x -> {
            assertTrue(intsTree.contains(x));
        });
        // If int is outside of random number range, it cannot be in the tree
        assertFalse(intsTree.contains(RANDOM_INT_CEILING + 1));
        assertFalse(intsTree.contains(RANDOM_INT_FLOOR - 1));
    }

    @Test
    @DisplayName("Insert adds element to tree in correct position")
    void testInsert() {
    }

    @Test
    @DisplayName("Remove returns correct object and deletes from tree")
    void testRemove() {
    }

    @Test
    @DisplayName("Get returns correct element")
    void testGet() {
    }

    @Test
    @DisplayName("getLessThanOrEqualTo returns correct subgroup")
    void testGetLessThanOrEqualTo() {
    }

}
