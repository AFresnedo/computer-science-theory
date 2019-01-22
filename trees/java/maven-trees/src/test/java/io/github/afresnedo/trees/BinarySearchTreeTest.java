package io.github.afresnedo.trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Binary Search Tree Unit Test")
class BinarySearchTreeTest {

    @Test
    @DisplayName("Constructor creates a tree with lambda deep copy")
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

        // Deep copier that turns everything into null
        BinarySearchTree<Integer> zeroNodes =
            new BinarySearchTree<Integer>(5, x -> 0);
        assertTrue(zeroNodes.contains(0));
        assertFalse(zeroNodes.contains(5));
    }

    @Test
    @DisplayName("Contains returns true iff ele is in tree")
    void testContains() {
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
