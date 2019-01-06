package myTrees;

import java.util.function.Function; // For lambda, used in deep copying

class BinarySearchTree<T extends Comparable<? super T>> {

    private final Function<T, T> valueCopier; // For deep copying values
    private BinaryNode<T> root;
    private int count; // Number of nodes in tree

    public BinarySearchTree(Function<T, T> copier) {
        this(null, copier);
    }

    public BinarySearchTree(T value, Function<T, T> copier) {
        valueCopier = copier;
        T cleanValue = valueCopier.apply(value);
        root = new BinaryNode<T>(cleanValue);
    }

    /**
     * @param value to insert
     */
    public boolean insert(T value) {
        BinaryNode<T> toAdd = new BinaryNode<T>(valueCopier.apply(value));
        if (root.val == null) {
            root = toAdd;
            return true;
        } else {
            return insert(toAdd, root);
        }
    }

    private boolean insert(BinaryNode<T> toAdd, BinaryNode<T> current) {
        // Determine if adding to left or else adding to right subtree
        if (toAdd.val.compareTo(current.val) <= 0) {
            // Determine if adding as child or continuing down left subtree
            if (current.left == null) {
                current.left = toAdd;
                return true;
            } else {
                insert(toAdd, current.left);
            }
        } else {
            // Determine if adding as child or continuing down right subtree
            if (current.right == null) {
                current.right = toAdd;
                return true;
            } else {
                insert(toAdd, current.right);
            }
        }
        return false;
    }
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
            val = value;
            left = leftChild;
            right = rightChild;
        }
    }
}
