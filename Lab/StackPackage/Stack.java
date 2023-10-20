package stackPackage;
/**
 * This program uses interface `Stack` with mwthods size(), isEmpty(), push(), top(), and pop() to implement stack based on array using Generic classes.
 * @param <E> the type of elements stored in the stack
 * @author Krish Porwal
 * @version 1.0.0
 * @since 1 - 10 - 2023
 */
interface Stack<E> {
    /**
     * Returns the number of elements in the stack.
     *
     * @return The size of the stack.
     */
    int size();
    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    boolean isEmpty();
    /**
     * Pushes an element onto the stack.
     *
     * @param e The element to be pushed onto the stack.
     */
    void push(Object e);
    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The top element of the stack.
     */
    E top();
    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The removed top element of the stack.
     */
    E pop();
}