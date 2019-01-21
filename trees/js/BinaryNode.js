/* This source file contains binary nodes, intended to be used by binary search
 * trees. They contain one value of any type and slots to link to left or right
 * nodes. A possible extension includes adding a link to a parent node. */

module.exports = function BinaryNode(value, left, right) {
  this.val = value;
  this.left = left;
  this.right = right;
}
