package sortingArray;
import java.util.Random;
/**
 * This class is MyLongArray1 with attributes a, currentIndex and methods find(), insert(), getElem(), delete(), dupDelete(), display(), insert(), deleteAt(), initArray(), bubbleSort(), selectionSort(), insertionSort().
 * @author Krish Porwal
 * @version 1.0.0
 * @since 22-09-2023
 */
class MyLongArray1 {
    long[] a; 
    int currentIndex; 
    /**
     * Constructor of MyLongArray1 which initializes array and current index
     * @param size  a user defined input to initialize array capacity
     */
    public MyLongArray1(int size) { 
        a = new long[size]; 
        currentIndex = 0; 
    }
    /**
     * This method calculates the remaining spaces available in the array.
     * @return Integer value which indicates the space remaining.
      */
    public int getRemainingPositions() {
        return (a.length - (currentIndex + 1)) + 1;
    }
    /**
     * This method finds the user given value in the array and returns it.
     * @param searchKey a user defined input to find in the array
     * @return element 
     * @throws MyException
     */
    public int find(long searchKey) { 
        if(currentIndex == 0) {
            System.out.println("Array is empty.");
        }
        else {
            for(int i = 0; i < currentIndex; i++) {
                if(a[i] == searchKey) { 
                    return i;
                }
            }
        }
        return -1;
    }
    /** 
     * This method inserts value in the array at the end.
     * @param value  a user defined input which is to be inserted in the array
     */
    public void insert(long value) { 
        a[currentIndex++] = value;
    }
    /** 
     * This method returns the element at given index position.
     * @param index  position given by user
     * @return element found at given index position
     */
    public long getElem(int index) {
        if(currentIndex == 0) {
            System.out.println("Array is empty.");
            return -1;
        }
        else if(index > a.length) {
            System.out.println("Index out of bounds.");
            return -1;
        }
        else {
            return a[index];
        }
    }
    /** 
     * This method deletes a single element from the array.
     * @param value  element to delete
     * @return boolean value depending on if the element is deleted or not.
     */
    public boolean delete(long value) { 
        if(currentIndex == 0) {
            System.out.println("Array is empty.");
        }
        else {
            for(int i = 0; i < currentIndex; i++) { 
                if(a[i] == value) { 
                    for(int j = i; j < currentIndex - 1; j++) {
                        a[j] = a[j + 1]; 
                    }
                    currentIndex--; 
                    return true; 
                }
            }
        }
        return false;
    }
    /** 
     * This method displays all the elements of array. 
     */
    public void display() { 
        if(currentIndex == 0) {
            System.out.println("Array is empty.");
        }
        else {
            for(int i = 0; i < currentIndex; i++) { 
                System.out.println(a[i]);
            }
        }
    }
    /** 
     * This method deletes all the instance of given element.
     * @param value  element to delete
     * @return count  number of elements deleted
     */
    public int dupDelete(long value) {
        int count = 0; 
        if(currentIndex == 0) {
            System.out.println("Array is empty.");
            return -1;
        }
        else { 
            for(int i = 0; i < currentIndex; i++) { 
                if(a[i] == value) { 
                    delete(value); 
                    count++; 
                }
            }
            return count;
        } 
    }
    /** 
     * This method overloads the insert() method and inserts the element at given index position.
     * @param index  position at which to insert value
     * @param value  element to be inserted
     */
    public void insert(int index, long value) {
        if(getRemainingPositions() != 0) {
            for(int i = currentIndex; i > index; i--) { 
                a[i] = a[i - 1]; 
            }
            a[index] = value; 
            currentIndex++;
            System.out.println("Element inserted successfully."); 
        }
        else {
            System.out.println("Array is full.");
        }
    }
    /** 
     * This methods deletes the element at given position.
     * @param index  position at which element is to be deleted.
     * @return  element which is deleted
     */
    public long deleteAt(int index) {
        if(currentIndex == 0) {
            System.out.println("Array is empty.");
            return -1;
        }
        else if(index > a.length) {
            System.out.println("Array is full.");
            return -1;
        }
        else { 
            long temp = a[index]; 
            for(int i = index; i < currentIndex - 1; i++) { 
                a[i] = a[i + 1]; 
            }
            currentIndex--; 
            return temp; 
        }
    }
    /**
     * This method uses the java.util.Random.nextLong() method to initialize the array with random long values. If the array is full or not empty it prompts the user. The method only initializes the array if it is empty. The method also calls the display() method of the class to print all the elements.
     */
    public void initArray() {
        Random rd = new Random();
        int numofinitializedelements = 0;
        if(getRemainingPositions() == 0) {
            System.out.println("Array is full.");
        }
        else if(getRemainingPositions() < a.length) {
            System.out.println("Array already has some elements in it, delete them first and then initialize the array.");
        }
        else {
            for(int i = 0; i < a.length; i++) {
                a[currentIndex++] = rd.nextLong();
                numofinitializedelements++;
            }
            System.out.println("Random elements entered are: " + numofinitializedelements);
            System.out.println("Array elements are: ");
            display();
        }
    }
}
