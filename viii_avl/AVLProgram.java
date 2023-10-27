public class AVLProgram {
    public static void main(String[] args) { 
        AVL<Integer> myAVL = new AVL<>();
        myAVL.add(4);
        AVLNode<Integer> root = myAVL.getRoot();

        System.out.println(myAVL);
        System.out.println(root.getLeft());
        System.out.println(root.getRight());

        myAVL.add(2);
        myAVL.add(5);
        AVLNode<Integer> rootLeft = root.getLeft();
        AVLNode<Integer> rootRight = root.getRight();
        
        System.out.println(myAVL);
        System.out.println(rootLeft.getData());
        System.out.println(rootRight.getData());

        myAVL.add(5);
        System.out.println(myAVL);
    
        myAVL.add(6);
        myAVL.add(7);
        System.out.println(myAVL);
        root = myAVL.getRoot();
        System.out.println(root.getLeft().getData());
        System.out.println(root.getRight().getData());
        System.out.println(root.getRight().getLeft().getData());
        System.out.println(root.getRight().getRight().getData());

        myAVL.remove(2);
        System.out.println(myAVL);
        root = myAVL.getRoot();
        System.out.println(root.getLeft().getData());
        System.out.println(root.getLeft().getLeft());
        System.out.println(root.getLeft().getRight().getData());
        System.out.println(root.getRight().getData());
        // System.out.println(root.getRight().getLeft());
        // System.out.println(root.getRight().getRight().getData());

        // myAVL.remove(4);
        // System.out.println(myAVL);
        // System.out.println(root.getLeft().getData());
        // System.out.println(root.getRight());
    }   
}
