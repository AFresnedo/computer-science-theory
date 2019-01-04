package myTrees;

class BinaryNode<T extends Comparable<? super T>> {

    T val;
    BinaryNode<T> left;
    BinaryNode<T> right;
    BinaryNode<T> prev;

    public BinaryNode(T value) {
        this(value, null, null, null);
    }

    public BinaryNode(T value, BinaryNode<T> parent) {
        this(value, parent, null, null);
    }

    public BinaryNode(T value, BinaryNode<T> parent,
            BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
        this.val = value;
        this.prev = parent;
        this.left = leftChild;
        this.right = rightChild;
    }
}
