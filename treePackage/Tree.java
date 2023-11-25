package treePackage;

import java.util.List;

/**
 * An interface for a tree where nodes can have an arbitrary number of children.
 */
public interface Tree<E> {
    /**
     * @return Root of the tree
     */
    Position<E> root();
    /**
     * @param p User-given position of a node
     * @return Parent of the given node
     */
    Position<E> parent(Position<E> p);
    /**
     * @param p User-given position of a node
     * @return List of child nodes
     */
    public List<TreeNode<E>> children(Position<E> p);
    /**
     * @param p User-given position of a node
     * @return Number of children the node has
     */
    int numChildren(Position<E> p);
    /**
     * @param p User-given position of a node
     * @return True if node has atleast one child else false
     */
    boolean isInternal(Position<E> p);
    /**
     * @param p User-given position of a node
     * @return True if node has zero child nodes else false
     */
    boolean isExternal(Position<E> p);
    /**
     * @param p User-given position of a node
     * @return True if node is root of the tree else false
     */
    boolean isRoot(Position<E> p);
    /**
     * @return Size of the tree
     */
    int size();
    /**
     * @return True if tree is empty else false
     */
    boolean isEmpty();
}
