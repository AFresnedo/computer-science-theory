/* This source file contains binary nodes, intended to be used by binary search
 * trees. They contain one value of any type and slots to link to left or right
 * nodes. In addition, they contain links to their parents. */

module.exports = function FullyLinkedBinaryNode(value, parent, left, right) {
  this.val = value;
  this.prev = parent;
  this.left = left;
  this.right = right;
}
