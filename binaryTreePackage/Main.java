package binaryTreePackage;

import java.util.Scanner;

/** A program to implement and test all binary tree operations. */
public class Main {
    /**
     * Main method of the program.
     * @param args
     */
    public static void main(String args[]) {
        BinaryTree<String> tree = new BinaryTree<>();
        Scanner scan = new Scanner(System.in);
        String choice = "y", menu_choice;
        String nodeVal;
        do {
            System.out.println("*************************Menu*************************");
            System.out.println("1. Create root node");
            System.out.println("2. Add left child node");
            System.out.println("3. Add right child node");
            System.out.println("4. Size of the tree");
            System.out.println("5. Is empty");
            System.out.println("6. Replace element of a node");
            System.out.println("7. Remove a node");
            System.out.println("8. Display tree");
            System.out.println("******************************************************");
            System.out.println("Enter your choice: ");
            menu_choice = scan.nextLine();
            switch(menu_choice) {
                case "1":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter root node value: ");
                        nodeVal = scan.nextLine();
                        tree.addRoot(nodeVal);
                    }
                    catch (Exception e) {
                        System.out.println("Enter correct root node value: ");
                        nodeVal = scan.nextLine();
                        tree.addRoot(nodeVal);
                    }
                    System.out.println("******************************************************");
                    break;
                case "2":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter parent node value: ");
                        String parent = scan.nextLine();
                        System.out.println("Enter new node value: ");
                        nodeVal = scan.nextLine();
                        tree.addLeft(tree.findPosition(tree, tree.root, parent), nodeVal);
                    }
                    catch (Exception e) {
                        System.out.println(e);
                        System.out.println("Try again!!");
                        System.out.println("Enter parent node value: ");
                        String parent = scan.nextLine();
                        System.out.println("Enter new node value: ");
                        nodeVal = scan.nextLine();
                        tree.addLeft(tree.findPosition(tree, tree.root, parent), nodeVal);
                    }
                    System.out.println("******************************************************");
                    break;
                case "3":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter parent node value: ");
                        String parent = scan.nextLine();
                        System.out.println("Enter new node value: ");
                        nodeVal = scan.nextLine();
                        tree.addRight(tree.findPosition(tree, tree.root, parent), nodeVal);
                    }
                    catch (Exception e) {
                        System.out.println(e);
                        System.out.println("Try again!!");
                        System.out.println("Enter parent node value: ");
                        String parent = scan.nextLine();
                        System.out.println("Enter new node value: ");
                        nodeVal = scan.nextLine();
                        tree.addRight(tree.findPosition(tree, tree.root, parent), nodeVal);
                    }
                    System.out.println("******************************************************");
                    break;
                case "4":
                    System.out.println("******************************************************");
                    System.out.println("Size of the tree is: " + tree.size());
                    System.out.println("******************************************************");
                    break;
                case "5":
                    System.out.println("******************************************************");
                    if(tree.isEmpty()) {
                        System.out.println("Tree is empty.");
                    }
                    else {
                        System.out.println("Tree is not empty.");
                    }
                    System.out.println("******************************************************");
                    break;
                case "6":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter the value you want to replace: ");
                        String oldValue = scan.nextLine();
                        System.out.println("Enter the new value: ");
                        String newValue = scan.nextLine();
                        String result = tree.set(tree.findPosition(tree, tree.root, oldValue), newValue);
                        System.out.println(result + " replaced.");
                    }
                    catch(Exception e) {
                        System.out.println(e);
                        System.out.println("Try again!!");
                        System.out.println("Enter the value you want to replace: ");
                        String oldValue = scan.nextLine();
                        System.out.println("Enter the new value: ");
                        String newValue = scan.nextLine();
                        String result = tree.set(tree.findPosition(tree, tree.root, oldValue), newValue);
                        System.out.println(result + " replaced.");
                    }
                    System.out.println("******************************************************");
                    break;
                case "7":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter the node you want to remove: ");
                        String removeValue = scan.nextLine();
                        String result = tree.remove(tree.findPosition(tree, tree.root, removeValue));
                        System.out.println(result + " removed.");
                    }
                    catch(Exception e) {
                        System.out.println(e);
                        System.out.println("Try again!!");
                        System.out.println("Enter the node you want to remove: ");
                        String removeValue = scan.nextLine();
                        String result = tree.remove(tree.findPosition(tree, tree.root, removeValue));
                        System.out.println(result + " removed.");
                    }
                    System.out.println("******************************************************");
                    break;
                case "8":
                    System.out.println("******************************************************");
                    tree.displayTree();
                    System.out.println("******************************************************");
                    break;
                default:
                    System.out.println("******************************************************");
                    System.out.println("Wrong choice!");
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
