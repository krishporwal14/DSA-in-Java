package Drafts;
import treePackage.ConcreteTree;
import treePackage.TreeNode;
import java.util.Scanner;

/**
 * A program using a tree to display the tree and add the numbering and indentation with each depth.
 */
public class TableOfContents {
    public static ConcreteTree<String> tree;

    /**
     * Builds a string with a directory to the root of the tree from a particular node using its depth.
     * @param node Tree Node
     * @return  Directory of depth in the form of string
     */
    private static String depthString(TreeNode<String> node) {
        StringBuilder builder = new StringBuilder();
        if(node.parent.parent != null) {        
            builder.append((node.parent.parent.children.indexOf(node.parent) + 1) + ".");
            builder.append(node.parent.children.indexOf(node) + 1);
            node = node.parent;
        }
        else {
            builder.append(node.parent.children.indexOf(node) + 1);
        }
        return builder.toString();
    }

    /**
     * Displays the tree in the described manner
     * @param node  the starting node for display
     * @param level the current level of indentation
     */
    private static void displayTree(TreeNode<String> node, int level) {
        if(tree.isRoot(node)) {
            System.out.println(" ".repeat(level) + node.data);
        }
        else {
            System.out.println(" ".repeat(level) + depthString(node) + " " + node.data);
        }
        for(TreeNode<String> child : node.children) {
            displayTree(child, level + 1);
        }
    }

    /**
     * Main method for the program.
     * @param args
     */
    public static void main(String args[]) {
        // tree = new ConcreteTree<String>("Electronics R'Us");
        // tree.addChild(tree.root, "R&D");
        // tree.addChild(tree.root, "Sales");
        // tree.addChild(tree.root, "Purchasing");
        // tree.addChild(tree.root, "Manufacturing");
        // tree.addChild(tree.findNode(tree.root, "Sales"), "Domestic");
        // tree.addChild(tree.findNode(tree.root, "Sales"), "International");
        // tree.addChild(tree.findNode(tree.root, "International"), "Canada");
        // tree.addChild(tree.findNode(tree.root, "International"), "S. America");
        // tree.addChild(tree.findNode(tree.root, "International"), "Overseas");
        // tree.addChild(tree.findNode(tree.root, "Overseas"), "Africa");
        // tree.addChild(tree.findNode(tree.root, "Overseas"), "Europe");
        // tree.addChild(tree.findNode(tree.root, "Overseas"), "Asia");
        // tree.addChild(tree.findNode(tree.root, "Overseas"), "Australia");
        // tree.addChild(tree.findNode(tree.root, "Manufacturing"), "TV");
        // tree.addChild(tree.findNode(tree.root, "Manufacturing"), "CD");
        // tree.addChild(tree.findNode(tree.root, "Manufacturing"), "Tuner");
        Scanner scan = new Scanner(System.in);
        String choice = "y", menu_choice;
        System.out.println("**********************Create Tree*********************");
        try {
            System.out.println("Enter root of the tree: ");
            String root_data = scan.nextLine();
            tree = new ConcreteTree<String>(root_data);
        }
        catch(Exception e) {
            System.out.println("Enter correct value: ");
            String root_data = scan.nextLine();
            tree = new ConcreteTree<String>(root_data);
        }
        System.out.println("Tree created.");
        System.out.println("******************************************************");
        do {
            System.out.println("*************************Menu*************************");
            System.out.println("1. Add child node");
            System.out.println("2. Display tree");
            System.out.println("******************************************************");
            System.out.println("Enter your choice: ");
            menu_choice = scan.nextLine();
            switch(menu_choice) {
                case "1":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter parent node value: ");
                        String parentValue = scan.nextLine();
                        System.out.println("Enter child node value: ");
                        String childValue = scan.nextLine();
                        tree.addChild(tree.findNode(tree.root, parentValue), childValue);
                    }
                    catch(Exception e) {
                        System.out.println("Enter correct value: ");
                        System.out.println("Enter parent node value: ");
                        String parentValue = scan.nextLine();
                        System.out.println("Enter child node value: ");
                        String childValue = scan.nextLine();
                        tree.addChild(tree.findNode(tree.root, parentValue), childValue);
                    }
                    System.out.println("******************************************************");
                    break;
                case "2":
                    System.out.println("******************************************************");
                    displayTree(tree.root, 0);
                    System.out.println("******************************************************");
                    break;
                default:
                    System.out.println("******************************************************");
                    System.out.println("Wrong choice!!");
                    System.out.println("******************************************************");                    
                    break;
                }
                System.out.println("Do you want to continue(Y/N)?: ");
            choice = scan.nextLine();
        }while(choice.equals("y") || choice.equals("Y") || choice.equals("Yes") || choice.equals("yes"));
        System.out.println("Thank You!!");
        scan.close();
    }
}
