package myTrees;

class EnhancedBinaryNode<T extends Comparable<? super T>> {

    T val;
    EnhancedBinaryNode<T> left;
    EnhancedBinaryNode<T> right;
    EnhancedBinaryNode<T> prev;

    public EnhancedBinaryNode(T value) {
        this(value, null, null, null);
    }

    public EnhancedBinaryNode(T value, EnhancedBinaryNode<T> parent) {
        this(value, parent, null, null);
    }

    public EnhancedBinaryNode(T value, EnhancedBinaryNode<T> parent,
            EnhancedBinaryNode<T> leftChild, EnhancedBinaryNode<T> rightChild) {
        this.val = value;
        this.prev = parent;
        this.left = leftChild;
        this.right = rightChild;
    }
}
