package treePackage;
import java.util.List;
import java.util.ArrayList;

/**
 * A generic tree node that stores an element of type T and a list of child nodes.
 *
 * @param <E> the type of element stored in the node
 */
public class TreeNode<E> implements Position<E> {
    public E data;
    public TreeNode<E> parent;
    public List<TreeNode<E>> children;
    /**
     * Constructs a new tree node with the specified data and an empty list of children.
     *
     * @param data the data to be stored in the node
     */
    public TreeNode(E data) {
        this.data = data;
        this.children = new ArrayList<>();
        this.parent = null;
    }
    /**
     * Returns the element stored in the tree node.
     *
     * @return the element stored in the node
     */
    public E getElement() {
        return data;
    }
}
