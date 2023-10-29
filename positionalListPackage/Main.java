package positionalListPackage;

import java.util.Scanner;
public class Main {
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
                    System.out.println("Enter a position: ");
                    // String pos = scan.next();
                    // System.out.println("Position of List before " + pos + " is: " + list.before((Position<Integer>) pos));
                    System.out.println("********************************************");
                    break;
                case "6":
                    System.out.println("********************************************");

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

                    System.out.println("********************************************");
                    break;
                case "9":
                    System.out.println("********************************************");

                    System.out.println("********************************************");
                    break;
                case "10":
                    System.out.println("********************************************");

                    System.out.println("********************************************");
                    break;
                case "11":
                    System.out.println("********************************************");

                    System.out.println("********************************************");
                    break;
                case "12":
                    System.out.println("********************************************");

                    System.out.println("********************************************");
                    break;
                case "13":
                    System.out.println("********************************************");

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
