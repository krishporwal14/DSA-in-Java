package queueAndStack;

import java.util.Scanner;

public class Execution {
    @SuppressWarnings("rawtypes")
    public Execution(){
         Scanner scan = new Scanner(System.in);
        String structure_choice, choice = "y", menu_option, type_choice;  
        MyStack stack;
        MyQueue queue;
        int capacity;
        System.out.println("**********************Select Data Structure************************");
        System.out.println("1. Stack");
        System.out.println("2. Queue:");
        System.out.println("******************************************************");
        System.out.println("Enter your preferred data structure: ");
        structure_choice = scan.nextLine();
        switch(structure_choice) {
            case "1":
                System.out.println("**********************Select Stack Datatype************************");
                System.out.println("1. String");
                System.out.println("2. Integer");
                System.out.println("3. Float");
                System.out.println("4. Long");
                System.out.println("******************************************************");
                System.out.println("Enter your preferred datatype: ");
                type_choice = scan.nextLine();
                System.out.println("Enter the capacity of stack: ");
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
                        stack = new MyStack<String>(capacity);
                        System.out.println("Stack Initialized.");
                        System.out.println("******************************************************");
                        break;
                    case "2":
                        System.out.println("******************************************************");
                        stack = new MyStack<Integer>(capacity);
                        System.out.println("Stack Initialized.");
                        System.out.println("******************************************************");
                        break;
                    case "3":
                        System.out.println("******************************************************");
                        stack = new MyStack<Float>(capacity);
                        System.out.println("Stack Initialized.");
                        System.out.println("******************************************************");
                        break;
                    case "4":
                        System.out.println("******************************************************");
                        stack = new MyStack<Long>(capacity);
                        System.out.println("Stack Initialized.");
                        System.out.println("******************************************************");
                        break;
                    default:
                        System.out.println("******************************************************");
                        System.out.println("Wrong Choice!");
                        System.out.println("Stack will be of Integer datatype by default.");
                        stack = new MyStack<Integer>(capacity);
                        System.out.println("******************************************************");
                        break;
                }
                do {
                    System.out.println("***************************Menu***************************");
                    System.out.println("1. Size");
                    System.out.println("2. Is Empty");
                    System.out.println("3. Push");
                    System.out.println("4. Top");
                    System.out.println("5. Pop");
                    System.out.println("6. Display");
                    System.out.println("******************************************************");
                    System.out.println("Enter your choice: ");
                    menu_option = scan.nextLine();
                    switch(menu_option) {
                        case "1":
                            System.out.println("******************************************************");
                            System.out.println("Size of the Stack is: " + stack.size());
                            System.out.println("******************************************************");
                            break;
                        case "2":
                            System.out.println("******************************************************");
                            if(stack.isEmpty()) {
                                System.out.println("Stack is Empty.");
                            }
                            else {
                                System.out.println("Stack is not empty.");
                            }
                            System.out.println("******************************************************");
                            break;
                        case "3":
                            System.out.println("******************************************************");
                            System.out.println("Enter the element to push into stack: ");
                            Object element = (Object) scan.nextLine();
                            stack.push(element);
                            System.out.println("******************************************************");
                            break;
                        case "4":
                            System.out.println("******************************************************");
                            System.out.println("Top of the Stack is: " + stack.top());
                            System.out.println("******************************************************");
                            break;
                        case "5":
                            System.out.println("******************************************************");
                            System.out.println("Popped element is: " + stack.pop());
                            System.out.println("******************************************************");
                            break;
                        case "6":
                            System.out.println("******************************************************");
                            stack.display();
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
                break;
            case "2":
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
                break;
            default:
                System.out.println("******************************************************");
                System.out.println("Wrong Choice!");
                System.out.println("******************************************************");
                break;
        }
    }
    
}
