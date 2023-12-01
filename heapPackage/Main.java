import java.util.Scanner;

/**
 * A test application to check all the operations of priority queue implemented
 * using heap data structure.
 */
public class Main {
    /**
     * Main method of the program.
     * 
     * @param args
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        HeapPriorityQueue<Integer, String> queue = new HeapPriorityQueue<>();
        String choice = "y", menu_choice;
        do {
            System.out.println("*************************Menu*************************");
            System.out.println("1. Size");
            System.out.println("2. Is Empty");
            System.out.println("3. Insert");
            System.out.println("4. Minimum");
            System.out.println("5. Remove Minimum");
            System.out.println("6. Display Queue");
            System.out.println("******************************************************");
            System.out.println("Enter your choice: ");
            menu_choice = scan.nextLine();
            switch (menu_choice) {
                case "1":
                    System.out.println("******************************************************");
                    System.out.println("Size of the priority queue is: " + queue.size());
                    System.out.println("******************************************************");
                    break;

                case "2":
                    System.out.println("******************************************************");
                    if (queue.isEmpty()) {
                        System.out.println("Priority Queue is empty.");
                    } else {
                        System.out.println("Priority Queue is not empty.");
                    }
                    System.out.println("******************************************************");
                    break;

                case "3":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter priority: ");
                        int priority = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter value: ");
                        String value = scan.nextLine();
                        queue.insert(priority, value);
                    } catch (Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter priority: ");
                        int priority = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter value: ");
                        String value = scan.nextLine();
                        queue.insert(priority, value);
                    }
                    System.out.println("******************************************************");
                    break;

                case "4":
                    System.out.println("******************************************************");
                    System.out.println("Minimum of the Priority Queue is: " + queue.min());
                    System.out.println("******************************************************");
                    break;

                case "5":
                    System.out.println("******************************************************");
                    System.out.println("Element removed is: " + queue.removeMin());
                    System.out.println("******************************************************");
                    break;

                case "6":
                    System.out.println("******************************************************");
                    queue.displayQueue();
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
        } while (choice.equals("y") || choice.equals("Y") || choice.equals("Yes") || choice.equals("yes"));
        System.out.println("Thank You!!");
        scan.close();
    }
}
