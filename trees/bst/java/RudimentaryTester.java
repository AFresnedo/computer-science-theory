package myTrees;

class RudimentaryTester {

    public static void main(String[] args) {
        BinarySearchTree<Integer> testOne =
            new BinarySearchTree<Integer>(x -> x);
        testOne.insert(5);

        System.out.println(testOne);
    }
}
