package graphPackage;

import java.util.*;

import positionalListPackage.Position;

/**
 * Implementation of a graph using an adjacency list representation.
 *
 * @param <V> The type of element stored in vertices.
 * @param <E> The type of element stored in edges.
 */
@SuppressWarnings("unchecked")
public class AdjacencyListGraph<V, E> implements Graph<V, E> {

    private boolean isDirected;
    private Map<Vertex<V>, List<Edge<E>>> adjacencyMap;

    /**
     * Constructs an empty AdjacencyListGraph.
     *
     * @param directed true if the graph is directed, false otherwise.
     */
    public AdjacencyListGraph(boolean directed) {
        isDirected = directed;
        adjacencyMap = new HashMap<>();
    }

    /**
     * Inner class representing a vertex in the graph.
     *
     * @param <V> The type of element stored in the vertex.
     */
    class InnerVertex<V> implements Vertex<V> {
        V element;
        Position<Vertex<V>> pos;
        List<Edge<E>> outgoing, incoming;

        /**
         * Constructs an InnerVertex with the given element.
         *
         * @param elem            The element to be stored in the vertex.
         * @param graphIsDirected true if the graph is directed, false otherwise.
         */
        public InnerVertex(V elem, boolean graphIsDirected) {
            element = elem;
            outgoing = new ArrayList<>();
            if (graphIsDirected) {
                incoming = new ArrayList<>();
            } else {
                incoming = outgoing;
            }
        }

        public V getElement() {
            return element;
        }

        public void setPosition(Position<Vertex<V>> p) {
            pos = p;
        }

        public Position<Vertex<V>> getPosition() {
            return pos;
        }

        public List<Edge<E>> getOutgoing() {
            return outgoing;
        }

        public List<Edge<E>> getIncomimg() {
            return incoming;
        }
    }

    /**
     * Inner class representing an edge in the graph.
     *
     * @param <E> The type of element stored in the edge.
     */
    class InnerEdge<E> implements Edge<E> {
        private E element;
        private Vertex<V>[] endpoints;

        /**
         * Constructs an InnerEdge with the given endpoints and element.
         *
         * @param u    The first endpoint vertex.
         * @param v    The second endpoint vertex.
         * @param elem The element to be stored in the edge.
         */
        public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
            element = elem;
            endpoints = (Vertex<V>[]) new Vertex[]{u, v};
        }

        public E getElement() {
            return element;
        }

        public Vertex<V>[] getEndpoints() {
            return endpoints;
        }
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return The number of vertices.
     */
    public int numVertices() {
        return adjacencyMap.size();
    }

    /**
     * Returns an iterable collection of all vertices in the graph.
     *
     * @return An iterable collection of vertices.
     */
    public Iterable<Vertex<V>> vertices() {
        return adjacencyMap.keySet();
    }

    /**
     * Returns the number of edges in the graph.
     *
     * @return The number of edges.
     */
    public int numEdges() {
        int edgeCount = 0;
        for (List<Edge<E>> edges : adjacencyMap.values()) {
            edgeCount += edges.size();
        }
        return edgeCount;
    }

    /**
     * Returns an iterable collection of all edges in the graph.
     *
     * @return An iterable collection of edges.
     */
    public Iterable<Edge<E>> edges() {
        List<Edge<E>> allEdges = new ArrayList<>();
        for (List<Edge<E>> edges : adjacencyMap.values()) {
            allEdges.addAll(edges);
        }
        return allEdges;
    }

    /**
     * Returns the out-degree of a given vertex.
     *
     * @param v The vertex to query.
     * @return The out-degree of the vertex.
     */
    public int outDegree(Vertex<V> v) {
        return getAdjacentEdges(v).size();
    }

    /**
     * Returns an iterable collection of outgoing edges from a given vertex.
     *
     * @param v The vertex to query.
     * @return An iterable collection of outgoing edges.
     */
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        return getAdjacentEdges(v);
    }

    /**
     * Returns the in-degree of a given vertex.
     *
     * @param v The vertex to query.
     * @return The in-degree of the vertex.
     */
    public int inDegree(Vertex<V> v) {
        if (!isDirected) {
            return outDegree(v);
        }

        int inDegree = 0;
        for (Vertex<V> vertex : adjacencyMap.keySet()) {
            if (hasEdge(vertex, v)) {
                inDegree++;
            }
        }
        return inDegree;
    }

    /**
     * Returns an iterable collection of incoming edges to a given vertex.
     *
     * @param v The vertex to query.
     * @return An iterable collection of incoming edges.
     */
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        if (!isDirected) {
            return outgoingEdges(v);
        }

        List<Edge<E>> incomingEdges = new ArrayList<>();
        for (Vertex<V> vertex : adjacencyMap.keySet()) {
            if (hasEdge(vertex, v)) {
                incomingEdges.add(getEdge(vertex, v));
            }
        }
        return incomingEdges;
    }

    /**
     * Returns the edge between two given vertices.
     *
     * @param u The first endpoint vertex.
     * @param v The second endpoint vertex.
     * @return The edge between the vertices, or null if no such edge exists.
     */
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        List<Edge<E>> edges = adjacencyMap.get(u);
        for (Edge<E> edge : edges) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[1] == v) {
                return edge;
            }
        }
        return null;
    }

    /**
     * Returns the endpoints of a given edge.
     *
     * @param e The edge to query.
     * @return An array containing the two endpoints of the edge.
     */
    public Vertex<V>[] endVertices(Edge<E> e) {
        return ((InnerEdge<E>) e).getEndpoints();
    }

    /**
     * Returns the opposite vertex of a given vertex along a given edge.
     *
     * @param v The vertex to find the opposite of.
     * @param e The edge connecting the vertex and its opposite.
     * @return The opposite vertex.
     * @throws IllegalArgumentException If the provided vertex is not incident to the edge.
     */
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        Vertex<V>[] endpoints = endVertices(e);
        if (endpoints[0] == v) {
            return endpoints[1];
        } else if (endpoints[1] == v) {
            return endpoints[0];
        } else {
            throw new IllegalArgumentException("v is not incident to this edge.");
        }
    }

    /**
     * Inserts a new vertex with the given element into the graph.
     *
     * @param element The element to be stored in the new vertex.
     * @return The newly created vertex.
     */
    public Vertex<V> insertVertex(V element) {
        Vertex<V> v = new InnerVertex<>(element, isDirected);
        adjacencyMap.put(v, new ArrayList<>());
        return v;
    }

    /**
     * Inserts a new edge with the given element between two given vertices into the graph.
     *
     * @param u      The first endpoint vertex.
     * @param v      The second endpoint vertex.
     * @param element The element to be stored in the new edge.
     * @return The newly created edge.
     * @throws IllegalArgumentException If an edge from u to v already exists.
     */
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) {
        if (!hasEdge(u, v)) {
            Edge<E> edge = new InnerEdge<>(u, v, element);
            adjacencyMap.get(u).add(edge);
            if (!isDirected) {
                adjacencyMap.get(v).add(edge);
            }
            return edge;
        } else {
            throw new IllegalArgumentException("Edge from u to v exists.");
        }
    }

    /**
     * Removes a given vertex from the graph along with its incident edges.
     *
     * @param v The vertex to be removed.
     */
    public void removeVertex(Vertex<V> v) {
        adjacencyMap.remove(v);
        for (Vertex<V> vertex : adjacencyMap.keySet()) {
            Iterator<Edge<E>> iterator = adjacencyMap.get(vertex).iterator();
            while (iterator.hasNext()) {
                Edge<E> edge = iterator.next();
                InnerEdge<E> e = (InnerEdge<E>) edge;
                if (e.getEndpoints()[1] == v) {
                    iterator.remove();
                }
            }
        }
    }

    /**
     * Removes a given edge from the graph.
     *
     * @param e The edge to be removed.
     */
    public void removeEdge(Edge<E> e) {
        Vertex<V>[] endpoints = endVertices(e);
        adjacencyMap.get(endpoints[0]).remove(e);
        if (!isDirected) {
            adjacencyMap.get(endpoints[1]).remove(e);
        }
    }

    /**
     * Finds and returns a vertex with the given element.
     *
     * @param value The element to search for.
     * @return The vertex with the specified element, or null if not found.
     */
    public Vertex<V> findVertex(V value) {
        for (Vertex<V> vertex : adjacencyMap.keySet()) {
            if (((InnerVertex<V>) vertex).getElement() == value) {
                return vertex;
            }
        }
        return null;
    }

    /**
     * Finds and returns an edge with the given element.
     *
     * @param value The element to search for.
     * @return The edge with the specified element, or null if not found.
     */
    public Edge<E> findEdge(E value) {
        for (List<Edge<E>> edges : adjacencyMap.values()) {
            for (Edge<E> edge : edges) {
                if (edge.getElement() == value) {
                    return edge;
                }
            }
        }
        return null;
    }

    private List<Edge<E>> getAdjacentEdges(Vertex<V> v) {
        return adjacencyMap.getOrDefault(v, Collections.emptyList());
    }

    private boolean hasEdge(Vertex<V> u, Vertex<V> v) {
        return getEdge(u, v) != null;
    }
}
