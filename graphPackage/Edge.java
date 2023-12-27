package graphPackage;

/**
 * Interface representing an edge in a graph.
 *
 * @param <E> The type of element stored in the edge.
 */
public interface Edge<E> {

    /**
     * Retrieves the element stored in the edge.
     *
     * @return The element stored in the edge.
     */
    E getElement();
}
