package graphPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a graph using an adjacency matrix representation.
 *
 * @param <V> The type of element stored in vertices.
 * @param <E> The type of element stored in edges.
 */
@SuppressWarnings("unchecked")
public class AdjacencyMatrixGraph<V, E> implements Graph<V, E> {

    /**
     * Inner class representing a vertex in the graph.
     *
     * @param <V> The type of element stored in the vertex.
     */
    class InnerVertex<V> implements Vertex<V> {
        V element;

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
    }

    /**
     * Inner class representing an edge in the graph.
     *
     * @param <E> The type of element stored in the edge.
     */
    class InnerEdge<E> implements Edge<E> {
        E element;
        int u, v;

        /**
         * Constructs an InnerEdge with the given endpoints and element.
         *
         * @param u    The index of the first endpoint vertex.
         * @param v    The index of the second endpoint vertex.
         * @param elem The element to be stored in the edge.
         */
        public InnerEdge(int u, int v, E elem) {
            this.u = u;
            this.v = v;
            element = elem;
        }

        public E getElement() {
            return element;
        }

        public int[] getEndpoints() {
            return new int[]{u, v};
        }
    }

    boolean isDirected;
    List<InnerVertex<V>> vertices;
    List<List<InnerEdge<E>>> adjacencyMatrix;

    /**
     * Constructs an empty AdjacencyMatrixGraph.
     *
     * @param directed true if the graph is directed, false otherwise.
     */
    public AdjacencyMatrixGraph(boolean directed) {
        isDirected = directed;
        vertices = new ArrayList<>();
        adjacencyMatrix = new ArrayList<>();
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
        List<Vertex<V>> vertexList = new ArrayList<>();
        for (InnerVertex<V> vertex : vertices) {
            vertexList.add(vertex);
        }
        return vertexList;
    }

    /**
     * Returns the number of edges in the graph.
     *
     * @return The number of edges.
     */
    public int numEdges() {
        int count = 0;
        for (List<InnerEdge<E>> row : adjacencyMatrix) {
            count += row.size();
        }
        return count;
    }

    /**
     * Returns an iterable collection of all edges in the graph.
     *
     * @return An iterable collection of edges.
     */
    public Iterable<Edge<E>> edges() {
        List<Edge<E>> edgeList = new ArrayList<>();
        for (List<InnerEdge<E>> row : adjacencyMatrix) {
            edgeList.addAll(row);
        }
        return edgeList;
    }

    /**
     * Returns the out-degree of a given vertex.
     *
     * @param v The vertex to query.
     * @return The out-degree of the vertex.
     */
    public int outDegree(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        int index = vertices.indexOf(vert);
        return adjacencyMatrix.get(index).size();
    }

    /**
     * Returns an iterable collection of outgoing edges from a given vertex.
     *
     * @param v The vertex to query.
     * @return An iterable collection of outgoing edges.
     */
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        int index = vertices.indexOf(vert);
        List<Edge<E>> outgoingEdges = new ArrayList<>();
        for (List<InnerEdge<E>> row : adjacencyMatrix) {
            if (!row.isEmpty() && row.get(0).v == index) {
                outgoingEdges.addAll(row);
            }
        }
        return outgoingEdges;
    }

    /**
     * Returns the in-degree of a given vertex.
     *
     * @param v The vertex to query.
     * @return The in-degree of the vertex.
     */
    public int inDegree(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        int index = vertices.indexOf(vert);
        int count = 0;
        for (List<InnerEdge<E>> row : adjacencyMatrix) {
            if (!row.isEmpty() && row.get(0).v == index) {
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
        InnerVertex<V> vert = (InnerVertex<V>) v;
        int index = vertices.indexOf(vert);
        List<Edge<E>> incomingEdges = new ArrayList<>();
        for (List<InnerEdge<E>> row : adjacencyMatrix) {
            if (!row.isEmpty() && row.get(0).v == index) {
                incomingEdges.addAll(row);
            }
        }
        return incomingEdges;
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
        InnerVertex<V> dest = (InnerVertex<V>) v;
        int uIndex = vertices.indexOf(origin);
        int vIndex = vertices.indexOf(dest);

        if (uIndex >= 0 && vIndex >= 0 && uIndex < adjacencyMatrix.size()) {
            for (InnerEdge<E> edge : adjacencyMatrix.get(uIndex)) {
                if (edge.v == vIndex) {
                    return edge;
                }
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
        InnerVertex<V> u = vertices.get(edge.u);
        InnerVertex<V> v = vertices.get(edge.v);
        return new Vertex[]{u, v};
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
        int index = vertices.indexOf(v);

        if (index == edge.u) {
            return vertices.get(edge.v);
        } else if (index == edge.v) {
            return vertices.get(edge.u);
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
        vertices.add(v);
        for (List<InnerEdge<E>> row : adjacencyMatrix) {
            row.add(null);
        }
        List<InnerEdge<E>> newRow = new ArrayList<>(vertices.size());
        for (int i = 0; i < vertices.size(); i++) {
            newRow.add(null);
        }
        adjacencyMatrix.add(newRow);
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
        InnerVertex<V> origin = (InnerVertex<V>) u;
        InnerVertex<V> dest = (InnerVertex<V>) v;
        int uIndex = vertices.indexOf(origin);
        int vIndex = vertices.indexOf(dest);

        if (uIndex >= 0 && vIndex >= 0) {
            InnerEdge<E> edge = new InnerEdge<>(uIndex, vIndex, element);
            adjacencyMatrix.get(uIndex).set(vIndex, edge);
            if (!isDirected) {
                adjacencyMatrix.get(vIndex).set(uIndex, edge);
            }
            return edge;
        } else {
            throw new IllegalArgumentException("Vertices not found in the graph.");
        }
    }

    /**
     * Removes a given vertex from the graph along with its incident edges.
     *
     * @param v The vertex to be removed.
     */
    public void removeVertex(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        int index = vertices.indexOf(vert);

        if (index >= 0) {
            vertices.remove(index);
            adjacencyMatrix.remove(index);
            for (List<InnerEdge<E>> row : adjacencyMatrix) {
                row.remove(index);
            }
        }
    }

    /**
     * Removes a given edge from the graph.
     *
     * @param e The edge to be removed.
     */
    public void removeEdge(Edge<E> e) {
        InnerEdge<E> edge = (InnerEdge<E>) e;
        int uIndex = edge.u;
        int vIndex = edge.v;

        if (uIndex >= 0 && vIndex >= 0 && uIndex < adjacencyMatrix.size()) {
            adjacencyMatrix.get(uIndex).set(vIndex, null);
            if (!isDirected) {
                adjacencyMatrix.get(vIndex).set(uIndex, null);
            }
        }
    }

    /**
     * Finds and returns a vertex with the given element.
     *
     * @param value The element to search for.
     * @return The vertex with the specified element, or null if not found.
     */
    public Vertex<V> findVertex(V value) {
        for (InnerVertex<V> vertex : vertices) {
            if (vertex.getElement().equals(value)) {
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
        for (List<InnerEdge<E>> row : adjacencyMatrix) {
            for (InnerEdge<E> edge : row) {
                if (edge != null && edge.getElement().equals(value)) {
                    return edge;
                }
            }
        }
        return null;
    }
}
