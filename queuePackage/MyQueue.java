package queuePackage;

/**
 * A generic implementation of the Queue interface.
 *
 * @param <E> the type of elements stored in the queue
 */
public class MyQueue<E> implements Queue<E> {
    private int front = 0;
    private int rear = -1;
    private int size;
    private E[] data;
    /**
     * Initializes a new instance of MyQueue with the specified capacity.
     *
     * @param capacity the maximum number of elements the queue can hold
     */
    @SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }
    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return size;
    }
    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Adds an element to the rear of the queue.
     *
     * @param e the element to enqueue
     */
    @SuppressWarnings("unchecked")
    public void enqueue(Object e) {
        if(size == data.length) {
            System.out.println("Queue is full.");
        }
        else {
            rear = (rear + 1) % data.length;
            data[rear] = (E) e;
            size++;
        }
    }
    /**
     * Returns the first element in the queue without removing it.
     *
     * @return the first element in the queue, or null if the queue is empty
     */
    public E first() {
        if(isEmpty()) {
            return null;
        }
        else {
            return data[front];
        }
    }
    /**
     * Removes and returns the first element in the queue.
     *
     * @return the removed element, or null if the queue is empty
     */
    public E dequeue() {
        if(isEmpty()) {
            return null;
        }
        else {
            E result = data[front];
            data[front] = null;
            front = (front + 1) % data.length;
            size--;
            return result;
        }
    }
    /**
     * Displays the elements of the queue.
     */
    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
        }
        else {
            System.out.println("Queue elements are: ");
            for(int i = 0; i < data.length; i++) {
                System.out.println(data[i]);
            }
        }
    }
}

