package positionalListPackage;

import java.util.Iterator;

/**
 * @author Krish Porwal
 * @since 28-10-2023
 * @version 1.0.0
 */

/**
 * Implementation of the Positional List as a Doubly Linked List
 */
public class PositionalLinkedList<E> implements PositionalList<E> {
    /**
     * Nested Node Class of doubly linked list
     */
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        /**
         * Contructor for Node Class
         * @param e Data Element
         * @param p Previous Node
         * @param n Next Node
         */
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        /**
         * @return Element placed on the position
         */
        public E getElement() {
            if(next == null)
                System.out.println("Position is invalid.");
            return element;
        }
        /**
         * @return Previous Node
         */
        public Node<E> getPrev() {
            return prev;
        }
        /**
         * @return Next Node
         */
        public Node<E> getNext() {
            return next;
        }
        /**
         * Sets the element of the node
         * @param e Data Element
         */
        public void setElement(E e) {
            element = e;
        }
        /**
         * Sets the previous node
         * @param p Previous Node
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }
        /**
         * Stes the next node
         * @param n Next Node
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    /**
     * Constructor for Positional Doubly Linked List
     */
    public PositionalLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    /**
     * Private method to check if a position is valid or invalid
     * @param p Position
     * @return The node on the given position if valid
     */
    private Node<E> validate(Position<E> p) {
        if(!(p instanceof Node<E>)) {
            System.out.println("Invalid Position");
        }
        Node<E> node = (Node<E>) p;
        if(node.getNext() == null) {
            System.out.println("Node is no longer in the list.");
        }
        return node;
    }
    /**
     * Private method to abstract the sentient nodes from the users
     * @param node Node to be checked
     * @return Node if it is not sentient node else null
     */
    private Position<E> position(Node<E> node) {
        if(node == header || node == trailer) {
            return null;
        }
        return node;
    }
    /**
     * @return Size of the List
     */
    public int size() {
        return size;
    }
    /**
     * @return Boolean value if list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * @return The first Position of the list
     */
    public Position<E> first() {
        return position(header.getNext());
    }
    /**
     * @return The last position of the list
     */
    public Position<E> last() {
        return position(trailer.getPrev());
    }
    /**
     * @param p Position in the list
     * @return Postion before p
     */
    public Position<E> before(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }
    /**
     * @param p Position in the list
     * @return Postion after p
     */
    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getNext());
    }
    /**
     * Private method which adds a node between tow given positions
     * @param e Data Element
     * @param predecessor Previous Node
     * @param successor Next Node
     * @return The created node
     */
    private Position<E> addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
        return newest;
    }
    /**
     * Add node to the start of the list
     * @param e Data Element
     * @return New node
     */
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }
    /**
     * Add node to the end of the list
     * @param e Data Element
     * @return New node
     */
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }
    /**
     * Add node before a position
     * @param p Position
     * @return New node
     */
    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }
    /**
     * Add node after a position
     * @param p Position
     * @return New node
     */
    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }
    /**
     * Update or change the data element of a node
     * @param p Position of the node
     * @param e Data Element
     * @return The previous data element in the node
     */
    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }
    /**
     * Removes the position from the list
     * @param p Position to be removed
     * @return The data element of the removed node
     */
    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return answer;
    }
    /**
     * A private class which implements `Iterator` interface
     */
    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first();
        private Position<E> recent = null;
        /**
         * @return Boolean value if there is a next element or not
         */
        public boolean hasNext() {
            return cursor != null;
        }
        /**
         * @return The next position if the list
         */
        public Position<E> next() {
            if(cursor == null) {
                System.out.println("No element left.");
            }
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }
        /**
         * Removes the position from the list
         */
        public void remove() {
            if(recent == null) {
                System.out.println("Nothing to remove.");
            }
            PositionalLinkedList.this.remove(recent);
            recent = null;
        }
    }
    /**
     * Private class which implements the `Iterable` interface
     */
    private class PositionIterable implements Iterable<Position<E>> {
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }
    /**
     * Creates and returns an iterator for the list
     * @return An object of `PositionIterable` class
     */
    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }
    /**
     * Private class which implements `Iterator` interface
     */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();
        public boolean hasNext() { return posIterator.hasNext(); }
        public E next() { return posIterator.next().getElement(); }
        public void remove() { posIterator.remove(); }
    }
    /**
     * Displays all the elements of the list.
     */
    public void display() {
        ElementIterator i = new ElementIterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
