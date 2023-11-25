package Drafts;
import binaryTreePackage.BinaryTree;
import binaryTreePackage.Position;
import java.util.List;

/** A class to implement a program to print an expression from all nodes of the tree in inorder fashion. */
public class ArithmeticExpressionTree {
    /**
     * Main method to implement the program.
     * @param args
     */
    public static void main(String[] args) {
        /** Create a binary tree. */
        BinaryTree<String> tree = new BinaryTree<>();
        /** Add root to the binary tree */
        Position<String> posOfRoot = tree.addRoot("-");
        /** Add other elements according to the expression to be created. */
        Position<String> p1 = tree.addLeft(posOfRoot, "/");
        Position<String> p2 = tree.addRight(posOfRoot, "+");
        Position<String> p3 = tree.addLeft(p1, "*");
        Position<String> p4 = tree.addRight(p1, "+");
        Position<String> p5 = tree.addLeft(p3, "+");
        tree.addRight(p3, "3");
        tree.addLeft(p5, "3");
        tree.addRight(p5, "1");
        Position<String> p6 = tree.addLeft(p4, "-");
        tree.addRight(p4, "2");
        tree.addLeft(p6, "9");
        tree.addRight(p6, "5");
        Position<String> p7 = tree.addLeft(p2, "*");
        tree.addRight(p2, "6");
        tree.addLeft(p7, "3");
        Position<String> p8 = tree.addRight(p7, "-");
        tree.addLeft(p8, "7");
        tree.addRight(p8, "4");
        /** List to store the result from inorder traversal. */
        List<String> result = tree.inorderTraversal();
        /** Builder to build the result string. */
        StringBuilder builder = new StringBuilder();
        /** Traverse the list. */
        for(String item : result) {
            builder.append(item);
        }
        /** Print the final output. */
        System.out.println(builder.toString());
    }
}
