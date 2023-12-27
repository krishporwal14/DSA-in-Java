package graphPackage;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class AdjacencyMatrixGraph<V, E> implements Graph<V, E> {
    class InnerVertex<V> implements Vertex<V> {
        V element;

        public InnerVertex(V elem) {
            element = elem;
        }

        public V getElement() {
            return element;
        }
    }

    class InnerEdge<E> implements Edge<E> {
        E element;
        int u, v;

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

    public AdjacencyMatrixGraph(boolean directed) {
        isDirected = directed;
        vertices = new ArrayList<>();
        adjacencyMatrix = new ArrayList<>();
    }

    public int numVertices() {
        return vertices.size();
    }

    public Iterable<Vertex<V>> vertices() {
        List<Vertex<V>> vertexList = new ArrayList<>();
        for (InnerVertex<V> vertex : vertices) {
            vertexList.add(vertex);
        }
        return vertexList;
    }

    public int numEdges() {
        int count = 0;
        for (List<InnerEdge<E>> row : adjacencyMatrix) {
            count += row.size();
        }
        return count;
    }

    public Iterable<Edge<E>> edges() {
        List<Edge<E>> edgeList = new ArrayList<>();
        for (List<InnerEdge<E>> row : adjacencyMatrix) {
            edgeList.addAll(row);
        }
        return edgeList;
    }

    public int outDegree(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        int index = vertices.indexOf(vert);
        return adjacencyMatrix.get(index).size();
    }

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

    public Vertex<V>[] endVertices(Edge<E> e) {
        InnerEdge<E> edge = (InnerEdge<E>) e;
        InnerVertex<V> u = vertices.get(edge.u);
        InnerVertex<V> v = vertices.get(edge.v);
        return new Vertex[]{u, v};
    }

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

    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E e) {
        InnerVertex<V> origin = (InnerVertex<V>) u;
        InnerVertex<V> dest = (InnerVertex<V>) v;
        int uIndex = vertices.indexOf(origin);
        int vIndex = vertices.indexOf(dest);

        if (uIndex >= 0 && vIndex >= 0) {
            InnerEdge<E> edge = new InnerEdge<>(uIndex, vIndex, e);
            adjacencyMatrix.get(uIndex).set(vIndex, edge);
            if (!isDirected) {
                adjacencyMatrix.get(vIndex).set(uIndex, edge);
            }
            return edge;
        } else {
            throw new IllegalArgumentException("Vertices not found in the graph.");
        }
    }

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

    public Vertex<V> findVertex(V value) {
        for (InnerVertex<V> vertex : vertices) {
            if (vertex.getElement().equals(value)) {
                return vertex;
            }
        }
        return null;
    }

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
