package binaryTreePackage;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic class to implement a binary tree and its various operations.
 *
 * @param <E> The type of elements stored in the binary tree.
 */
public class BinaryTree<E> {
    
    /**
     * Nested class to represent a single node element of the tree.
     */
    protected static class Node<E> implements Position<E> {
        /** Data stored in the node. */
        private E element;
        /** Parent of the node. */
        private Node<E> parent;
        /** Left child of the node. */
        private Node<E> left;
        /** Right child of the node. */
        private Node<E> right;

        /**
         * Constructor to initialize the node.
         *
         * @param e Element
         * @param p Parent
         * @param l Left child
         * @param r Right child
         */
        public Node(E e, Node<E> p, Node<E> l, Node<E> r) {
            this.element = e;
            this.parent = p;
            this.left = l;
            this.right = r;
        }

        /** Accessor methods */

        /**
         * Returns the element in the node.
         *
         * @return Element in the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the parent of the node.
         *
         * @return Parent of the node
         */
        public Node<E> getParent() {
            return parent;
        }

        /**
         * Returns the left child of the node.
         *
         * @return Left child of the node
         */
        public Node<E> getLeft() {
            return left;
        }

        /**
         * Returns the right child of the node.
         *
         * @return Right child of the node
         */
        public Node<E> getRight() {
            return right;
        }

        /** Setter methods */

        /**
         * Sets the element in the node.
         *
         * @param e Element to set
         */
        public void setElement(E e) {
            this.element = e;
        }

        /**
         * Sets the parent of the node.
         *
         * @param p Parent to set
         */
        public void setParent(Node<E> p) {
            this.parent = p;
        }

        /**
         * Sets the left child of the node.
         *
         * @param l Left child to set
         */
        public void setLeft(Node<E> l) {
            this.left = l;
        }

        /**
         * Sets the right child of the node.
         *
         * @param r Right child to set
         */
        public void setRight(Node<E> r) {
            this.right = r;
        }
    }

    // Class fields
    protected Node<E> root = null;
    private int size = 0;

    // Class methods

    /**
     * Factory method to create a new node with the given data and children.
     *
     * @param e      Element for the new node
     * @param parent Parent of the new node
     * @param left   Left child of the new node
     * @param right  Right child of the new node
     * @return Newly created node
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    /**
     * Validates a given position in the tree.
     *
     * @param p Position to validate
     * @return Validated node corresponding to the position
     * @throws IllegalArgumentException if the position is invalid
     */
    public Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid Position.");
        }
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node) {
            throw new IllegalArgumentException(p + " is no longer in the tree.");
        }
        return node;
    }

    /**
     * Returns the size of the tree.
     *
     * @return Number of nodes in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the tree is empty.
     *
     * @return True if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if a given position represents an internal node.
     *
     * @param p Position to check
     * @return True if the node is internal, false otherwise
     * @throws IllegalArgumentException if the position is invalid
     */
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if((node.getLeft() != null) || (node.getRight() != null)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks if a given position represents an external node.
     *
     * @param p Position to check
     * @return True if the node is external, false otherwise
     * @throws IllegalArgumentException if the position is invalid
     */
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if((node.getLeft() == null) && (node.getRight() == null)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Returns the root position of the tree.
     *
     * @return Root position of the tree
     */
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the parent position of a given position.
     *
     * @param p Position to find the parent for
     * @return Parent position of the given position
     * @throws IllegalArgumentException if the position is invalid
     */
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Returns the left child position of a given position.
     *
     * @param p Position to find the left child for
     * @return Left child position of the given position
     * @throws IllegalArgumentException if the position is invalid
     */
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * Returns the right child position of a given position.
     *
     * @param p Position to find the right child for
     * @return Right child position of the given position
     * @throws IllegalArgumentException if the position is invalid
     */
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    /**
     * Adds a root to the tree with the given element.
     *
     * @param e Element for the root
     * @return Root position of the tree
     * @throws IllegalArgumentException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalArgumentException {
        if(!isEmpty()) {
            throw new IllegalArgumentException("Tree is not empty.");
        }
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * Sets the element of a given position to a new element.
     *
     * @param p Position to set the element for
     * @param e New element to set
     * @return Previous element at the given position
     * @throws IllegalArgumentException if the position is invalid
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * Adds a left child with the given element to a given position.
     *
     * @param p Position to add the left child to
     * @param e Element for the left child
     * @return Position of the newly added left child
     * @throws IllegalArgumentException if the position is invalid or already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getLeft() != null) {
            throw new IllegalArgumentException(parent.getElement() + " already has a left child.");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Adds a right child with the given element to a given position.
     *
     * @param p Position to add the right child to
     * @param e Element for the right child
     * @return Position of the newly added right child
     * @throws IllegalArgumentException if the position is invalid or already has a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getRight() != null) {
            throw new IllegalArgumentException(parent.getElement() + " already has a right child.");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * Attaches two subtrees and a root to a given position.
     *
     * @param p  Position to attach the subtrees and root to
     * @param t1 Left subtree to attach
     * @param t2 Right subtree to attach
     * @throws IllegalArgumentException if the position is not a leaf
     */
    public void attach(Position<E> p, BinaryTree<E> t1, BinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if(isInternal(p)) {
            throw new IllegalArgumentException("Node must be a leaf.");
        }
        size += t1.size() + t2.size();
        if(!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if(!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes a node at a given position from the tree.
     *
     * @param p Position to remove
     * @return Element of the removed node
     * @throws IllegalArgumentException if the node has two children
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if((node.getLeft() != null) && (node.getRight() != null)) {
            throw new IllegalArgumentException(node.getElement() + " has two children.");
        }
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if(child != null) {
            child.setParent(node.getParent());
        }
        if(node == root) {
            root = child;
        }
        else {
            Node<E> parent = node.getParent();
            if(node == parent.getLeft()) {
                parent.setLeft(child);
            }
            else {
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }

    /**
     * Displays the tree structure.
     */
    public void displayTree() {
        displayTree(root, 0);
    }
    private void displayTree(Node<E> node, int depth) {
        if (node != null) {
            displayTree(node.getRight(), depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("   ");
            }
            System.out.println(node.getElement());
            displayTree(node.getLeft(), depth + 1);
        }
    }

    /**
     * Public method to find a position of given element.
     * @param list Collection
     * @param element Element to find position of
     * @return Position of the 
     */
    public Position<E> findPosition(BinaryTree<E> tree, Node<E> node, E data) {
        if(node.getElement().equals(data)) {
            Position<E> currentPosition = (Position<E>) node;
            return currentPosition;
        }
        else if(findPosition(tree, node.getRight(), data) != null) {
            Position<E> currentPosition = (Position<E>) node;
            currentPosition = findPosition(tree, node.getRight(), data) != null ? findPosition(tree, node.getRight(), data) : null;
            return currentPosition;
        }
        else if(findPosition(tree, node.getLeft(), data) != null) {
            Position<E> currentPosition = (Position<E>) node;
            currentPosition = findPosition(tree, node.getLeft(), data) != null ? findPosition(tree, node.getLeft(), data) : null;
            return currentPosition;
        }
        else {
            System.out.println("4");
            return null;
        }
    }

    /**
     * Performs a preorder traversal of the tree and returns a list of elements.
     *
     * @return List of elements obtained through preorder traversal
     */
    public List<E> preorderTraversal() {
        List<E> list = preorderTraversal(root);
        return list;
    }
    private List<E> preorderTraversal(Node<E> node) {
        List<E> list = new ArrayList<>();
        if (node != null) {
            list.add(node.getElement());
            list.addAll(preorderTraversal(node.getLeft()));
            list.addAll(preorderTraversal(node.getRight()));
        }
        return list;
    }


    /**
     * Performs an inorder traversal of the tree and returns a list of elements.
     *
     * @return List of elements obtained through inorder traversal
     */
    public List<E> inorderTraversal() {
        List<E> result = inorderTraversal(root);
        return result;
    }
    private List<E> inorderTraversal(Node<E> node) {
        List<E> result = new ArrayList<>();
        if (node != null) {
            result.addAll(inorderTraversal(node.getLeft()));
            result.add(node.getElement());
            result.addAll(inorderTraversal(node.getRight()));
        }
        return result;
    }

    /**
     * Performs a postorder traversal of the tree and prints the elements.
     */
    public void postorderTraversal() {
        postorderTraversal(root);
    }

    private void postorderTraversal(Node<E> node) {
        if (node != null) {
            postorderTraversal(node.getLeft());
            postorderTraversal(node.getRight());
            System.out.print(node.getElement() + " ");
        }
    }
}
