package myTrees;

/* Possible design: a node with variable links (a graph node)... data
 * structures could choose what setup they want in a generic fashion (so bst
 * would create a node with 2 links...left and right child)...in that case,
 * links would probably be implemented as (array or linked list? array... when
 * a node is created the links will be fixed and each may have a specific
 * purpose so 0 could either be null or left child, 1 could be null or right
 * child, 2 could be null or parent...etc) */

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
