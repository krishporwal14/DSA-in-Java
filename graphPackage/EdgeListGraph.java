package graphPackage;

import positionalListPackage.Position;
import positionalListPackage.PositionalLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a graph using an edge list representation.
 *
 * @param <V> The type of element stored in vertices.
 * @param <E> The type of element stored in edges.
 */
@SuppressWarnings("unchecked")
public class EdgeListGraph<V, E> implements Graph<V, E> {

    /**
     * Inner class representing a vertex in the graph.
     *
     * @param <V> The type of element stored in the vertex.
     */
    class InnerVertex<V> implements Vertex<V> {
        V element;
        Position<Vertex<V>> pos;

        /**
         * Constructs an InnerVertex with the given element.
         *
         * @param elem The element to be stored in the vertex.
         */
        public InnerVertex(V elem) {
            element = elem;
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

    PositionalLinkedList<Vertex<V>> vertices = new PositionalLinkedList<>();
    PositionalLinkedList<Edge<E>> edges = new PositionalLinkedList<>();

    /**
     * Constructs an empty EdgeListGraph.
     */
    public EdgeListGraph() {
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
        int count = 0;
        for (Edge<E> edge : edges()) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[0].equals(v)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns an iterable collection of outgoing edges from a given vertex.
     *
     * @param v The vertex to query.
     * @return An iterable collection of outgoing edges.
     */
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        List<Edge<E>> outgoing = new ArrayList<>();
        for (Edge<E> edge : edges()) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[0].equals(v)) {
                outgoing.add(edge);
            }
        }
        return outgoing;
    }

    /**
     * Returns the in-degree of a given vertex.
     *
     * @param v The vertex to query.
     * @return The in-degree of the vertex.
     */
    public int inDegree(Vertex<V> v) {
        int count = 0;
        for (Edge<E> edge : edges()) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[1].equals(v)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns an iterable collection of incoming edges to a given vertex.
     *
     * @param v The vertex to query.
     * @return An iterable collection of incoming edges.
     */
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        List<Edge<E>> incoming = new ArrayList<>();
        for (Edge<E> edge : edges()) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[1].equals(v)) {
                incoming.add(edge);
            }
        }
        return incoming;
    }

    /**
     * Returns the edge between two given vertices.
     *
     * @param u The first endpoint vertex.
     * @param v The second endpoint vertex.
     * @return The edge between the vertices, or null if no such edge exists.
     */
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        for (Edge<E> edge : edges()) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[0].equals(u) && e.getEndpoints()[1].equals(v)) {
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
        if (endpoints[0].equals(v)) {
            return endpoints[1];
        } else if (endpoints[1].equals(v)) {
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
        InnerVertex<V> v = new InnerVertex<>(e);
        v.setPosition(vertices.addLast(v));
        return v;
    }

    /**
     * Inserts a new edge with the given element between two given vertices into the graph.
     *
     * @param u The first endpoint vertex.
     * @param v The second endpoint vertex.
     * @param e The element to be stored in the new edge.
     * @return The newly created edge.
     */
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E e) {
        InnerEdge<E> edge = new InnerEdge<>(u, v, e);
        edge.setPosition(edges.addLast(edge));
        return edge;
    }

    /**
     * Removes a given vertex from the graph along with its incident edges.
     *
     * @param v The vertex to be removed.
     */
    public void removeVertex(Vertex<V> v) {
        for (Edge<E> e : incomingEdges(v)) {
            removeEdge(e);
        }
        for (Edge<E> e : outgoingEdges(v)) {
            removeEdge(e);
        }
        vertices.remove(((InnerVertex<V>) v).getPosition());
    }

    /**
     * Removes a given edge from the graph.
     *
     * @param e The edge to be removed.
     */
    public void removeEdge(Edge<E> e) {
        edges.remove(((InnerEdge<E>) e).getPosition());
    }

    /**
     * Finds and returns a vertex with the given element.
     *
     * @param value The element to search for.
     * @return The vertex with the specified element, or null if not found.
     */
    public Vertex<V> findVertex(V value) {
        for (Position<Vertex<V>> p : vertices.positions()) {
            if (p.getElement().getElement().equals(value)) {
                return p.getElement();
            }
        }
        return null;
    }

    /**
     * Finds and returns an edge with the given element.
     *
     * @param edge The element to search for.
     * @return The edge with the specified element, or null if not found.
     */
    public Edge<E> findEdge(E edge) {
        for (Position<Edge<E>> p : edges.positions()) {
            if (p.getElement().getElement().equals(edge)) {
                return p.getElement();
            }
        }
        return null;
    }
}
