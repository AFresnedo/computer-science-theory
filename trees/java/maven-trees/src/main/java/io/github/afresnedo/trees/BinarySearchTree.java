package io.github.afresnedo.trees;

import io.github.afresnedo.trees.BinaryNode; // For element in this container
import java.util.function.Function; // For lambda, used in deep copying
import java.util.LinkedList;

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

    public boolean contains(T value) {
        if (find(value, root) == null) {
            return false;
        }
        return true;
    }

    public T get(T value) {
        return find(value, root);
    }

    // Returns all values less than or equal to parameter
    public LinkedList<T> getLessThanOrEqualTo(T value) {
        LinkedList<T> list = new LinkedList<T>();
        BinaryNode<T> start = root;
        // Find first occurance of a value less than or equal to value
        while (start != null && value.compareTo(start.val) > 0) {
            start = start.left;
        }
        if (start == null) {
            // No values in tree are less than or equal to arguement
            return null;
        }
        // Add all values in tree <= value to list
        inOrder(list, start);
        return list;
    }

    // Returns all values greater than or equal to parameter
    public LinkedList<T> getGreaterThanOrEqualTo(T value) {
        LinkedList<T> list = new LinkedList<T>();
        BinaryNode<T> start = root;
        // Find first occurance of a value less than or equal to value
        while (start != null && value.compareTo(start.val) < 0) {
            start = start.right;
        }
        if (start == null) {
            // No values in tree are less than or equal to arguement
            return null;
        }
        // Add all values in tree >= value to list
        inOrder(list, start);
        return list;
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

    public void insertBulk(LinkedList<T> values) {
        for (int i = 0; i < values.size(); i++) {
            insert(values.get(i));
        }
    }

    /**
     * @param value to remove
     * @return topmost occurance of value (or null, if not found)
     */
    public T remove(T value) {
        return remove(value, root);
    }

    private T find(T value, BinaryNode<T> current) {
        if (current == null) {
            // Value not in tree
            return null;
        }
        if (value.compareTo(current.val) == 0) {
            return current.val;
        } else if (value.compareTo(current.val) < 0) {
            return find(value, current.left);
        } else {
            return find(value, current.right);
        }
    }

    // TODO redesign, this is mutating arguement...could be better
    // Pre: node passed is not null
    // Returns list of values from an inorder traversal
    private void inOrder(LinkedList<T> list,
            BinaryNode<T> current) throws NullPointerException {
        if (current == null) {
            throw new NullPointerException("cannot call inorder on null node");
        }
        if (current.left != null) {
            // Traverse left subtree for values less than current
            inOrder(list, current.left);
        }
        list.addLast(current.val);
        if (current.right != null) {
            // Traverse right subtree for values greater than current
            inOrder(list, current.right);
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

    @Override
    public String toString() {
        return "BST toString";
    }
}
