package Drafts;

import binaryTreePackage.BinaryTree;
import binaryTreePackage.Position;
import binaryTreePackage.BinaryTree.Node;

/**
 * A class to display a binary tree with lines for better visualization.
 */
public class DisplayTree {

    /**
     * Display the tree with lines.
     *
     * @param node     The current node in the tree.
     * @param prefix   The prefix for indentation.
     * @param isLeft   A flag indicating whether the current node is a left child.
     */
    private static void displayTree(Node<Integer> node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getElement());

            displayTree(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
            displayTree(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    /**
     * Main method to demonstrate displaying a binary tree.
     *
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String args[]) {
        // Create a binary tree
        BinaryTree<Integer> tree = new BinaryTree<>();

        // Add nodes to the tree
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> p1 = tree.addLeft(root, 2);
        tree.addRight(root, 3);
        tree.addLeft(p1, 4);
        tree.addRight(p1, 5);

        // Display the tree
        displayTree((Node<Integer>) root, "", false);
    }
}
