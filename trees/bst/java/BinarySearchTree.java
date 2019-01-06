package myTrees;

import java.util.function.Function; // For lambda, used in deep copying

class BinarySearchTree<T extends Comparable<? super T>> {

    // TODO private field variables

    // Provided deep copy function, for copying T values
    public final Function<T, T> valueCopier;

    public BinaryNode<T> root;
    public int count;

    public BinarySearchTree(Function<T, T> copier) {
        this(null, copier);
    }

    public BinarySearchTree(T value, Function<T, T> copier) {
        this.valueCopier = copier;
        T cleanValue = valueCopier.apply(value);
        this.root = new BinaryNode<T>(cleanValue);
    }

    // TODO remove after testing
    public T getRootValue() {
        return root.val;
    }

    // Insert value (returns boolean?)
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
