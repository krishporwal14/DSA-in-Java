package graphPackage;

/**
 * Interface representing a vertex in a graph.
 *
 * @param <V> The type of element stored in the vertex.
 */
public interface Vertex<V> {

    /**
     * Retrieves the element stored in the vertex.
     *
     * @return The element stored in the vertex.
     */
    V getElement();
}
