/* This source file contains a generic implementation of
 * a non-balancing binary search tree. It features encapsulation, using
 * closures to hide data and invoked anonymous functions to return objects in
 * the constructor. */

// Import BinaryNode(val, left, right)
const BinaryNode = require('./BinaryNode.js');

// Constructor
function RobustBinarySearchTree() {
  // NOTE If beginning with a value is desired, must call insert from here
  // another way of saying this: do not accept a node as a root (client has
  // pointer to it)
  this.root = null;
  this.count = 0;
  // data type so that it can enforce typeof? i like this idea
}

// Creates and adds a node with the given value
// Pre: value matches type of other node values
// Post: creates a node with the value and inserts it in a valid spot
RobustBinarySearchTree.prototype.insert();

// Returns and removes a node with given value
RobustBinarySearchTree.prototype.remove();

// True/False based on if the BST contains a node with the value
RobustBinarySearchTree.prototype.contains();

// Returns every node between given range of values (no range returns all)
RobustBinarySearchTree.prototype.getAll();
