package myTrees;

class BinarySearchTree<T extends Comparable<? super T>> {

    // Provided deep copy function
    private final Function<T, T> valueCopier;

    BinaryNode<T> root;
    int count;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(T value) {
        this.root = new BinaryNode<T>(value);
    }

    // Insert value
    // Remove value (returns value)
    // Contains value
    // Get value
    // Get all values less or equal to
    // Get all values greater or equal to

    private class BinaryNode<T extends Comparable<? super T>> {

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
}