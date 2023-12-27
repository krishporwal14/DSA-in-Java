package graphPackage;

import hashMapPackage.Map;
import hashMapPackage.ProbeHashMap;
import positionalListPackage.Position;
import positionalListPackage.PositionalLinkedList;

/**
 * Implementation of a graph using an adjacency map representation.
 *
 * @param <V> The type of element stored in vertices.
 * @param <E> The type of element stored in edges.
 */
@SuppressWarnings("unchecked")
public class AdjacencyMapGraph<V, E> implements Graph<V, E> {

    /**
     * Inner class representing a vertex in the graph.
     *
     * @param <V> The type of element stored in the vertex.
     */
    class InnerVertex<V> implements Vertex<V> {
        V element;
        Position<Vertex<V>> pos;
        Map<Vertex<V>, Edge<E>> outgoing, incoming;

        /**
         * Constructs an InnerVertex with the given element.
         *
         * @param elem            The element to be stored in the vertex.
         * @param graphIsDirected true if the graph is directed, false otherwise.
         */
        public InnerVertex(V elem, boolean graphIsDirected) {
            element = elem;
            outgoing = new ProbeHashMap<>();
            if (graphIsDirected) {
                incoming = new ProbeHashMap<>();
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

        public Map<Vertex<V>, Edge<E>> getOutgoing() {
            return outgoing;
        }

        public Map<Vertex<V>, Edge<E>> getIncomimg() {
            return incoming;
        }
    }

    /**
     * Inner class representing an edge in the graph.
     *
     * @param <E> The type of element stored in the edge.
     */
    class InnerEdge<E> implements Edge<E> {
        E element;
        Position<Edge<E>> pos;
        Vertex<V>[] endpoints;

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

        public void setPosition(Position<Edge<E>> p) {
            pos = p;
        }

        public Position<Edge<E>> getPosition() {
            return pos;
        }
    }

    boolean isDirected;
    PositionalLinkedList<Vertex<V>> vertices = new PositionalLinkedList<>();
    PositionalLinkedList<Edge<E>> edges = new PositionalLinkedList<>();

    /**
     * Constructs an empty AdjacencyMapGraph.
     *
     * @param directed true if the graph is directed, false otherwise.
     */
    public AdjacencyMapGraph(boolean directed) {
        isDirected = directed;
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return The number of vertices.
     */
    public int numVertices() {
        return vertices.size();
    }

    /**
     * Returns an iterable collection of all vertices in the graph.
     *
     * @return An iterable collection of vertices.
     */
    public Iterable<Vertex<V>> vertices() {
        return vertices.elements();
    }

    /**
     * Returns the number of edges in the graph.
     *
     * @return The number of edges.
     */
    public int numEdges() {
        return edges.size();
    }

    /**
     * Returns an iterable collection of all edges in the graph.
     *
     * @return An iterable collection of edges.
     */
    public Iterable<Edge<E>> edges() {
        return edges.elements();
    }

    /**
     * Returns the out-degree of a given vertex.
     *
     * @param v The vertex to query.
     * @return The out-degree of the vertex.
     */
    public int outDegree(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        return vert.getOutgoing().size();
    }

    /**
     * Returns an iterable collection of outgoing edges from a given vertex.
     *
     * @param v The vertex to query.
     * @return An iterable collection of outgoing edges.
     */
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        return vert.getOutgoing().valueSet();
    }

    /**
     * Returns the in-degree of a given vertex.
     *
     * @param v The vertex to query.
     * @return The in-degree of the vertex.
     */
    public int inDegree(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        return vert.getIncomimg().size();
    }

    /**
     * Returns an iterable collection of incoming edges to a given vertex.
     *
     * @param v The vertex to query.
     * @return An iterable collection of incoming edges.
     */
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        return vert.getIncomimg().valueSet();
    }

    /**
     * Returns the edge from vertex u to vertex v, if one exists.
     *
     * @param u The first vertex.
     * @param v The second vertex.
     * @return The edge from u to v, or null if no such edge exists.
     */
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        InnerVertex<V> origin = (InnerVertex<V>) u;
        return origin.getOutgoing().get(v);
    }

    /**
     * Returns the endpoints of a given edge.
     *
     * @param e The edge to query.
     * @return An array containing the two endpoints of the edge.
     */
    public Vertex<V>[] endVertices(Edge<E> e) {
        InnerEdge<E> edge = (InnerEdge<E>) e;
        return edge.getEndpoints();
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
        InnerEdge<E> edge = (InnerEdge<E>) e;
        Vertex<V>[] endpoints = edge.getEndpoints();
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
     * @param e The element to be stored in the new vertex.
     * @return The newly created vertex.
     */
    public Vertex<V> insertVertex(V e) {
        InnerVertex<V> v = new InnerVertex<>(e, isDirected);
        v.setPosition(vertices.addLast(v));
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
        if (getEdge(u, v) == null) {
            InnerEdge<E> edge = new InnerEdge<>(u, v, element);
            edge.setPosition(edges.addLast(edge));
            InnerVertex<V> origin = (InnerVertex<V>) u;
            InnerVertex<V> dest = (InnerVertex<V>) v;
            origin.getOutgoing().put(v, edge);
            dest.getIncomimg().put(u, edge);
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
        InnerVertex<V> vert = (InnerVertex<V>) v;
        for (Edge<E> e : vert.getOutgoing().valueSet()) {
            removeEdge(e);
        }
        for (Edge<E> e : vert.getIncomimg().valueSet()) {
            removeEdge(e);
        }
        vertices.remove(vert.getPosition());
    }

    /**
     * Removes a given edge from the graph.
     *
     * @param e The edge to be removed.
     */
    public void removeEdge(Edge<E> e) {
        InnerEdge<E> edge = (InnerEdge<E>) e;
        edges.remove(edge.getPosition());
    }

    /**
     * Finds and returns a vertex with the given element.
     *
     * @param value The element to search for.
     * @return The vertex with the specified element, or null if not found.
     */
    public Vertex<V> findVertex(V value) {
        for (Position<Vertex<V>> p : vertices.positions()) {
            if (p.getElement().getElement() == value) {
                return p.getElement();
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
        for (Position<Edge<E>> p : edges.positions()) {
            if (p.getElement().getElement() == value) {
                return p.getElement();
            }
        }
        return null;
    }
}
