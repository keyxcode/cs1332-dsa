public class BSTProgram {    
    public static void main(String[] args) { 
        BST<Integer> myTree = new BST<>();
        myTree.add(4);

        System.out.println(myTree);
        System.out.println(myTree.getRoot().getLeft());
        System.out.println(myTree.getRoot().getRight());
    }
}
