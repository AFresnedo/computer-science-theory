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

  // TODO Privaleged methods (to implement encapsulation)
}

// Creates and adds a node with the given value
// Pre: value matches type of other node values
// Post: creates a node with the value and inserts it in a valid spot
RobustBinarySearchTree.prototype.insert(val) {
  // If root is null, insert as root
  // Else if <= val of root and left child is null, make & insert as left
  // Else if <= val of root, call insert on left child
  // Else if > val of root and right child is null, make & insert as right
  // Else if > val of root, call insert on right child
}

// Returns and removes a node with given value
RobustBinarySearchTree.prototype.remove(val) {
}

// True/False based on if the BST contains a node with the value
RobustBinarySearchTree.prototype.contains(val) {
  // TODO move the iterative code into privaleged method
  // If currentNode is null, return false
  // Else if currentNode.val === val, return true
  // Else if currentNode.val >= val, call contains(val) on left child
  // Else if currentNode.val < val, call contains(val on right child
}

// Returns every value in tree less than val, including duplicates
RobustBinarySearchTree.prototype.getLessThan() {
}

// Returns every value in tree greater than val, including duplicates
RobustBinarySearchTree.prototype.getGreaterThan() {
}

// Returns every value in tree, including duplicates
RobustBinarySearchTree.prototype.getAll() {
}
