package queuePackage;
import java.util.Scanner;
/**
 * The main class that provides a menu-driven interface to interact with the queue. This class implements all the applications of the `Queue` interface.
 */
@SuppressWarnings("rawtypes")
public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String choice = "y", menu_option, type_choice;
        MyQueue queue;
        int capacity;
        System.out.println("**********************Select Queue Datatype************************");
        System.out.println("1. String");
        System.out.println("2. Integer");
        System.out.println("3. Float");
        System.out.println("4. Long");
        System.out.println("******************************************************");
        System.out.println("Enter your preferred datatype: ");
        type_choice = scan.nextLine();
        System.out.println("Enter the capacity of queue: ");
        try {
            capacity = Integer.parseInt(scan.nextLine());
        }
        catch(Exception e) {
            System.out.println("Enter numerical value only: ");
            capacity = Integer.parseInt(scan.nextLine());
        }
        switch(type_choice) {
            case "1":
                System.out.println("******************************************************");
                queue = new MyQueue<String>(capacity);
                System.out.println("Queue Initialized.");
                System.out.println("******************************************************");
                break;
            case "2":
                System.out.println("******************************************************");
                queue = new MyQueue<Integer>(capacity);
                System.out.println("Queue Initialized.");
                System.out.println("******************************************************");
                break;
            case "3":
                System.out.println("******************************************************");
                queue = new MyQueue<Float>(capacity);
                System.out.println("Queue Initialized.");
                System.out.println("******************************************************");
                break;
            case "4":
                System.out.println("******************************************************");
                queue = new MyQueue<Long>(capacity);
                System.out.println("Queue Initialized.");
                System.out.println("******************************************************");
                break;
            default:
                System.out.println("******************************************************");
                System.out.println("Wrong Choice!");
                System.out.println("Queue will be of Integer datatype by default.");
                queue = new MyQueue<Integer>(capacity);
                System.out.println("******************************************************");
                break;
        }
        do {
            System.out.println("***************************Menu***************************");
            System.out.println("1. Size");
            System.out.println("2. Is Empty");
            System.out.println("3. Enqueue");
            System.out.println("4. First");
            System.out.println("5. Dequeue");
            System.out.println("6. Display");
            System.out.println("******************************************************");
            System.out.println("Enter your choice: ");
            menu_option = scan.nextLine();
            switch(menu_option) {
                case "1":
                    System.out.println("******************************************************");
                    System.out.println("Size of the queue is: " + queue.size());
                    System.out.println("******************************************************");
                    break;
                case "2":
                    System.out.println("******************************************************");
                    if(queue.isEmpty()) {
                        System.out.println("Queue is Empty.");
                    }
                    else {
                        System.out.println("Queue is not empty.");
                    }
                    System.out.println("******************************************************");
                    break;
                case "3":
                    System.out.println("******************************************************");
                    System.out.println("Enter the element to enqueue into queue: ");
                    Object element = (Object) scan.nextLine();
                    queue.enqueue(element);
                    System.out.println("******************************************************");
                    break;
                case "4":
                    System.out.println("******************************************************");
                    System.out.println("First element of the queue is: " + queue.first());
                    System.out.println("******************************************************");
                    break;
                case "5":
                    System.out.println("******************************************************");
                    System.out.println("Removed element is: " + queue.dequeue());
                    System.out.println("******************************************************");
                    break;
                case "6":
                    System.out.println("******************************************************");
                    queue.display();
                    System.out.println("******************************************************");
                    break;
                default:
                    System.out.println("******************************************************");
                    System.out.println("Wrong Choice");
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