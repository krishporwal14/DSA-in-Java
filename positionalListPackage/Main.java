package positionalListPackage;

import java.util.Scanner;

/**
 * @author Krish Porwal
 * @since 28-10-2023
 * @version 1.0.0
 */
/**
 * Class to test all the operations of the Positional Doubly Linked List.
 */
public class Main {
    
    /**
     * Main Method to implement all operations of Positional Doubly Linked List.
     * @param args
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String choice = "y", menu_choice;
        int data, beforeElement, afterElement, aElement, bElement, be, ae, replaceElement, setElement, removeElement;
        PositionalLinkedList<Integer> list = new PositionalLinkedList<>();
        do {
            System.out.println("********************Menu********************");
            System.out.println("1. Size");
            System.out.println("2. Is Empty");
            System.out.println("3. First");
            System.out.println("4. Last");
            System.out.println("5. Before");
            System.out.println("6. After");
            System.out.println("7. Add First");
            System.out.println("8. Add Last");
            System.out.println("9. Add Before");
            System.out.println("10. Add After");
            System.out.println("11. Set");
            System.out.println("12. Remove");
            System.out.println("13. Display");
            System.out.println("********************************************");
            System.out.println("Enter your choice: ");
            menu_choice = scan.nextLine();
            switch(menu_choice) {
                case "1":
                    System.out.println("********************************************");
                    System.out.println("Size of the List is: " + list.size());
                    System.out.println("********************************************");
                    break;
                case "2":
                    System.out.println("********************************************");
                    if(list.isEmpty()) {
                        System.out.println("List is Empty.");
                    }
                    else {
                        System.out.println("List is not empty.");
                    }
                    System.out.println("********************************************");
                    break;
                case "3":
                    System.out.println("********************************************");
                    System.out.println("The first position of the list is: " + list.first());
                    System.out.println("********************************************");
                    break;
                case "4":
                    System.out.println("********************************************");
                    System.out.println("The last position of the list is: " + list.last());
                    System.out.println("********************************************");
                    break;
                case "5":
                    System.out.println("********************************************");
                    try {
                        System.out.println("Enter a element in the list: ");
                        beforeElement = Integer.parseInt(scan.nextLine());
                    }
                    catch(Exception e) {
                        System.out.println("Enter a element in the list: ");
                        beforeElement = Integer.parseInt(scan.nextLine());
                    }
                    if(list.findPosition(list, beforeElement) != null) {
                        System.out.println("Position before element is: " + list.before((Position<Integer>) list.findPosition(list, beforeElement)));
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "6":
                    System.out.println("********************************************");
                    try {
                        System.out.println("Enter a element in the list: ");
                        afterElement = Integer.parseInt(scan.nextLine());
                    }
                    catch(Exception e) {
                        System.out.println("Enter a element in the list: ");
                        afterElement = Integer.parseInt(scan.nextLine());
                    }
                    if(list.findPosition(list, afterElement) != null) {
                        System.out.println("Position after element is: " + list.after((Position<Integer>) list.findPosition(list, afterElement)));
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "7":
                    System.out.println("********************************************");
                    try {
                        System.out.println("Enter the element to insert: ");
                        data = Integer.parseInt(scan.nextLine());
                    }
                    catch(Exception e) {
                        System.out.println("Enter the element to insert: ");
                        data = Integer.parseInt(scan.nextLine());
                    }
                    System.out.println(data + " inserted in " + list.addFirst(data) + " position.");
                    System.out.println("********************************************");
                    break;
                case "8":
                    System.out.println("********************************************");
                    try {
                        System.out.println("Enter the element to insert: ");
                        data = Integer.parseInt(scan.nextLine());
                    }
                    catch(Exception e) {
                        System.out.println("Enter the element to inser: ");
                        data = Integer.parseInt(scan.nextLine());
                    }
                    System.out.println(data + " inserted in " + list.addLast(data) + " position.");
                    System.out.println("********************************************");
                    break;
                case "9":
                    System.out.println("********************************************");
                    try {
                        System.out.println("Enter the element in the list: ");
                        bElement = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter the element to insert: ");
                        be = Integer.parseInt(scan.nextLine());
                    }
                    catch(Exception e) {
                        System.out.println("Enter the element in the list: ");
                        bElement = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter the element to insert: ");
                        be = Integer.parseInt(scan.nextLine());
                    }
                    if(list.findPosition(list, bElement) != null) {
                        list.addBefore((Position<Integer>) list.findPosition(list, bElement), be);
                        System.out.println(be + " inserted");
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "10":
                    System.out.println("********************************************");
                    try {
                        System.out.println("Enter the element in the list: ");
                        aElement = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter the element to insert: ");
                        ae = Integer.parseInt(scan.nextLine());
                    }
                    catch(Exception e) {
                        System.out.println("Enter the element in the list: ");
                        aElement = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter the element to insert: ");
                        ae = Integer.parseInt(scan.nextLine());
                    }
                    if(list.findPosition(list, aElement) != null) {
                        list.addAfter((Position<Integer>) list.findPosition(list, aElement), ae);
                        System.out.println(ae + " inserted");   
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "11":
                    System.out.println("********************************************");
                    try {
                        System.out.println("Enter the element you want to replace: ");
                        replaceElement = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter the element to insert: ");
                        setElement = Integer.parseInt(scan.nextLine());
                    }
                    catch(Exception e) {
                        System.out.println("Enter the element you want to replace: ");
                        replaceElement = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter the element to insert: ");
                        setElement = Integer.parseInt(scan.nextLine());
                    }
                    if(list.findPosition(list, replaceElement) != null) {
                        list.set((Position<Integer>) list.findPosition(list, replaceElement), setElement);
                        System.out.println("Replaced.");
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "12":
                    System.out.println("********************************************");
                    try {
                        System.out.println("Enter the element in the list to remove: ");
                        removeElement = Integer.parseInt(scan.nextLine());
                    }
                    catch(Exception e) {
                        System.out.println("Enter the element in the list to remove: ");
                        removeElement = Integer.parseInt(scan.nextLine());
                    }
                    if(list.findPosition(list, removeElement) != null) {
                        System.out.println(list.remove((Position<Integer>) list.findPosition(list, removeElement)) + " removed.");
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "13":
                    System.out.println("********************************************");
                    list.display();
                    System.out.println("********************************************");
                    break;
                default:
                    System.out.println("********************************************");
                    System.out.println("Wrong Choice!");
                    System.out.println("********************************************");
                    break;
            }
            System.out.println("Do you want to continue(Y/N)?: ");
            choice = scan.nextLine();
        }while(choice.equals("y") || choice.equals("Y") || choice.equals("Yes") || choice.equals("yes"));
        System.out.println("Thank You!!");
        scan.close();
    }
}