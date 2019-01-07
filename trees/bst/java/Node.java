package myTrees;

class Node<T extends Comparable<? super T>> {

    T val;
    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this(value, null, null);
    }

    public Node(T value, Node<T> leftChild,
            Node<T> rightChild) {
        this.val = value;
        this.left = leftChild;
        this.right = rightChild;
    }
}
