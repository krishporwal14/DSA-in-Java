package graphPackage;

import java.util.*;


import positionalListPackage.Position;

@SuppressWarnings("unchecked")
public class AdjacencyListGraph<V, E> implements Graph<V, E> {
    private boolean isDirected;
    private Map<Vertex<V>, List<Edge<E>>> adjacencyMap;

    public AdjacencyListGraph(boolean directed) {
        isDirected = directed;
        adjacencyMap = new HashMap<>();
    }

    class InnerVertex<V> implements Vertex<V> {
        V element;
        Position<Vertex<V>> pos;
        List<Edge<E>> outgoing, incoming;
        public InnerVertex(V elem, boolean graphIsDirected) {
            element = elem;
            outgoing = new ArrayList<>();
            if(graphIsDirected) {
                incoming = new ArrayList<>();
            }
            else {
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

    class InnerEdge<E> implements Edge<E> {
        private E element;
        private Vertex<V>[] endpoints;

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

    public int numVertices() {
        return adjacencyMap.size();
    }

    public Iterable<Vertex<V>> vertices() {
        return adjacencyMap.keySet();
    }

    public int numEdges() {
        int edgeCount = 0;
        for (List<Edge<E>> edges : adjacencyMap.values()) {
            edgeCount += edges.size();
        }
        return edgeCount;
    }

    public Iterable<Edge<E>> edges() {
        List<Edge<E>> allEdges = new ArrayList<>();
        for (List<Edge<E>> edges : adjacencyMap.values()) {
            allEdges.addAll(edges);
        }
        return allEdges;
    }

    public int outDegree(Vertex<V> v) {
        return getAdjacentEdges(v).size();
    }

    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        return getAdjacentEdges(v);
    }

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

    public Vertex<V>[] endVertices(Edge<E> e) {
        return ((InnerEdge<E>) e).getEndpoints();
    }

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

    public Vertex<V> insertVertex(V element) {
        Vertex<V> v = new InnerVertex<>(element, isDirected);
        adjacencyMap.put(v, new ArrayList<>());
        return v;
    }

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

    public void removeEdge(Edge<E> e) {
        Vertex<V>[] endpoints = endVertices(e);
        adjacencyMap.get(endpoints[0]).remove(e);
        if (!isDirected) {
            adjacencyMap.get(endpoints[1]).remove(e);
        }
    }

    public Vertex<V> findVertex(V value) {
        for (Vertex<V> vertex : adjacencyMap.keySet()) {
            if (((InnerVertex<V>) vertex).getElement() == value) {
                return vertex;
            }
        }
        return null;
    }

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
