package Drafts;

import java.util.Scanner;

/**
 * Generic Tree Node class
 *
 * @param <T> Type of data stored in the node
 */
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

/**
 * Example of Arithmetic Expression Tree
 */
public class Trial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the root node data: ");
        String rootData = scanner.next();
        TreeNode<String> root = new TreeNode<>(rootData);

        buildTreeFromUserInput(root, scanner);

        // Print the arithmetic expression tree
        System.out.println("Arithmetic Expression Tree:");
        printExpressionTree(root);

        // Display the arithmetic expression tree structure
        System.out.println("\n************************************************************");
        System.out.println("Displaying Tree:");
        displayTree(root);
        System.out.println("************************************************************");

        scanner.close();
    }

    private static void buildTreeFromUserInput(TreeNode<String> parent, Scanner scanner) {
        System.out.print("Enter data for left child of node '" + parent.data + "' (press 'n' for no child): ");
        String leftData = scanner.next();
        if (!leftData.equals("n")) {
            parent.left = new TreeNode<>(leftData);
            buildTreeFromUserInput(parent.left, scanner);
        }

        System.out.print("Enter data for right child of node '" + parent.data + "' (press 'n' for no child): ");
        String rightData = scanner.next();
        if (!rightData.equals("n")) {
            parent.right = new TreeNode<>(rightData);
            buildTreeFromUserInput(parent.right, scanner);
        }
    }

    private static void printExpressionTree(TreeNode<String> root) {
        if (root != null) {
            if (root.left != null || root.right != null) {
                System.out.print("(");
            }

            printExpressionTree(root.left);
            System.out.print(root.data);
            printExpressionTree(root.right);

            if (root.left != null || root.right != null) {
                System.out.print(")");
            }
        }
    }

    private static void displayTree(TreeNode<String> root) {
        displayTreeHelper(root, "", false);
    }

    /**
     * Recursively displays the tree structure in a human-readable format.
     *
     * @param node   The current node in the tree.
     * @param prefix The prefix for indentation.
     * @param isLeft A boolean indicating if the current node is the left child.
     */
    private static void displayTreeHelper(TreeNode<String> node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);

            if (node.left != null || node.right != null) {
                displayTreeHelper(node.left, prefix + (isLeft ? "│   " : "    "), true);
                displayTreeHelper(node.right, prefix + (isLeft ? "│   " : "    "), false);
            }
        }
    }
}