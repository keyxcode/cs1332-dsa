public class BSTProgram {    
    public static void main(String[] args) { 
        BST<Integer> myTree = new BST<>();
        myTree.add(4);
        BSTNode<Integer> root = myTree.getRoot();

        System.out.println(myTree);
        System.out.println(root.getLeft());
        System.out.println(root.getRight());

        myTree.add(2);
        myTree.add(5);
        BSTNode<Integer> rootLeft = root.getLeft();
        BSTNode<Integer> rootRight = root.getRight();
        
        System.out.println(myTree);
        System.out.println(rootLeft.getData());
        System.out.println(rootRight.getData());

        myTree.add(5);
        System.out.println(myTree);
    
        myTree.add(6);
        System.out.println(myTree);
        System.out.println(rootRight.getRight().getData());

        myTree.remove(5);
        System.out.println(myTree);
        System.out.println(root.getLeft().getData());
        System.out.println(root.getRight().getData());

        myTree.remove(4);
        System.out.println(myTree);
        System.out.println(root.getLeft().getData());
        System.out.println(root.getRight());
    }
}
