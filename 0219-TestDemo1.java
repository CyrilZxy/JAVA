public class TestDemo1 {
    public static void main(String[] args) {
        TestBinaryTree testBinaryTree=new TestBinaryTree();
        testBinaryTree.insert(19);
        testBinaryTree.insert(9);
        testBinaryTree.insert(3);
        testBinaryTree.insert(10);
        testBinaryTree.insert(14);
        testBinaryTree.insert(24);

        testBinaryTree.inorder(testBinaryTree.root);
        System.out.println( );
        testBinaryTree.preorder(testBinaryTree.root);


        testBinaryTree.remove(10);
        System.out.println( );
        testBinaryTree.inorder(testBinaryTree.root);

    }
}
