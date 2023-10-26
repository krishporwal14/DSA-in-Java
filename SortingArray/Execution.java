package sortingArray;

import java.util.Scanner;

public class Execution {
    public Execution(){
         Scanner scan = new Scanner(System.in);
        Sorting arr; 
        String menu_option; 
        String choice = "y"; 
        System.out.println("******************************************************");
        System.out.println("Enter the size of array: ");
        try {
            arr = new Sorting(Integer.parseInt(scan.nextLine()));
        }
        catch(Exception e) {
            System.out.println("Enter a numerical value only.");
            arr = new Sorting(Integer.parseInt(scan.nextLine()));
        }
        System.out.println("Array initialized."); 
        System.out.println("******************************************************");
        do { 
            System.out.println("**********************Menu*************************"); 
            System.out.println("1. Search Element");
            System.out.println("2. Insert Element");
            System.out.println("3. Fetch Element");
            System.out.println("4. Delete Element");
            System.out.println("5. Display Element");
            System.out.println("6. Delete Duplicate Elements");
            System.out.println("7. Insert element at index");
            System.out.println("8. Delete element at");
            System.out.println("9. Initialize array with random values");
            System.out.println("10. Sort array with Bubble sort");
            System.out.println("11. Sort array with Selection sort");
            System.out.println("12. Sort array with Insertion sort");
            System.out.println("******************************************************");
            System.out.println("Select an option: ");
            menu_option = scan.nextLine();
            switch (menu_option) { 
                case "1":
                    System.out.println("******************************************************");
                    System.out.println("Enter the element to search: ");
                    try {
                        int res = arr.find(Long.parseLong(scan.nextLine()));
                        if(res == -1) {
                            System.out.println("Element not found.");
                        }
                        else {
                            System.out.println("Element found at " + res + " position.");
                        }
                    }
                    catch(Exception e) {System.out.println("Enter a numerical value only.");}
                    System.out.println("******************************************************");
                    break;
                
                case "2":
                    if(arr.getRemainingPositions() == 0) {
                        System.out.println("Array is full.");
                    }
                    else {
                    System.out.println("******************************************************");
                    System.out.println("How many elements do you want to enter?: ");
                    try {
                        int counter = Integer.parseInt(scan.nextLine());
                        if(counter > arr.getRemainingPositions()) {
                            System.out.println("The entered value is greater than the available space in array. Enter the number which is less than or equal to the space available(" + arr.getRemainingPositions() + "): ");
                            counter = Integer.parseInt(scan.nextLine());
                            if(counter > arr.getRemainingPositions()) {
                                System.out.println("The entered value is greater than the available space in array. Enter the number which is less than or equal to the space available(" + arr.getRemainingPositions() + "): ");
                                break;
                            }
                        }
                        for(int i = 1; i <= counter; i++) {
                            System.out.println("Enter the element to insert: ");
                            arr.insert(Long.parseLong(scan.nextLine())); 
                            System.out.println("Inserted successfully.");
                        }
                    }
                    catch(Exception e) {System.out.println("Enter a numerical value only.");}
                    System.out.println("******************************************************");
                    }
                    break;
                
                case "3":
                    System.out.println("******************************************************");
                    System.out.println("Enter the element to fetch: ");
                    try {
                        long elem = arr.getElem(Integer.parseInt(scan.nextLine())); 
                        System.out.println("Element on the given index is: " + elem);
                    }
                    catch(Exception e) {System.out.println("Enter a numerical value only.");}
                    System.out.println("******************************************************");
                    break;
                
                case "4":
                    System.out.println("******************************************************");
                    System.out.println("Enter the element to delete: ");
                    try {
                        if(arr.delete(Long.parseLong(scan.nextLine()))) { 
                            System.out.println("Element deleted.");
                        }
                        else {
                            System.out.println("Element not found.");
                        }
                    }
                    catch(Exception e) {System.out.println("Enter a numerical value only.");}
                    System.out.println("******************************************************");
                    break;
                
                case "5":
                    System.out.println("******************************************************");
                    System.out.println("Array Elements are: ");
                    arr.display(); 
                    System.out.println("******************************************************");
                    break;
                
                case "6":
                    System.out.println("******************************************************");
                    System.out.println("Enter the element to delete: ");
                    try {
                        int count = arr.dupDelete(Long.parseLong(scan.nextLine())); 
                        System.out.println(count + " elements deleted.");
                    }
                    catch(Exception e) {System.out.println("Enter a numerical value only.");}
                    System.out.println("******************************************************");
                    break;
                
                case "7":
                    System.out.println("******************************************************");
                    System.out.println("Enter index and element to insert: (index element)");
                    try {
                        String str[] = scan.nextLine().split(" "); 
                        int index = Integer.parseInt(str[0]); 
                        long element = Long.parseLong(str[1]); 
                        arr.insert(index, element);
                    }
                    catch(Exception e) {System.out.println("Enter a numerical value only.");}
                    System.out.println("******************************************************");
                    break;
                
                case "8":
                    System.out.println("******************************************************");
                    System.out.println("Delete element at: ");
                    try {
                        long ele = arr.deleteAt(Integer.parseInt(scan.nextLine()));
                        System.out.println(ele + " deleted.");
                    }
                    catch(Exception e) {System.out.println("Enter a numerical value only.");}
                    System.out.println("******************************************************");
                    break;

                case "9":
                    System.out.println("******************************************************");
                    arr.initArray();
                    System.out.println("******************************************************");
                    break;

                case "10":
                    System.out.println("******************************************************");
                    arr.bubbleSort();
                    System.out.println("******************************************************");
                    break;

                case "11":
                    System.out.println("******************************************************");
                    arr.selectionSort();
                    System.out.println("******************************************************");
                    break;

                case "12":
                    System.out.println("******************************************************");
                    arr.insertionSort();
                    System.out.println("******************************************************");
                    break;
                
                default: 
                    System.out.println("******************************************************");
                    System.out.println("Wrong Choice!!");
                    System.out.println("******************************************************");
                    break;
            }
            System.out.println("Do you want to continue? (Y/N): ");
            choice = scan.nextLine(); 
        }while(choice.equals("y") || choice.equals("Yes") || choice.equals("Y") || choice.equals("yes")); 
        System.out.println("******************************************************");
        System.out.println("Thank you!!!");
        scan.close();
    }
    
}
