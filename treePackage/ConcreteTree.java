package treePackage;

import java.util.ArrayList;
import java.util.List;

/**
 * A concrete class for implementing all of `Tree` interfaces methods and also implementing various tree properties.
 */
public class ConcreteTree<E> implements Tree<E> {
    public TreeNode<E> root;
    int size;
    
    /**
     * Contructor to create the tree with a root node at the top.
     * @param data Element of the root node
     */
    public ConcreteTree(E data) {
        root = new TreeNode<>(data);
        size++;
    }

    /**
     * Private method to check if a position is valid or invalid
     * @param p Position
     * @return The node on the given position if valid
     */
    private TreeNode<E> validate(Position<E> p) {
        if(!(p instanceof TreeNode<E>)) {
            System.out.println("Invalid Position");
        }
        TreeNode<E> node = (TreeNode<E>) p;
        return node;
    }

    /**
     * @param p User-given position of a node
     * @return True if node has atleast one child else false
     */
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    /**
     * @param p User-given position of a node
     * @return True if node has zero child nodes else false
     */
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    /**
     * @param p User-given position of a node
     * @return True if node is root of the tree else false
     */
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    /**
     * @return True if tree is empty else false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * @return Root of the tree
     */
    public Position<E> root() {
        return root;
    }

    /**
     * @param p User-given position of a node
     * @return Parent of the given node
     */
    public Position<E> parent(Position<E> p) {
        TreeNode<E> node = validate(p);
        return node.parent;
    }

    /**
     * @param p User-given position of a node
     * @return List of child nodes
     */
    public List<TreeNode<E>> children(Position<E> p) {
        TreeNode<E> node = validate(p);
        return node.children;
    }

    /**
     * @param p User-given position of a node
     * @return Number of children the node has
     */
    public int numChildren(Position<E> p) {
        TreeNode<E> node = validate(p);
        return node.children.size();
    }

    /**
     * @return Size of the tree
     */
    public int size() {
        return size;
    }
    
    /**
     * Recursively searches for a TreeNode with the specified data value in the tree.
     *
     * @param node The current node to start the search from.
     * @param data The data value to search for in the tree.
     * @return The TreeNode with the specified data value, or null if not found.
     */
    public TreeNode<String> findNode(TreeNode<String> node, String data) {
        // Base case: If the current node's data matches the target data, return the node
        if (node.data.equals(data)) {
            return node;
        }

        // Recursive case: Search through the children of the current node
        for (TreeNode<String> child : node.children) {
            // Recursively call findNode on each child
            TreeNode<String> result = findNode(child, data);

            // If the result is not null, the node has been found, so return the result
            if (result != null) {
                return result;
            }
        }

        // If the data is not found in the current subtree, return null
        return null;
    }

    /**
     * Adds a child node with the given data to the specified parent node.
     *
     * @param parent the parent node to which the child will be added
     * @param data   the data of the child node to be added
     */
    public void addChild(TreeNode<E> parent, E data) {
        TreeNode<E> child = new TreeNode<>(data);
        child.parent = parent;
        parent.children.add(child);
        size++;
    }

    /**
     * Displays the tree starting from the given node with proper indentation.
     *
     * @param node  the starting node for display
     * @param level the current level of indentation
     */
    public void displayTree(TreeNode<E> node, int level) {
        System.out.println(" ".repeat(level) + node.data);
        for(TreeNode<E> child : node.children) {
            displayTree(child, level + 1);
        }
    }

    /**
     * Finds siblings of the given node.
     *
     * @param node the node for which to find siblings
     * @return a list of sibling data
     */
    public List<E> findSiblings(TreeNode<E> node) {
        if(node.parent == null) {
            return new ArrayList<>();
        }
        List<E> siblings = new ArrayList<>();
        for(TreeNode<E> sibling : node.parent.children) {
            if(!sibling.equals(node)) {
                siblings.add(sibling.data);
            }
        }
        return siblings;
    }

    /**
     * Lists the leaves of the tree starting from the given node.
     *
     * @param node the starting node for listing leaves
     * @return a list of leaf data
     */
    public List<E> listLeaves(TreeNode<E> node) {
        if(node.children.isEmpty()) {
            List<E> leaves = new ArrayList<>();
            leaves.add(node.data);
            return leaves;
        } else {
            List<E> leaves = new ArrayList<>();
            for(TreeNode<E> child : node.children) {
                leaves.addAll(listLeaves(child));
            }
            return leaves;
        }
    }

    /**
     * Lists internal nodes of the tree starting from the given node.
     *
     * @param node the starting node for listing internal nodes
     * @return a list of internal node data
     */
    public List<E> listInternalNodes(TreeNode<E> node) {
        if(node.children.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<E> internalNodes = new ArrayList<>();
            internalNodes.add(node.data);
            for(TreeNode<E> child : node.children) {
                internalNodes.addAll(listInternalNodes(child));
            }
            return internalNodes;
        }
    }

    /**
     * Lists edges of the tree starting from the given node.
     *
     * @param node the starting node for listing edges
     * @return a list of edge strings
     */
    public List<String> listEdges(TreeNode<E> node) {
        List<String> edges = new ArrayList<>();
        for(TreeNode<E> child : node.children) {
            edges.add("(" + node.data + ", " + child.data + ")");
            edges.addAll(listEdges(child));
        }
        return edges;
    }

    /**
     * Finds the path from the root to a specific node.
     *
     * @param startNode   the starting node for the path
     * @param targetData  the data of the target node
     * @param path        the current path being traversed
     * @return the path from the root to the target node
     */
    public List<String> pathForNode(TreeNode<E> startNode, String targetData, List<String> path) {
        path.add(String.valueOf(startNode.data));
        if (startNode.data.equals(targetData)) {
            return path;
        }
        for (TreeNode<E> child : startNode.children) {
            List<String> newPath = pathForNode(child, targetData, new ArrayList<>(path));
            if (newPath != null) {
                return newPath;
            }
        }
        return null;
    }

    /**
     * Calculates the depth of a node in the tree.
     *
     * @param node the node for which to calculate the depth
     * @return the depth of the node
     */
    public int depthOfNode(TreeNode<E> node) {
        int depth = 0;
        while (node.parent != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    /**
     * Calculates the height of the tree starting from the given node.
     *
     * @param node the starting node for calculating the height
     * @return the height of the tree
     */
    public int heightOfTree(TreeNode<E> node) {
        if (node.children.isEmpty()) {
            return 1;
        } else {
            int maxHeight = 1;
            for (TreeNode<E> child : node.children) {
                maxHeight = Math.max(maxHeight, heightOfTree(child));
            }
            return 1 + maxHeight;
        }
    }

    /**
     * Creates a subtree rooted at the given node.
     *
     * @param node the root node for the subtree
     * @return a new ConcreteTree representing the subtree
     */
    public ConcreteTree<E> subtreeAtNode(TreeNode<E> node) {
        ConcreteTree<E> subtree = new ConcreteTree<>(node.data);
        subtree.root = node;
        return subtree;
    }
}
