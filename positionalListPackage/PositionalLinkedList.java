package positionalListPackage;

import java.util.Iterator;
/**Implementation of the Positional List as a Doubly Linked List */
public class PositionalLinkedList<E> implements PositionalList<E> {
    /**Nested Node Class */
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() {
            if(next == null)
                System.out.println("Position is invalid.");
            return element;
        }
        public Node<E> getPrev() {
            return prev;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setElement(E e) {
            element = e;
        }
        public void setPrev(Node<E> p) {
            prev = p;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    public PositionalLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
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
    private Position<E> position(Node<E> node) {
        if(node == header || node == trailer) {
            return null;
        }
        return node;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public Position<E> first() {
        return position(header.getNext());
    }
    public Position<E> last() {
        return position(trailer.getNext());
    }
    public Position<E> before(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }
    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return position(node.getNext());
    }
    private Position<E> addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
        return newest;
    }
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }
    public Position<E> addBefore(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }
    public Position<E> addAfter(Position<E> p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }
    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }
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
    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first();
        private Position<E> recent = null;
        public boolean hasNext() {
            return cursor != null;
        }
        public Position<E> next() {
            if(cursor == null) {
                System.out.println("No element left.");
            }
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }
        public void remove() {
            if(recent == null) {
                System.out.println("Nothing to remove.");
            }
            PositionalLinkedList.this.remove(recent);
            recent = null;
        }
    }
    private class PositionIterable implements Iterable<Position<E>> {
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }
    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();
        public boolean hasNext() { return posIterator.hasNext(); }
        public E next() { return posIterator.next().getElement(); }
        public void remove() { posIterator.remove(); }
    }
}
