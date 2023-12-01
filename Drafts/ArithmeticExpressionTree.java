package Drafts;

import binaryTreePackage.BinaryTree;
import binaryTreePackage.Position;
import binaryTreePackage.BinaryTree.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/** A class to implement a program to print an expression from all nodes of the tree in inorder fashion. */
public class ArithmeticExpressionTree implements Iterable<String> {

    private BinaryTree<String> tree;

    /** Constructor to initialize the tree. */
    public ArithmeticExpressionTree(BinaryTree<String> tree) {
        this.tree = tree;
    }

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

        /** Create an instance of ArithmeticExpressionTree */
        ArithmeticExpressionTree expressionTree = new ArithmeticExpressionTree(tree);

        /** List to store the result from inorder traversal using iterator. */
        List<String> result = expressionTree.inorderTraversalWithBrackets();

        /** Builder to build the result string. */
        StringBuilder builder = new StringBuilder();

        /** Traverse the list using the iterator. */
        for(String item : result) {
            builder.append(item);
        }

        /** Print the final output. */
        System.out.println(builder.toString());
    }

    /** Iterator for inorder traversal. */
    private class InorderIterator implements Iterator<String> {
        private Stack<Position<String>> stack;

        /** Constructor to initialize the iterator. */
        public InorderIterator() {
            stack = new Stack<>();
            pushLeftMost(tree.root()); // Push leftmost nodes onto stack initially
        }

        /** Helper method to push the leftmost nodes onto the stack. */
        private void pushLeftMost(Position<String> position) {
            while (position != null) {
                stack.push(position);
                position = tree.left(position);
            }
        }

        /** Check if there is a next element in the traversal. */
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** Get the next element in the traversal. */
        @Override
        public String next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("No more elements in the traversal.");
            }

            Position<String> currentPosition = stack.pop();
            pushLeftMost(tree.right(currentPosition)); // Push leftmost nodes of the right subtree

            return currentPosition.getElement();
        }
    }

    /** Provide an iterator for inorder traversal. */
    @Override
    public Iterator<String> iterator() {
        return new InorderIterator();
    }

    /**
     * Perform inorder traversal with brackets and return the result as a list of strings.
     * @return List of strings representing the inorder traversal with brackets.
     */
    private boolean isOperator(String element) {
        return element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/");
    }
    
    /**
     * Performs an inorder traversal of the tree and returns a list of elements.
     *
     * @return List of elements obtained through inorder traversal
     */
    public List<String> inorderTraversalWithBrackets() {
        List<String> result = new ArrayList<>();
        inorderTraversalWithBrackets(tree.root, result);
        return result;
    }

    private void inorderTraversalWithBrackets(Node<String> node, List<String> result) {
        if (node != null) {
            String element = node.getElement();
            boolean isOperator = isOperator(element);
            if (isOperator) {
                result.add("(");
            }
            inorderTraversalWithBrackets(node.getLeft(), result);
            result.add(element);
            inorderTraversalWithBrackets(node.getRight(), result);
            if (isOperator) {
                result.add(")");
            }
        }
    }
}
