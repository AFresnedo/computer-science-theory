/* This source file contains a generic implementation of
 * a non-balance-enforcing binary search tree. It features encapsulation, using
 * closures to hide data and invoked anonymous functions to return objects in
 * the constructor. */

// Constructor for BinaryNode
function BinaryNode(value, left, right) {
  this.val = value;
  this.left = left;
  this.right = right;
}
