package hashMapPackage;

import java.util.Iterator;
import java.util.Scanner;

/**
 * A program to implement all Hash Map Operations.
 */
public class Main {
    /**
     * Main Method for the program.
     * @param args
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        ChainHashMap<Integer, String> map = new ChainHashMap<>();
        String choice = "y", menu_choice;
        do {
            System.out.println("*************************Menu*************************");
            System.out.println("1. Size");
            System.out.println("2. Is Empty");
            System.out.println("3. Get");
            System.out.println("4. Put");
            System.out.println("5. Remove");
            System.out.println("6. Display");
            System.out.println("******************************************************");
            System.out.println("Enter your choice: ");
            menu_choice = scan.nextLine();
            switch (menu_choice) {
                case "1":
                    System.out.println("******************************************************");
                    System.out.println("Size of the map is: " + map.size());
                    System.out.println("******************************************************");
                    break;

                case "2":
                    System.out.println("******************************************************");
                    if (map.isEmpty()) {
                        System.out.println("Map is empty.");
                    } else {
                        System.out.println("Map is not empty.");
                    }
                    System.out.println("******************************************************");
                    break;

                case "3":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter key: ");
                        int key = Integer.parseInt(scan.nextLine());
                        System.out.println(map.get(key));
                    } catch (Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter key: ");
                        int key = Integer.parseInt(scan.nextLine());
                        System.out.println(map.get(key));
                    }
                    System.out.println("******************************************************");
                    break;

                case "4":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter key: ");
                        int key = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter value: ");
                        String value = scan.nextLine();
                        System.out.println(map.put(key, value));
                    } catch (Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter key: ");
                        int key = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter value: ");
                        String value = scan.nextLine();
                        System.out.println(map.put(key, value));
                    }
                    System.out.println("******************************************************");
                    break;

                case "5":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter key: ");
                        int key = Integer.parseInt(scan.nextLine());
                        System.out.println("Element removed is: " + map.remove(key));
                    } catch (Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter key: ");
                        int key = Integer.parseInt(scan.nextLine());
                        System.out.println("Element removed is: " + map.remove(key));
                    }
                    System.out.println("******************************************************");
                    break;

                case "6":
                    System.out.println("******************************************************");
                    Iterable<Entry<Integer, String>> iterable = map.entrySet();
                    Iterator<Entry<Integer, String>> iterator = iterable.iterator();
                    while(iterator.hasNext()) {
                        System.out.println(iterator.next().getKey() + " : " + iterator.next().getValue());
                    }
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
