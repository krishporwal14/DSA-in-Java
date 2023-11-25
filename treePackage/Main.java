package treePackage;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/**
 * This class implements and tests all the Tree operations.
 */
public class Main {
    /**
     * Main function of the program.
     * @param args
     */
    public static void main(String args[]) {
        ConcreteTree<String> tree;
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
            System.out.println("3. Find siblings of a node");
            System.out.println("4. List leaves of the tree");
            System.out.println("5. List internal nodes of the tree");
            System.out.println("6. List edges of the tree");
            System.out.println("7. Find path for a given node");
            System.out.println("8. Calculate depth of a node");
            System.out.println("9. Calculate height of the tree");
            System.out.println("10. Get subtree rooted at a given node");
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
                    tree.displayTree(tree.root, 0);
                    System.out.println("******************************************************");
                    break;
                case "3":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter tree node value: ");
                        String nodeValue = scan.nextLine();
                        System.out.println("Siblings are: " + tree.findSiblings(tree.findNode(tree.root, nodeValue)));   
                    }
                    catch(Exception e) {
                        System.out.println("Node not found.");
                    }
                    System.out.println("******************************************************");
                    break;
                case "4":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter tree node value: ");
                        String nodeValue0 = scan.nextLine();
                        System.out.println("Leaves are: " + tree.listLeaves(tree.findNode(tree.root, nodeValue0)));
                    }
                    catch(Exception e) {
                        System.out.println("Node not found.");
                    }
                    System.out.println("******************************************************");
                    break;
                case "5":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter tree node value: ");
                        String nodeValue1 = scan.nextLine();
                        System.out.println("Internal nodes are: " + tree.listInternalNodes(tree.findNode(tree.root, nodeValue1)));
                    }
                    catch(Exception e) {
                        System.out.println("Node not found.");
                    }
                    System.out.println("******************************************************");
                    break;
                case "6":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter tree node value: ");
                        String nodeValue2 = scan.nextLine();
                        System.out.println("Edges are: " + tree.listEdges(tree.findNode(tree.root, nodeValue2)));   
                    }
                    catch(Exception e) {
                        System.out.println("Node not found.");
                    }
                    System.out.println("******************************************************");
                    break;
                case "7":
                    System.out.println("******************************************************");
                    try {
                        List<String> path = new ArrayList<>();
                        System.out.println("Enter tree node value: ");
                        String nodeValue3 = scan.nextLine();
                        System.out.println("Path is: " + tree.pathForNode(tree.root, nodeValue3, path));                        
                    }
                    catch(Exception e) {
                        System.out.println("Node not found.");
                    }
                    System.out.println("******************************************************");
                    break;
                case "8":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter tree node value: ");
                        String nodeValue4 = scan.nextLine();
                        System.out.println("Depth is: " + tree.depthOfNode(tree.findNode(tree.root, nodeValue4)));   
                    }
                    catch(Exception e) {
                        System.out.println("Node not found.");
                    }
                    System.out.println("******************************************************");
                    break;
                case "9":
                    System.out.println("******************************************************");
                    System.out.println("Height of the tree is: " + tree.heightOfTree(tree.root));
                    System.out.println("******************************************************");
                    break;
                case "10":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter tree node value: ");
                        String nodeValue5 = scan.nextLine();
                        ConcreteTree<String> subTree = tree.subtreeAtNode(tree.findNode(tree.root,   nodeValue5));
                        subTree.displayTree(subTree.root, 0);   
                    }
                    catch(Exception e) {
                        System.out.println("Node not found.");
                    }
                    System.out.println("******************************************************");
                    break;
                default:
                    System.out.println("******************************************************");
                    System.out.println("Wrong Choice!!");
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
