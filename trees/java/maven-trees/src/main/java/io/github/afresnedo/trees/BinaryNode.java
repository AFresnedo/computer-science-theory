package io.github.afresnedo.trees;

// A generic binary node, without a link to its parent, that contains
// comparable data

class BinaryNode<T extends Comparable<? super T>> {

    T val;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T value) {
        this(value, null, null);
    }

    public BinaryNode(T value, BinaryNode<T> leftChild,
            BinaryNode<T> rightChild) {
        this.val = value;
        this.left = leftChild;
        this.right = rightChild;
    }
}
