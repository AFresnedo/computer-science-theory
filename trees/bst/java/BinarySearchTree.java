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
        if (value == null) {
            root = null;
        } else {
            T cleanValue = valueCopier.apply(value);
            root = new BinaryNode<T>(cleanValue);
        }
    }

    /**
     * @param value to insert
     */
    public boolean insert(T value) {
        BinaryNode<T> toAdd = new BinaryNode<T>(valueCopier.apply(value));
        if (root == null) {
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

    // Four cases:
    // 0a) Root is null
    // 0b) Value to remove is not found
    // 1a) Root node, with no children, removed
    // 1b) Leaf node removed
    // 2a) Node removed only had 1 subtree
    // 2b) Sliding node (node replacing empty spot) has only 1 subtree
    // 3) Both removed node and replacing node have 2 children, resulting in
    //    a conflict that forces the removal process to continue down the inner
    //    subtree of the replacing node until a 1 or 2 case is encountered
    /**
     * @param value to remove
     * @return topmost occurance of value or null if not found
     */
    public T remove(T value) {
        return remove(value, root);
    }

    private T remove(T value, BinaryNode<T> current) {
        if (current == null) {
            // Value not in tree
            return null;
        }
        if (value.compareTo(current.val) == 0) {
            T toRet = current.val;
            // Fill in empty slot by pulling values from underneath
            pullValues(current);
            return toRet;
        } else if (value.compareTo(current.val) < 0) {
            return remove(value, current.left);
        } else {
            return remove(value, current.right);
        }
    }

    // Pull values, from right side of the subtree, until exhausted
    private void pullValues(BinaryNode<T> current) {
        BinaryNode<T> next = current.right;
        // Pull values up 1 level
        while (next != null) {
            current.val = next.val;
            current = current.right;
            next = next.right;
        }
        // Replace last right subtree node with left child (may be null)
        current = current.left;
    }

    // Contains value
    // Get value
    // Get all values less or equal to
    // Get all values greater or equal to

    @Override
    public String toString() {
        return "BST toString";
    }

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
