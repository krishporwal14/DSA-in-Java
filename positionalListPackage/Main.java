package positionalListPackage;

import java.util.Scanner;

public class Main {

    private static Position<Integer> findPosition(PositionalLinkedList<Integer> list, int element) {
        Position<Integer> currentPosition = list.first();
        while (currentPosition != null) {
            if (currentPosition.getElement() == element) {
                return currentPosition;
            }
            currentPosition = list.after(currentPosition);
        }
        return null;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String choice = "y", menu_choice;
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
                    System.out.println("Enter a element in the list: ");
                    int beforeElement = Integer.parseInt(scan.nextLine());
                    if(findPosition(list, beforeElement) != null) {
                        System.out.println("Position before element is: " + list.before((Position<Integer>) findPosition(list, beforeElement)));
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "6":
                    System.out.println("********************************************");
                    System.out.println("Enter a element in the list: ");
                    int afterElement = Integer.parseInt(scan.nextLine());
                    if(findPosition(list, afterElement) != null) {
                        System.out.println("Position after element is: " + list.after((Position<Integer>) findPosition(list, afterElement)));
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "7":
                    System.out.println("********************************************");
                    System.out.println("Enter the element to insert: ");
                    int data = Integer.parseInt(scan.nextLine());
                    System.out.println(data + " inserted in " + list.addFirst(data) + " position.");
                    System.out.println("********************************************");
                    break;
                case "8":
                    System.out.println("********************************************");
                    System.out.println("Enter the element to insert: ");
                    data = Integer.parseInt(scan.nextLine());
                    System.out.println(data + " inserted in " + list.addLast(data) + " position.");
                    System.out.println("********************************************");
                    break;
                case "9":
                    System.out.println("********************************************");
                    System.out.println("Enter the a element in the list: ");
                    int bElement = Integer.parseInt(scan.nextLine());
                    System.out.println("Enter the element to insert: ");
                    int be = Integer.parseInt(scan.nextLine());
                    if(findPosition(list, bElement) != null) {
                        list.addBefore((Position<Integer>) findPosition(list, bElement), be);
                        System.out.println(be + " inserted");
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "10":
                    System.out.println("********************************************");
                    System.out.println("Enter the element in the list: ");
                    int aElement = Integer.parseInt(scan.nextLine());
                    System.out.println("Enter the element to insert: ");
                    int ae = Integer.parseInt(scan.nextLine());
                    if(findPosition(list, aElement) != null) {
                        list.addAfter((Position<Integer>) findPosition(list, aElement), ae);
                        System.out.println(ae + " inserted");   
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "11":
                    System.out.println("********************************************");
                    System.out.println("Enter the element you want to replace: ");
                    int replaceElement = Integer.parseInt(scan.nextLine());
                    System.out.println("Enter the element to insert: ");
                    int setElement = Integer.parseInt(scan.nextLine());
                    if(findPosition(list, replaceElement) != null) {
                        list.set((Position<Integer>) findPosition(list, replaceElement), setElement);
                        System.out.println("Replaced.");
                    }
                    else {
                        System.out.println("No such element.");
                    }
                    System.out.println("********************************************");
                    break;
                case "12":
                    System.out.println("********************************************");
                    System.out.println("Enter the element in the list to remove: ");
                    int removeElement = Integer.parseInt(scan.nextLine());
                    if(findPosition(list, removeElement) != null) {
                        System.out.println(list.remove((Position<Integer>) findPosition(list, removeElement)) + " removed.");
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