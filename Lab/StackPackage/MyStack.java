package stackPackage;

/**
 * A generic class that implements the Stack interface.
 *
 * @param <E> The type of elements stored in the stack.
 */
public class MyStack<E> implements Stack<E> {
    private E[] data;
    private int t = -1;
    /**
     * Constructs a stack with the specified capacity.
     *
     * @param capacity The capacity of the stack.
     */
    public MyStack(int capacity) {
        data = (E[]) new Object[capacity];
    }
    /**
     * Returns the number of elements in the stack.
     *
     * @return The size of the stack.
     */
    public int size() {
        return t + 1;
    }
    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public  boolean isEmpty() {
        return t == -1;
    }
    /**
     * Pushes an element onto the stack.
     *
     * @param e The element to be pushed onto the stack.
     */
    public void push(Object e){
        if(size() == data.length) {
            System.out.println("Stack is full.");
        }
        else {
            data[++t] = (E) e;
        }
    }
    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The top element of the stack.
     */
    public E top() {
        if(isEmpty()) {
            return null;
        }
        else {
            return data[t];
        }
    }
    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The removed top element of the stack.
     */
    public E pop() {
        if(isEmpty()) {
            return null;
        }
        else {
            E result = data[t];
            data[t] = null;
            t--;
            return result;
        }
    }
    /**
     * Displays all the stack elements
     */
    public void display() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
        }
        else {
            System.out.println("Stack elements are: ");
            for(int i = 0; i < size() + 1; i++) {
                System.out.println(data[i]);
            }
        }
    }
}

