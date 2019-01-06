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

    // TODO link issue, ordering issue, parent/child link issue, with removals
    // it doesn't seem like parents are updating their child links if their
    // child is removed

    /**
     * @param value to remove
     * @return topmost occurance of value or null if not found
     */
    public T remove(T value) {
        if (root.val == null) {
            return null;
        }
        if (root.val == value) {
            T toRet = root.val;
            root = replaceWith(root);
            return toRet;
        }
        // Value is not root, deteremine if searching left or right subtree
        return null;
    }

    private T remove(T value, BinaryNode<T> current) {
        if (current.val == value) {
            T toRet = current.val;
            current = replaceWith(current);
            return toRet;
        }
        return null;
    }

    // TODO judge merits of design (not necessarily the root null part)
    private BinaryNode<T> replaceWith(BinaryNode<T> toDel) {
        if (toDel.left != null) {
            return toDel.left;
        }
        if (toDel.right != null) {
            return toDel.right;
        }
        // Root cannot be null, can be a node with a null value
        return new BinaryNode<T>(null);
    }

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
