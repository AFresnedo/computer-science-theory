package myTrees;

class RudimentaryTester {

    public static void main(String[] args) {
        BinarySearchTree<Integer> testOne =
            new BinarySearchTree<Integer>(x -> x);
        System.out.println("test successful");
        System.out.println("count is: " + testOne.count);
        System.out.println("copier is: " + testOne.valueCopier);


        BinarySearchTree<Integer> testTwo =
            new BinarySearchTree<Integer>(5, x -> x);
        System.out.println("value of root is: " + testTwo.root.val);
    }
}
