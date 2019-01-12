package myTrees;
import java.util.LinkedList;

class RudimentaryTester {

    public static void main(String[] args) {
        BinarySearchTree<Integer> testOne =
            new BinarySearchTree<Integer>(x -> x);
        testOne.insert(5);

        System.out.println(testOne);

    // Build test list
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.addLast(35);
    list.addLast(15);
    list.addLast(45);
    list.addLast(5);
    list.addLast(25);
    list.addLast(1);
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.addLast(29);
    list.addLast(32);
    list.addLast(31);
    list.addLast(45);
    list.addLast(50);
    list.addLast(40);

    // Build test tree original state
    BinarySearchTree<Integer> original =
        new BinarySearchTree<Integer>(x -> x);
    original.insertBulk(list);

    }
}
