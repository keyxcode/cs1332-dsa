public class TraversalsProgram {
    public static void main(String[] args) { 
        TreeNode<Integer> root = new TreeNode<>(50);

        root.setLeft(new TreeNode<Integer>(25));
        root.getLeft().setLeft(new TreeNode<Integer>(10));

        root.setRight(new TreeNode<Integer>(100));
        root.getRight().setLeft(new TreeNode<Integer>(75));
        root.getRight().setRight(new TreeNode<Integer>(125));
        root.getRight().getRight().setLeft(new TreeNode<Integer>(110));

        Traversals<Integer> traversal = new Traversals<>();
        System.out.println(traversal.preorder(root));
        System.out.println(traversal.inorder(root));
        System.out.println(traversal.postorder(root));
    }
}
