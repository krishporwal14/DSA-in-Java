package graphPackage;

/**
 * Interface representing a generic graph with vertices and edges.
 *
 * @param <V> The type of element stored in vertices.
 * @param <E> The type of element stored in edges.
 */
public interface Graph<V, E> {

    /**
     * Retrieves the number of vertices in the graph.
     *
     * @return The number of vertices.
     */
    int numVertices();

    /**
     * Retrieves an iterable collection of all vertices in the graph.
     *
     * @return An iterable collection of vertices.
     */
    Iterable<Vertex<V>> vertices();

    /**
     * Retrieves the number of edges in the graph.
     *
     * @return The number of edges.
     */
    int numEdges();

    /**
     * Retrieves an iterable collection of all edges in the graph.
     *
     * @return An iterable collection of edges.
     */
    Iterable<Edge<E>> edges();

    /**
     * Retrieves the edge connecting vertices u and v, if it exists.
     *
     * @param u The source vertex.
     * @param v The destination vertex.
     * @return The edge connecting u and v, or null if no such edge exists.
     */
    Edge<E> getEdge(Vertex<V> u, Vertex<V> v);

    /**
     * Retrieves an array containing the endpoints of the edge.
     *
     * @param e The edge.
     * @return An array containing the endpoints of the edge.
     */
    Vertex<V>[] endVertices(Edge<E> e);

    /**
     * Retrieves the vertex opposite to the specified vertex along the edge.
     *
     * @param v The reference vertex.
     * @param e The edge.
     * @return The vertex opposite to v along the edge e.
     */
    Vertex<V> opposite(Vertex<V> v, Edge<E> e);

    /**
     * Retrieves the out-degree of a specified vertex.
     *
     * @param v The vertex.
     * @return The out-degree of the vertex.
     */
    int outDegree(Vertex<V> v);

    /**
     * Retrieves the in-degree of a specified vertex.
     *
     * @param v The vertex.
     * @return The in-degree of the vertex.
     */
    int inDegree(Vertex<V> v);

    /**
     * Retrieves an iterable collection of outgoing edges from a specified vertex.
     *
     * @param v The vertex.
     * @return An iterable collection of outgoing edges from the vertex.
     */
    Iterable<Edge<E>> outgoingEdges(Vertex<V> v);

    /**
     * Retrieves an iterable collection of incoming edges to a specified vertex.
     *
     * @param v The vertex.
     * @return An iterable collection of incoming edges to the vertex.
     */
    Iterable<Edge<E>> incomingEdges(Vertex<V> v);

    /**
     * Inserts a new vertex with the specified element into the graph.
     *
     * @param e The element to be stored in the new vertex.
     * @return The newly inserted vertex.
     */
    Vertex<V> insertVertex(V e);

    /**
     * Inserts a new edge between vertices u and v with the specified element into the graph.
     *
     * @param u The source vertex.
     * @param v The destination vertex.
     * @param e The element to be stored in the new edge.
     * @return The newly inserted edge.
     */
    Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E e);

    /**
     * Removes the specified vertex and its incident edges from the graph.
     *
     * @param v The vertex to be removed.
     */
    void removeVertex(Vertex<V> v);

    /**
     * Removes the specified edge from the graph.
     *
     * @param e The edge to be removed.
     */
    void removeEdge(Edge<E> e);
}
