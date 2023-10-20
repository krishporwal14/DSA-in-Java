package queuePackage;
/**
 * A generic interface for a Queue data structure. The interface `Queue` has the methods size(), isEmpty(), enqueue(), first(), and dequeue().
 * @param <E> the type of elements stored in the queue
 * @author Krish Porwal
 * @version 1.0.0
 * @since 1 - 10 - 2023
 */
interface Queue<E> {
    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue
     */
    int size();
    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();
    /**
     * Adds an element to the rear of the queue.
     *
     * @param e the element to enqueue
     */
    void enqueue(Object e);
    /**
     * Returns the first element in the queue without removing it.
     *
     * @return the first element in the queue, or null if the queue is empty
     */
    E first();
    /**
     * Removes and returns the first element in the queue.
     *
     * @return the removed element, or null if the queue is empty
     */
    E dequeue();
}
