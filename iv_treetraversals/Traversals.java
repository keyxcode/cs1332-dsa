import java.util.List;
import java.util.ArrayList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    private void preorderHelper(TreeNode<T> root, List<T> nodes) {
        if (root != null) {
            nodes.add(root.getData());
            preorderHelper(root.getLeft(), nodes);
            preorderHelper(root.getRight(), nodes);
        }

        return;
    }

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        ArrayList<T> nodes = new ArrayList<>();
        preorderHelper(root, nodes);
        
        return nodes;
    }

    private void inorderHelper(TreeNode<T> root, List<T> nodes) {
        if (root != null) {
            inorderHelper(root.getLeft(), nodes);
            nodes.add(root.getData());
            inorderHelper(root.getRight(), nodes);
        }

        return;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        ArrayList<T> nodes = new ArrayList<>();
        inorderHelper(root, nodes);
        
        return nodes;
    }

    private void postorderHelper(TreeNode<T> root, List<T> nodes) {
        if (root != null) {
            postorderHelper(root.getLeft(), nodes);
            postorderHelper(root.getRight(), nodes);
            nodes.add(root.getData());
        }

        return;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        ArrayList<T> nodes = new ArrayList<>();
        postorderHelper(root, nodes);
        
        return nodes;
    }
}